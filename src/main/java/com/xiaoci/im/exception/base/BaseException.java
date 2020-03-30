package com.xiaoci.im.exception.base;

public class BaseException extends RuntimeException {

    /**
     * 模块
     */
    private String module;
    /**
     * 错误信息
     */
    private String message;
    /**
     * 参数集
     */
    private Object[] args;

    public BaseException(String module, String message) {
        this(module, message, null);
    }

    public BaseException(String module, String message, Object[] args) {
        this.module = module;
        this.message = message;
        this.args = args;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
