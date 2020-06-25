package com.example.springsecurityform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class DemoWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // AUTHORIZE
                .authorizeRequests()
                    .mvcMatchers("/hello").permitAll()
                    .anyRequest()
                        .authenticated()
                .and()
                // LOGIN
                .formLogin()
                    .defaultSuccessUrl("/success");
    }
}
