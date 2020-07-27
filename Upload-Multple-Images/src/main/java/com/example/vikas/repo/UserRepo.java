package com.example.vikas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vikas.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Long>
{

}
