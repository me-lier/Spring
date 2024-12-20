package com.Srinivas.Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="studenttable")
public class Student {
	
	
	@Id
	private int ID;
//	@Transient
	private String name;
	
	public int getId() {
		return ID;
	}
	public void setId(int id) {
		this.ID = id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", name=" + name + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
