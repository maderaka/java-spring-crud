package com.rakateja.controllers;

import com.rakateja.model.entity.User;
import com.rakateja.model.service.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by rakateja on 8/23/15.
 *
 * AuthController class
 * @author Raka Teja
 */

@Controller
@ResponseBody
@RequestMapping(value = "/auth",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    private Account account;
    private PasswordEncoder passwordEncoder;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AuthController(Account account, PasswordEncoder passwordEncoder) {
        this.account = account;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signup(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return account.create(user);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public User signin(@RequestBody User user) {
        String email = user.getEmail();
        String password = passwordEncoder.encode(user.getPassword());
        log.info("Email => " + email);
        log.info("Password => " + password);
        User u = account.findByEmailAndPassword(email,password);

        log.info("Email => " + u.getEmail());
        log.info("Password => " + u.getPassword());
        return u;
    }
}
