package com.example.demolibraryprojectx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER","ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST, "/api/Book/add").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/Book/delete").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/Book/getAll").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/Book/getByDto").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/Book/getByName").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/Book/getByAuthor").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/Book/getByGenre").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/Book/{search}/search").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
