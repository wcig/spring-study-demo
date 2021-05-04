package com.wcig.app.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wcig.app.dao.UserMapper;
import com.wcig.app.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}
