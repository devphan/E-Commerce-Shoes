package com.ecommerce.shoes.security.jwt;

import com.ecommerce.shoes.entity.User;
import com.ecommerce.shoes.repository.UserRepository;
import com.ecommerce.shoes.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        User user = userRepository.findByEmail(email);
//        if (user != null) {
//            return new CustomUserDetails(user);
//        } else {
//            throw new UsernameNotFoundException("Email: " + email + " does not exist.");
//        }

        if (user == null) {
            throw new UsernameNotFoundException("Email: " + email + " does not exist.");
        }
        String role = user.getRole();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));
        return new CustomUserDetails(user);
    }

    @Transactional
    public UserDetails loadUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        String role = user.getRole();
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));
        return new CustomUserDetails(user);
    }
}