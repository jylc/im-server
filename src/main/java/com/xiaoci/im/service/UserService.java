package com.xiaoci.im.service;

import com.xiaoci.im.constant.ExceptionMessage;
import com.xiaoci.im.constant.UserConstant;
import com.xiaoci.im.entity.dto.RegisterDTO;
import com.xiaoci.im.entity.po.User;
import com.xiaoci.im.entity.po.UserExample;
import com.xiaoci.im.exception.user.UserException;
import com.xiaoci.im.mapper.UserMapper;
import com.xiaoci.im.utils.DateUtils;
import com.xiaoci.im.utils.SHA256Utils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void register(RegisterDTO registerDTO) {
        verify(registerDTO.getPassword());
        User user = new User();
        user.setTelephone(registerDTO.getTelephone());
        user.setPassword(SHA256Utils.getSHA256(registerDTO.getPassword()));
        user.setNickname(registerDTO.getTelephone());
        user.setSex(UserConstant.FEMALE);
        user.setCreatedTime(DateUtils.getNowDate());

        int i = userMapper.insert(user);
        if (i < 1) {
            throw new UserException("注册失败");
        }
    }

    private void verify(String telephone) {
        UserExample example = new UserExample();
        example.createCriteria().andTelephoneEqualTo(telephone);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0) {
            throw new UserException(ExceptionMessage.TELEPHONE_HAS_EXIST);
        }
    }
}
