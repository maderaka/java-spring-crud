package com.rakateja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by rakateja on 8/22/15.
 * @author Raka Teja
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String args[]) {
        ConfigurableApplicationContext container
                = SpringApplication.run(Application.class, args);
    }

    @Bean
    public PasswordEncoder passwordHelper() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
