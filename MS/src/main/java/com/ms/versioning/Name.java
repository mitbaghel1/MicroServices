package com.ms.versioning;

public class Name {
	private String fisrtName;
	private String lsatName;
	public String getFisrtName() {
		return fisrtName;
	}
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}
	public String getLsatName() {
		return lsatName;
	}
	public void setLsatName(String lsatName) {
		this.lsatName = lsatName;
	}
	public Name(String fisrtName, String lsatName) {
		super();
		this.fisrtName = fisrtName;
		this.lsatName = lsatName;
	}
	
	
}
