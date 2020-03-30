package com.xiaoci.im.controller;

import com.xiaoci.im.constant.ExceptionMessage;
import com.xiaoci.im.constant.Regex;
import com.xiaoci.im.domain.AjaxResult;
import com.xiaoci.im.entity.dto.RegisterDTO;
import com.xiaoci.im.exception.user.UserException;
import com.xiaoci.im.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterDTO registerDTO) {
        verify(registerDTO.getTelephone(), registerDTO.getPassword());
        userService.register(registerDTO);
        return AjaxResult.success();
    }

    /**
     * 验证手机号和密码格式
     *
     * @param telephone 手机号
     * @param password  密码
     */
    private void verify(String telephone, String password) {
        if (!Pattern.matches(Regex.TELEPHONE, telephone)) {
            throw new UserException(ExceptionMessage.TELEPHONE_INCORRECT);
        }
        if (!Pattern.matches(Regex.STRONG_PASSWORD, password)) {
            throw new UserException(ExceptionMessage.PASSWORD_NOT_STRONG);
        }
    }
}
