package com.api.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.login.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
