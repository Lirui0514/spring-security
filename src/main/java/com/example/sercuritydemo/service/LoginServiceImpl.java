package com.example.sercuritydemo.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //自定义实现认证的流程  以下信息可以从数据库中查询，暂时用临时代码替代
        if (!"lirui".equals(name)) {
            return null;
        }

        List<GrantedAuthority> authorityList = new ArrayList();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ROOT");

        authorityList.add(authority);

        User user = new User(name, "{noop}LRlr0514", authorityList);

        return user;


    }
}
