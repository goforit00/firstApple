package com.goforit.firstapple.common.service;

/**
 * Created by junqingfjq on 16/6/23.
 */
public enum MailContextGeneratorUtil {

    INSTANCE {

        //TODO to get from db
        private static final String host = "127.0.0.1";

        @Override
        public String generatorUserRegisterMail(String username, String token) {

            StringBuilder sb = new StringBuilder();
            sb.append(host).append("?").append("username=").append(username).append("&")
                .append("token=").append(token);

            return sb.toString();
        }
    };

    abstract public String generatorUserRegisterMail(String username, String token);
}
