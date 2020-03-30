package com.xiaoci.im.exception.user;

import com.xiaoci.im.exception.base.BaseException;

public class UserException extends BaseException {
    public UserException(String message) {
        super("user", message);
    }
}
