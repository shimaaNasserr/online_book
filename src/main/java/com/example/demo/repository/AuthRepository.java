package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserEntity;

public interface AuthRepository extends JpaRepository<UserEntity, Integer>{

}
