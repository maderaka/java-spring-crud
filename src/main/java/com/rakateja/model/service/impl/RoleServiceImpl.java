package com.rakateja.model.service.impl;

import com.rakateja.model.entity.Role;
import com.rakateja.model.repository.RoleRepository;
import com.rakateja.model.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rakateja on 8/23/15.
 *
 * @author Raka Teja
 */

@Service(value = "role")
public class RoleServiceImpl implements RoleService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleRepository roleRepository;

    public Role update(Integer id, Role role) {
        Role r = roleRepository.findOne(id);
        role.setId(r.getId());
        return roleRepository.save(role);
    }

    public Role create(Role role) {
        log.info("Role title => " + role.getTitle());
        return roleRepository.save(role);
    }

    public List<Role> findAll() {
        return (List<Role>) roleRepository.findAll();
    }

    public Role findById(Integer id) {
        return roleRepository.findOne(id);
    }

    public void delete(Integer id) {
        roleRepository.delete(id);
    }
}
