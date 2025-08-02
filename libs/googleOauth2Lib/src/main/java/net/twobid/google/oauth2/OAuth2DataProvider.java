/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.google.oauth2;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.oauth2.UserAuthorizer;
import com.google.auth.oauth2.UserCredentials;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.Optional;
import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
public abstract class OAuth2DataProvider<ClientType> {
    public static final String USER_ID = "userId";
    public static final String REDIRECT_URL = "redirectUrl";
    private final UserAuthorizer userAuthorizer;
    private final TwobidTokenStore tokenStore;
    private final URI loginCallbackUrl;

    protected abstract String getProviderName();

    public java.net.URL createAuthUrl(Principal principal, String redirectUrl) {
        return createAuthUrl(principal.getName(), redirectUrl, null);
    }
    public java.net.URL createAuthUrl(Principal principal, String redirectUrl, Consumer<URIBuilder> stateUriProvider) {
        return createAuthUrl(principal.getName(), redirectUrl, stateUriProvider);
    }

    @SneakyThrows
    public java.net.URL createAuthUrl(String userId, String redirectUrl, Consumer<URIBuilder> stateUriProvider) {
        URIBuilder uriBuilder = new URIBuilder("twobid://oauth2");
        uriBuilder.addParameter(USER_ID, userId);
        uriBuilder.addParameter(REDIRECT_URL, redirectUrl);
        if(stateUriProvider != null)
            stateUriProvider.accept(uriBuilder);
        return userAuthorizer.getAuthorizationUrl(null, uriBuilder.toString(), loginCallbackUrl);
    }

    protected String getUserIdFromStateUrl(URI stateUrl) {
        return URIUtils.getQueryFirstParameterFromURI(stateUrl, USER_ID);
    }

    public ResponseEntity<Void> authenticate(URI state, String code) throws GoogleOAuth2Exception {
        try {
            String redirectUrl = URIUtils.getQueryFirstParameterFromURI(state, REDIRECT_URL);
            ClientType client = createClientFromCode(state, code);
            doAuthenticate(state, code, client);

            if (StringUtils.isEmpty(redirectUrl))
                return ResponseEntity.ok().build();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", redirectUrl);
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        } catch (Exception e) {
            throw new GoogleOAuth2Exception(e);
        }
    }

    protected abstract void doAuthenticate(URI state, String code, ClientType client) throws Exception;

    private Credential asCredential(UserCredentials userCredentials) throws GoogleOAuth2Exception {
        try {
            userCredentials.refreshIfExpired();
        } catch (IOException e) {
            throw new GoogleOAuth2Exception(e);
        }

        return new GoogleCredential().setAccessToken(userCredentials.getAccessToken().getTokenValue());
    }

    protected abstract ClientType createClient(Credential credential, UserCredentials userCredentials);

    public ClientType createClient(Principal principal) throws Exception {
        UserCredentials userCredentials = userAuthorizer.getCredentials(asUserId(principal));
        return createClient(asCredential(userCredentials), userCredentials);
    }

    private ClientType createClientFromCode(URI stateUrl, String code) throws Exception {
        UserCredentials userCredentials = userAuthorizer.getAndStoreCredentialsFromCode(
                asUserId(getUserIdFromStateUrl(stateUrl)), code, loginCallbackUrl);

        return createClient(asCredential(userCredentials), userCredentials);
    }

    public <T> Optional<T> getCustomData(Principal principal, Class<T> clazz) {
        return tokenStore.getCustomData(asUserId(principal), clazz);
    }

    public <T> T saveCustomData(Principal principal, T data) throws Exception {
        return tokenStore.saveCustomData(asUserId(principal), data);
    }

    public <T> T saveCustomData(URI stateUrl, T data) throws Exception {
        return tokenStore.saveCustomData(asUserId(getUserIdFromStateUrl(stateUrl)), data);
    }

    private String asUserId(Principal principal) {
        return principal.getName() + "_" + getProviderName();
    }

    private String asUserId(String userId) {
        return userId + "_" + getProviderName();
    }
}
