package com.example.restmysql.security;

import com.example.restmysql.models.UserModel;
import com.example.restmysql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel user = userRepository
                .findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " does not exist"));

        return new UserDetailsImpl(user);
    }

}
