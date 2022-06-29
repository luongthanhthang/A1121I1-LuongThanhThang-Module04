package com.codegym.model.service.impl;

import com.codegym.model.entity.Login;
import com.codegym.model.entity.User;
import com.codegym.model.repository.ILoginRepository;
import com.codegym.model.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {
    private ILoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(ILoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public User checkLogin(Login login) {
        return loginRepository.checkLogin(login);
    }
}
