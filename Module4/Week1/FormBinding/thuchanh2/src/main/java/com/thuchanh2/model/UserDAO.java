package com.thuchanh2.model;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final List<User> userList;

    static {
        userList = new ArrayList<>();
        userList.add(new User("john", "123456", "John", "john@codegym.vn", 18));
        userList.add(new User("bill", "123456", "Bill", "bill@codegym.vn", 20));
        userList.add(new User("mike", "123456", "Mike", "mike@codegym.vn", 22));
    }

    public static User checkLogin(Login login) {
        for (User user : userList) {
            if (user.getAccount().equals(login.getAccount())
                    && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}