package com.example.vikas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "user")
public class UserModel implements Serializable
{
	public UserModel() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -770983195554061232L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	public String firstname;
	public String lastname;
	public String email;
	public String phoneno;
	public Date createdate;
	public Date updatedate;
	
	@Transient//means it is storing database
	public List<MultipartFile> files=new ArrayList<MultipartFile>();
	
	@Transient
	public List<String> removeimages=new ArrayList<String>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<String> getRemoveimages() {
		return removeimages;
	}

	public void setRemoveimages(List<String> removeimages) {
		this.removeimages = removeimages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
