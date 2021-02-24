package com.pack.PetApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uid;
	private String username;
	private String password;
	private String confirmPassword;
	
	public User() {
		super();
	}
	
	

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public User(String username, String password, String confirmPassword) {
		super();
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public User(long uid, String username, String password, String confirmPassword) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}
	
	

}
