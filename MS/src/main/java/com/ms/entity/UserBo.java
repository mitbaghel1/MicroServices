package com.ms.entity;

import java.util.Date;
import java.util.Objects;

public class UserBo {

	private int id;
	private String firstName;
	private Date dateOfBirth;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "UserBo [id=" + id + ", firstName=" + firstName + ", dateOfBirth=" + dateOfBirth + ", getId()=" + getId()
				+ ", getFirstName()=" + getFirstName() + ", getDateOfBirth()=" + getDateOfBirth() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, firstName, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBo other = (UserBo) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(firstName, other.firstName)
				&& id == other.id;
	}
	
	
}