package result;

import java.io.Serializable;

import enums.ResultEnum;

public class ReturnResult<T> implements Serializable {

    /**  */
    private static final long serialVersionUID = -9200734205832326392L;

    /** 返回结果内容 */
    private T                 result;

    /** 结果类型 */
    private ResultEnum        resultEnum;

    /** 错误详情 */
    private String            errorDetail;
    
    public ReturnResult(T result,ResultEnum resultEnum,String errorDetail)
    {
        this.result=result;
        this.resultEnum = resultEnum;
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
    public ResultEnum getResultEnum() {
        return resultEnum;
    }

    /**
     * Setter method for property <tt>userRegisterResult</tt>.
     * 
     * @param userRegisterResult value to be assigned to property userRegisterResult
     */
    public void setResultEnum(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
