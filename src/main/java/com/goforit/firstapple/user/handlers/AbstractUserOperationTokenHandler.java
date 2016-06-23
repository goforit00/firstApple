package com.goforit.firstapple.user.handlers;

import com.goforit.firstapple.common.utils.StringGenerator;
import com.goforit.firstapple.user.factory.UserOperationTokenHandlerFactory;
import com.goforit.firstapple.user.model.enums.UserOperationType;
import org.springframework.beans.factory.InitializingBean;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by junqingfjq on 16/6/23.
 */
abstract public class AbstractUserOperationTokenHandler implements UserOperationTokenHandler,InitializingBean {

    abstract protected int getTokenLen();

    abstract protected int getDuration();

    abstract protected UserOperationType getUserOperationType();



    public String buildToken(){
        return StringGenerator.generator(getTokenLen());
    }



    public Date getExpiredTime(){

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND,getDuration());

        Date expiredDate=calendar.getTime();

        return expiredDate;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        UserOperationTokenHandlerFactory.INSTANCE.register(this.getUserOperationType(),this);
    }
}
