package com.codegym.model.repository;

import com.codegym.model.entity.Login;
import com.codegym.model.entity.User;

public interface ILoginRepository {
     User checkLogin(Login login);
}
