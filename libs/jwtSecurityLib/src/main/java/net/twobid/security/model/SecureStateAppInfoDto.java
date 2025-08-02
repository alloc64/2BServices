/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.binary.Hex;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class SecureStateAppInfoDto {
    private String packageName;
    private String versionName;
    private int versionCode;
    private List<String> fingerprints;

    public static SecureStateAppInfoDto from(byte[] bytes) throws Exception {
        int offset = 0;

        int packageNameLength = bytes[offset++];
        String packageName = new String(bytes, offset, packageNameLength);
        offset += packageNameLength;

        int versionNameLength = bytes[offset++];
        String versionName = new String(bytes, offset, versionNameLength);
        offset += versionNameLength;

        int versionCode = bytes[offset++];

        int fingerprintsCount = bytes[offset++];
        List<String> fingerprints = new ArrayList<>();
        for (int i = 0; i < fingerprintsCount; i++) {
            int fingerprintLength = bytes[offset++];
            byte[] fingerprint = new byte[fingerprintLength];
            System.arraycopy(bytes, offset, fingerprint, 0, fingerprintLength);
            fingerprints.add(Hex.encodeHexString(fingerprint));
            offset += fingerprintLength;
        }

        return new SecureStateAppInfoDto(packageName, versionName, versionCode, fingerprints);
    }
}
