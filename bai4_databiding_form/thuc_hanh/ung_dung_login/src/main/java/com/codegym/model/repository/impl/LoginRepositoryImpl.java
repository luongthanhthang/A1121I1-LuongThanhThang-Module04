package com.codegym.model.repository.impl;

import com.codegym.model.entity.Login;
import com.codegym.model.entity.User;
import com.codegym.model.repository.ILoginRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginRepositoryImpl implements ILoginRepository {
    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("John");
        u1.setAccount("thang1");
        u1.setEmail("john@codegym.vn");
        u1.setPassword("123456");
        userList.add(u1);

        User u2 = new User();
        u2.setAge(15);
        u2.setName("Bill");
        u2.setAccount("thang2");
        u2.setEmail("bill@codegym.vn");
        u2.setPassword("123456");
        userList.add(u2);

        User u3 = new User();
        u3.setAge(16);
        u3.setName("Mike");
        u3.setAccount("thang3");
        u3.setEmail("mike@codegym.vn");
        u3.setPassword("123456");
        userList.add(u3);
    }

    @Override
    public User checkLogin(Login login) {
        for (User u : userList) {
            if (u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())) {
                return u;
            }
        }
        return null;
    }
}
