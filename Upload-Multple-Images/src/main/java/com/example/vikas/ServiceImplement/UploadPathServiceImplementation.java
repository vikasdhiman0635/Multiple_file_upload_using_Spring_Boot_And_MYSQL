package com.example.vikas.ServiceImplement;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vikas.service.UploadPathService;

@Service
public class UploadPathServiceImplementation implements UploadPathService
{

	@Autowired
	ServletContext context;
	
	@Override
	public File getfilepath(String modifiedfilename, String path) {
		// TODO Auto-generated method stub
		boolean exists = new File(context.getRealPath("/"+path+"/")).exists();
		if(!exists)
		{
			new File(context.getRealPath("/"+path+"/")).mkdir();
		}
		String modifiedfilepath = context.getRealPath("/"+path+"/"+File.separator+modifiedfilename);
		File file=new File(modifiedfilepath);
		return file;
	}

}
