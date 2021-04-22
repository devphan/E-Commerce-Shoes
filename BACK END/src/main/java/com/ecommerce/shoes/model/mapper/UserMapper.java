package com.ecommerce.shoes.model.mapper;

import com.ecommerce.shoes.entity.User;
import com.ecommerce.shoes.model.dto.UserDto;
import com.ecommerce.shoes.model.request.CreateUserReq;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setPhone(user.getPhone());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getRole());
        return tmp;
    }

    public static User toUser(CreateUserReq req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPhone(req.getPhone());
        //Ma hoa mat khau
        String hash = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);

        //Mặc định người dùng đăng kí sẽ là ROLE_USER
        user.setRole("USER");

        return user;
    }
}
