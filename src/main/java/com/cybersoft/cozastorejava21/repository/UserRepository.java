package com.cybersoft.cozastorejava21.repository;

import com.cybersoft.cozastorejava21.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    // @Query("from users where email = ?1")
    // List<UserEntity> getUserbyEmail(String email);
    UserEntity findByEmail(String email);
}
