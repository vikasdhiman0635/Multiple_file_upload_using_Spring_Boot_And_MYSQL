package com.example.vikas.service;

import java.util.List;

import com.example.vikas.model.UserFiles;
import com.example.vikas.model.UserModel;

public interface UserService {

	List<UserModel> getallusers();

	UserModel save(UserModel user);

	UserModel findById(Long userId);

	List<UserFiles> findFilesById(Long userId);

}
