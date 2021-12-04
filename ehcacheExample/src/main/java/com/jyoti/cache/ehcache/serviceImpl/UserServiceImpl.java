package com.jyoti.cache.ehcache.serviceImpl;

import com.jyoti.cache.ehcache.dto.Users;
import com.jyoti.cache.ehcache.repository.UserRepository;
import com.jyoti.cache.ehcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    @Cacheable(value = "usersCache", key = "#id")
    public Users getUser(Long id) {
        System.out.println("Retrieving from Database for id :" + id);
        return userRepository.findById(id).get();
    }

    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }
}
