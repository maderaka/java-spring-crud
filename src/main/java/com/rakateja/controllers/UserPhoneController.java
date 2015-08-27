package com.rakateja.controllers;

import com.rakateja.model.entity.Phone;
import com.rakateja.model.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rakateja on 8/24/15.
 *
 * UserPhoneController class
 * @author Raka Teja
 */

@Controller
@ResponseBody
@RequestMapping(
        value = "/users/{users}/phones",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserPhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Phone> index(@PathVariable("users") Long users) {
        return phoneRepository.findByUserId(users);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Phone create(@PathVariable("users") Long users, @RequestBody Phone phone) {
        phone.getUser().setId(users);
        return phoneRepository.save(phone);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Phone update(@PathVariable("users") Long users, @PathVariable Long id, @RequestBody Phone phone){
        return
    }
}
