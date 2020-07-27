package com.example.vikas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userfiles")
public class UserFiles implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4412902914518583794L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String filename;
	private String modifedfilename;
	private String fileext;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserModel user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getModifedfilename() {
		return modifedfilename;
	}

	public void setModifedfilename(String modifedfilename) {
		this.modifedfilename = modifedfilename;
	}

	public String getFileext() {
		return fileext;
	}

	public void setFileext(String fileext) {
		this.fileext = fileext;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
