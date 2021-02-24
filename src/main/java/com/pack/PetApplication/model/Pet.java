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
@Table(name="pet")
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	private long cid;
	private String name;
	private String breed;
	private String dob;
	private double price;
	
	@Column(columnDefinition = "varchar(20) default 'available'")
	private String status;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	public Pet() {
		super();
	}

	public Pet(String name, String breed, String dob, double price, Gender gender) {
		super();
		this.name = name;
		this.breed = breed;
		this.dob = dob;
		this.price = price;
		this.gender = gender;
	}
	
	public Pet(long pid, long cid, String name, String breed, String dob, double price, String status, Gender gender) {
		super();
		this.pid = pid;
		this.cid = cid;
		this.name = name;
		this.breed = breed;
		this.dob = dob;
		this.price = price;
		this.status = status;
		this.gender = gender;
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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Pet [pid=" + pid + ", cid=" + cid + ", name=" + name + ", breed=" + breed + ", dob=" + dob + ", price="
				+ price + ", status=" + status + ", gender=" + gender + "]";
	}
	
	

}
