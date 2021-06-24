package com.example.sercuritydemo.config;

import com.example.sercuritydemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginService loginService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
            方式1： 从内存配置登录信息

         */
//        auth.inMemoryAuthentication()
//                .withUser("lirui")
//                .password("LRlr0514")
//                .authorities("ADMIN");
        /*
            方式2： 从数据库中获取登录信息
         */
        //auth.userDetailsService(loginService);

        http
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().and()
                    .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("lirui")
                //密码前面的{noop}表示的是指定的PasswordEncoder
                .password("{noop}LRlr0514").roles("USER");
    }
}


