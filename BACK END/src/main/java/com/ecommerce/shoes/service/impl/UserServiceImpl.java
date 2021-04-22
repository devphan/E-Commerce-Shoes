package com.ecommerce.shoes.service.impl;

import com.ecommerce.shoes.entity.User;
import com.ecommerce.shoes.exception.DuplicateException;
import com.ecommerce.shoes.model.mapper.UserMapper;
import com.ecommerce.shoes.model.request.CreateUserReq;
import com.ecommerce.shoes.repository.UserRepository;
import com.ecommerce.shoes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerAccount(CreateUserReq req) {
        //Check email da ton tai trong DB chua
        User user = userRepository.findByEmail(req.getEmail());
        if (user != null) {
            throw new DuplicateException("Email này đã tồn tại trong hệ thống, vui lòng sử dụng Email khác");
        }
        user = UserMapper.toUser(req);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
