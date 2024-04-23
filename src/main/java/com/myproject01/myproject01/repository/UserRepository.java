package com.myproject01.myproject01.repository;

import com.myproject01.myproject01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<User, Long> {
}
