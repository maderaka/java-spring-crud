package com.rakateja.model.service;

import com.rakateja.model.entity.Role;

import java.util.List;

/**
 * Created by rakateja on 8/23/15.
 *
 * RoleService interface
 * @author Raka Teja
 */
public interface RoleService {

    public Role update(Integer id, Role role);

    public Role create(Role role);

    public List<Role> findAll();

    public Role findById(Integer id);

    public void delete(Integer id);
}
