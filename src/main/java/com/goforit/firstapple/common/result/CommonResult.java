package com.goforit.firstapple.common.result;

import java.io.Serializable;

/**
 * Created by junqingfjq on 16/6/23.
 */
public class CommonResult implements Serializable{

    private static final long serialVersionUID = -3592716721603736868L;
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 错误信息
     */
    private String errorMsg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
