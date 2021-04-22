package com.ecommerce.shoes.service;

import com.ecommerce.shoes.entity.User;
import com.ecommerce.shoes.model.request.CreateUserReq;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User registerAccount(CreateUserReq req);
    List<User> findAll();
}
