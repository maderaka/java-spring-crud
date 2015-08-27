package com.rakateja.controllers;

import com.rakateja.model.entity.Role;
import com.rakateja.model.repository.RoleRepository;
import com.rakateja.model.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rakateja on 8/23/15.
 *
 * RoleController class
 * @author Raka Teja
 */

@Controller
@ResponseBody
@RequestMapping(value = "/roles")
public class RoleController {

    private RoleService roleService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RoleController(
            RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     *
     * @return List of roles
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> index() {
        return (List<Role>) this.roleService.findAll();
    }

    /**
     *
     * @param id Integer
     * @return RoleServiceImpl entity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Role view(@PathVariable Integer id) {
        return this.roleService.findById(id);
    }

    /**
     *
     * @param role RoleServiceImpl
     * @return RoleServiceImpl entity which just created
     */
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Role create(@RequestBody Role role) {
        log.info("Role title => " + role.getTitle());
        return this.roleService.create(role);
    }

    /**
     *
     * @param id Integer
     * @return RoleServiceImpl entity which just updated
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Role update(@PathVariable Integer id, @RequestBody Role role) {
        return this.roleService.update(id, role);
    }
}
