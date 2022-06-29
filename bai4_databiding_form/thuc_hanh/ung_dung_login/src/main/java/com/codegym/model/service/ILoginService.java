package com.codegym.model.service;

import com.codegym.model.entity.Login;
import com.codegym.model.entity.User;

public interface ILoginService {
     User checkLogin(Login login);
}
