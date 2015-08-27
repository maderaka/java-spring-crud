package com.rakateja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by rakateja on 8/22/15.
 * @author Raka Teja
 */

@Controller
public class PingController {

    @Autowired
    public DataSource dataSource;

    @RequestMapping("/ping")
    public String index(@RequestParam(value = "name", required=false, defaultValue = "Pong") String name, Model model) {
        try {
            Connection connection = dataSource.getConnection();
            if(connection != null){
                model.addAttribute("name", "Koneksi Masuk");
            } else {
                model.addAttribute("name", "Koneksi Tidak Masuk");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "ping";
    }
}
