package com.goforit.firstapple.user.handlers;

import com.goforit.firstapple.user.model.enums.UserOperationType;
import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * Created by junqingfjq on 16/6/24.
 */

public class UserLoginOperationHeaderTokenHandler extends AbstractUserOperationTokenHandler {

    public static final int duration = 60 * 60 * 1;

    @Override
    protected int getTokenLen() {
        return 0;
    }

    @Override
    protected int getDuration() {
        return duration;
    }

    @Override
    protected UserOperationType getUserOperationType() {
        return UserOperationType.USER_LOGIN_HEADER_TOKEN;
    }

    @Override
    public String buildToken(Object obj) {

        String userId = (String) obj;
        String data = new StringBuilder().append(String.valueOf(System.currentTimeMillis()))
            .append(userId).append(UUID.randomUUID()).toString();
        String digest = DigestUtils.md5DigestAsHex(data.getBytes());

        String token = new StringBuilder().append("hmac-").append(userId).append(":")
            .append(Base64.encode(digest.getBytes())).toString();

        return token;
    }

}
