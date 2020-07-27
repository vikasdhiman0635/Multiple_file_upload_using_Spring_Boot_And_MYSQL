package com.example.vikas.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.vikas.model.UserFiles;

public interface UserFileRepo extends JpaRepository<UserFiles, Long> 
{
	
//	@Query("select f from UserFiles as f which f.user.id=?1")
	List<UserFiles> findFilesByUserId(Long userId);

}
