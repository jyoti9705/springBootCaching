package com.jyoti.cache.ehcache.service;

import com.jyoti.cache.ehcache.dto.Users;

public interface UserService {

    Users getUser(Long id);

    Users saveUser(Users users);
}
