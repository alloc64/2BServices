/***********************************************************************
 * Copyright (c) 2022 Milan Jaitner                                    *
 * Distributed under the MIT software license, see the accompanying    *
 * file COPYING or https://www.opensource.org/licenses/mit-license.php.*
 ***********************************************************************/

package net.twobid.googleads.exceptions;

public class GoogleAdsAuthException extends Exception {
    public GoogleAdsAuthException() {
    }

    public GoogleAdsAuthException(String message) {
        super(message);
    }

    public GoogleAdsAuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoogleAdsAuthException(Throwable cause) {
        super(cause);
    }

    public GoogleAdsAuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
