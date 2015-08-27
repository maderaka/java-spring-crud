package com.rakateja.model.service.impl;

import com.rakateja.model.entity.Role;
import com.rakateja.model.entity.User;
import com.rakateja.model.repository.RoleRepository;
import com.rakateja.model.repository.UserRepository;
import com.rakateja.model.service.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rakateja on 8/23/15.
 * @author Raka Teja
 */

@Service(value = "account")
public class AccountImpl implements Account{

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    @Autowired
    public AccountImpl(
            RoleRepository roleRepository,
            UserRepository userRepository) {

        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public User create(User user) {
        if(user.getRoles() == null){
            Role role = this.roleRepository.findByTitle("User");
            if(role != null) {
                List<Role> roles = new ArrayList<Role>();
                roles.add(role);
                user.setRoles(roles);
            }
        }
        return this.userRepository.save(user);
    }

    public User findByEmailAndPassword(String email, String password) {
        return this.userRepository.findByEmailAndPassword(email, password);
    }
}
