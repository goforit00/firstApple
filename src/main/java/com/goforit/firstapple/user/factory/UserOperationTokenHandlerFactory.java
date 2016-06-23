package com.goforit.firstapple.user.factory;

import com.goforit.firstapple.user.handlers.UserOperationTokenHandler;
import com.goforit.firstapple.user.model.enums.UserOperationType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by junqingfjq on 16/6/23.
 */
public enum UserOperationTokenHandlerFactory {

    INSTANCE{

        private Map<UserOperationType,UserOperationTokenHandler> hanlderMap=new ConcurrentHashMap<UserOperationType,UserOperationTokenHandler>();

        @Override
        public void register(UserOperationType type, UserOperationTokenHandler handler) {
            hanlderMap.put(type,handler);
        }

        @Override
        public UserOperationTokenHandler getHandler(UserOperationType type) {
            return hanlderMap.get(type);
        }
    };

    abstract public void register(UserOperationType type,UserOperationTokenHandler handler);

    abstract public UserOperationTokenHandler getHandler(UserOperationType type);
}
