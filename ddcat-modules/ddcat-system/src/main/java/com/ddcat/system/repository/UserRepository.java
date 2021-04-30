package com.ddcat.system.repository;

import com.ddcat.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author dd-cat
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
