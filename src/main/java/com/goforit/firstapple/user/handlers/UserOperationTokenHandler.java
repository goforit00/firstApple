package com.goforit.firstapple.user.handlers;

import java.util.Date;

/**
 * Created by junqingfjq on 16/6/23.
 */
public interface UserOperationTokenHandler {

    Date getExpiredTime();

    String buildToken();
}
