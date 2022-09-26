package com.program.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.program.desafio.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
