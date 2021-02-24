package com.pack.PetApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owned")
public class Owned {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sno;
	private long pid;
	private long cid;
	private String name;
	private String dob;
	private String breed;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	public Owned() {
		super();
	}
	
	

	public Owned(long pid, String name, String dob, String breed, Gender gender) {
		super();
		this.pid = pid;
		this.name = name;
		this.dob = dob;
		this.breed = breed;
		this.gender = gender;
	}



	public Owned(long pid, long cid, String name, String dob, String breed, Gender gender) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.name = name;
		this.dob = dob;
		this.breed = breed;
		this.gender = gender;
	}

	public Owned(long sno, long pid, long cid, String name, String dob, String breed, Gender gender) {
		super();
		this.sno = sno;
		this.pid = pid;
		this.cid = cid;
		this.name = name;
		this.dob = dob;
		this.breed = breed;
		this.gender = gender;
	}

	public long getSno() {
		return sno;
	}

	public void setSno(long sno) {
		this.sno = sno;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Owned [sno=" + sno + ", pid=" + pid + ", cid=" + cid + ", name=" + name + ", dob=" + dob + ", breed="
				+ breed + ", gender=" + gender + "]";
	}
	
	
	

}
