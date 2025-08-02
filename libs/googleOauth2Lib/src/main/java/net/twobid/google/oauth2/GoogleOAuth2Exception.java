/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.google.oauth2;

public class GoogleOAuth2Exception extends Exception {

    public GoogleOAuth2Exception() {
    }

    public GoogleOAuth2Exception(String message) {
        super(message);
    }

    public GoogleOAuth2Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public GoogleOAuth2Exception(Throwable cause) {
        super(cause);
    }

    public GoogleOAuth2Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
