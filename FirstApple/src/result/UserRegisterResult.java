package result;

import java.io.Serializable;

import enums.ResultEnum;

public class UserRegisterResult <T> implements Serializable {

    /**  */
    private static final long serialVersionUID = -2205744496885300266L;

    /** ���ؽ������ */
    private T                 result;

    /** ������� */
    private ResultEnum        userRegisterResult;

    /** �������� */
    private String            errorDetail;

    
    public UserRegisterResult(T result,ResultEnum resultEnum,String errorDetail)
    {
        this.result=result;
        this.userRegisterResult = resultEnum;
        this.errorDetail=errorDetail;
    }
 
    /**
     * Getter method for property <tt>result</tt>.
     * 
     * @return property value of result
     */
    public T getResult() {
        return result;
    }

    /**
     * Setter method for property <tt>result</tt>.
     * 
     * @param result value to be assigned to property result
     */
    public void setResult(T result) {
        this.result = result;
    }

    /**
     * Getter method for property <tt>errorDetail</tt>.
     * 
     * @return property value of errorDetail
     */
    public String getErrorDetail() {
        return errorDetail;
    }

    /**
     * Setter method for property <tt>errorDetail</tt>.
     * 
     * @param errorDetail value to be assigned to property errorDetail
     */
    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    /**
     * Getter method for property <tt>userRegisterResult</tt>.
     * 
     * @return property value of userRegisterResult
     */
    public ResultEnum getUserRegisterResult() {
        return userRegisterResult;
    }

    /**
     * Setter method for property <tt>userRegisterResult</tt>.
     * 
     * @param userRegisterResult value to be assigned to property userRegisterResult
     */
    public void setUserRegisterResult(ResultEnum userRegisterResult) {
        this.userRegisterResult = userRegisterResult;
    }
}
