package com.springboottest.SpringBootTest.Configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigurationBeans {

    @Bean
    public PasswordEncoder createEncoderBean() {
        return new BCryptPasswordEncoder();
    }
}
