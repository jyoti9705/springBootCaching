package com.jyoti.cache.ehcache.repository;

import com.jyoti.cache.ehcache.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users ,Long > {
}
