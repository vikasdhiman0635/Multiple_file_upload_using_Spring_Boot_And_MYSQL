package com.example.vikas.ServiceImplement;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vikas.model.UserFiles;
import com.example.vikas.model.UserModel;
import com.example.vikas.repo.UserFileRepo;
import com.example.vikas.repo.UserRepo;
import com.example.vikas.service.UploadPathService;
import com.example.vikas.service.UserService;

@Service
public class UserServiceImplements implements UserService
{
	
	@Autowired
	UserRepo repo;

	@Autowired
	UploadPathService uploadpathservice;
	
	@Autowired
	UserFileRepo userfilerepo;
	
	@Override
	public List<UserModel> getallusers() {
		// TODO Auto-generated method stub
		return (List<UserModel>) repo.findAll();
	}

	@Override
	public UserModel save(UserModel user) {
		// TODO Auto-generated method stub
		user.setCreatedate(new Date());
		UserModel dbUser = repo.save(user);
		if(dbUser!=null && user.getFiles()!=null && user.getFiles().size()>0)
		{
			for(MultipartFile file:user.getFiles())
			{
				String filename=file.getOriginalFilename();
				String modifiedfilename = FilenameUtils.getBaseName(filename)+" "+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
				File storefile = uploadpathservice.getfilepath(modifiedfilename,"images");
				if(storefile!=null)
				{
					try
					{
						FileUtils.writeByteArrayToFile(storefile, file.getBytes());
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				UserFiles files=new UserFiles();
				files.setFileext(FilenameUtils.getExtension(filename));
				files.setFilename(filename);
				files.setModifedfilename(modifiedfilename);
				files.setUser(dbUser);
				userfilerepo.save(files);
			}
		}
		return dbUser;
	}

	@Override
	public UserModel findById(Long userId) 
	{
		// TODO Auto-generated method stub
		Optional<UserModel> user=repo.findById(userId);
		if(user.isPresent())
		{
			return user.get();
		}
		return null;
	}

	@Override
	public List<UserFiles> findFilesById(Long userId) 
	{
		// TODO Auto-generated method stub
		return userfilerepo.findFilesByUserId(userId);
	}

}
