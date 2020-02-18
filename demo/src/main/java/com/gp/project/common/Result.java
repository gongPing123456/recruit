package com.gp.project.common;

import java.io.Serializable;

/**
 * @time 2019/9/12 11:34
 * @Author gp
 * 返回的类结构
 */
public class Result  implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 返回码
     */
    private int code;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private Object data;

    public Result(){

    }

    /**
     * 返回成功的消息
     * @param result
     */
    public  static  void success(Result result,Object data){
        result.setCode(MsgCode.CURRECT.getCode());
        result.setMessage(MsgCode.CURRECT.getMessage());
        result.setData(data);
    }

    /**
     * 返回失败信息
     * @param result
     * @param msgCode
     */
    public  static  void error(Result result,MsgCode msgCode){
        result.setCode(msgCode.getCode());
        result.setMessage(msgCode.getMessage());
    }


    public Result(boolean isSuccess, String errorMessage){
        if(isSuccess){
            code = Constants.GLOBAL_NORMAL_STATUS_INT;
            this.message = null;
        }else{
            code = Constants.GLOBAL_ERROR_STATUS_INT;
            this.message = errorMessage;
        }
    }

    public Result(boolean isSuccess, String errorMessage, Object data){
        if(isSuccess){
            code = Constants.GLOBAL_NORMAL_STATUS_INT;
            this.message = null;
            this.data = data;
        }else{
            code = Constants.GLOBAL_ERROR_STATUS_INT;
            this.message = errorMessage;
            this.data = null;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}