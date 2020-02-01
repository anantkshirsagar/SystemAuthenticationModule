package com.sam.model;

import java.util.Arrays;

public class User {

	private Long id;
	private String name;
	private String email;
	private long mobileNo;
	private byte[] finger;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public byte[] getFinger() {
		return finger;
	}

	public void setFinger(byte[] finger) {
		this.finger = finger;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", mobileNo=");
		builder.append(mobileNo);
		builder.append(", finger=");
		builder.append(Arrays.toString(finger));
		builder.append("]");
		return builder.toString();
	}
}
