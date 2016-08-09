package com.byteslounge.spring.tx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USER")

public class User {

private String name;

private String username;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

	

	
	
	
}
