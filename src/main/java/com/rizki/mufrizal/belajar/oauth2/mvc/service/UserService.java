package com.rizki.mufrizal.belajar.oauth2.mvc.service;

import com.rizki.mufrizal.belajar.oauth2.mvc.domain.User;

import java.util.List;

/**
 * Created by rizki on 05/02/15.
 */
public interface UserService {
    public void save(User user);
    public List<User> getUserList();
}
