package com.kpvala.userrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpvala.userrestapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
