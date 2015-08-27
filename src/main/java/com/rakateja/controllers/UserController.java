package com.rakateja.controllers;

import com.rakateja.model.dao.UserDao;
import com.rakateja.model.entity.User;
import com.rakateja.model.repository.UserRepository;
import com.rakateja.model.service.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rakateja on 8/22/15.
 * @author Raka Teja
 */

@Controller
@ResponseBody
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController{

    protected Account account;

    protected UserRepository userRepository;

    @Autowired
    public UserController(UserRepository UserRepository, Account account) {
        this.userRepository = UserRepository;
        this.account = account;
    }

    /**
     *
     * @return
     */
    @RequestMapping(method= RequestMethod.GET)
    public List<User> index() {
        List<User> list = (List<User>) this.userRepository.findAll();
        return list;
    }

    /**
     *
     * @param id Long
     * @return
     */
    @RequestMapping("/{id}")
    public User view(@PathVariable Long id) {
        User user = this.userRepository.findOne(id);
        return user;
    }

    /**
     *
     * @param user User
     * @return Json of new user object
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User create(@RequestBody User user) {
       return this.account.create(user);
    }

}
