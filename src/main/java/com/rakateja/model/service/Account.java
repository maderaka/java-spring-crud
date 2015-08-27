package com.rakateja.model.service;

import com.rakateja.model.entity.User;

/**
 * Created by rakateja on 8/23/15.
 */
public interface Account {

    public User create(User user);

    public User findByEmailAndPassword(String email, String password);
}
