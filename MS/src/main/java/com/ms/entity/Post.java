package com.ms.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore//Because recursive loop happen so use user called post and post called user
	private UserBo user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}

	public UserBo getUser() {
		return user;
	}

	public void setUser(UserBo user) {
		this.user = user;
	}
}
