package com.codegym.service;

import com.codegym.entity.Account;
import com.codegym.repository.security.AccountRepository;
import com.codegym.repository.security.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountRoleRepository accountRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account user = accountRepository.findById(username).orElse(null);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " không tồn tại user trong database");
        }

        List<String> roles = accountRoleRepository.findAllRoleByUser(username);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (String role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }

        UserDetails userDetails = new User(username, user.getPassword(), grantedAuthorities);
        return userDetails;
    }
}
