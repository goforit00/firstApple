package com.goforit.firstapple.common.result;

/**
 * Created by junqingfjq on 16/6/23.
 */
public class FacadeResult<T> extends CommonResult {
    private static final long serialVersionUID = 7072140831735386673L;

    private T data;

    public static <D> FacadeResult<D> success(D data){
        FacadeResult<D> result=new FacadeResult<D>();
        result.setSuccess(true);
        result.setData(data);

        return result;
    }

    public static <D> FacadeResult<D> failed(String errorMsg){
        FacadeResult<D> result=new FacadeResult<D>();
        result.setSuccess(false);
        result.setErrorMsg(errorMsg);

        return result;
    }

    public static <D> FacadeResult<D> failed(String errorMsg,D data){
        FacadeResult<D> result=new FacadeResult<D>();
        result.setErrorMsg(errorMsg);
        result.setData(data);
        result.setSuccess(false);

        return result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
