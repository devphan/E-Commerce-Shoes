package com.ecommerce.shoes;

import com.ecommerce.shoes.entity.User;
import com.ecommerce.shoes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{ //implement CommandLineRunner
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        User admin = new User();
//        admin.setName("Phan Văn Long");
//        admin.setEmail("admin@gmail.com");
//        admin.setRole("ADMIN");
//        admin.setPhone("0368280387");
//        admin.setPassword(passwordEncoder.encode("120601"));
//        userRepository.save(admin);
//        System.out.println(admin.toString());
    }
}
