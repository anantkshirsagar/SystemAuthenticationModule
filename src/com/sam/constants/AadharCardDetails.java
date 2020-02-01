package com.sam.constants;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PrintLetterBarcodeData")
public class AadharCardDetails {
	@XmlAttribute
	private String uid;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String gender;
	@XmlAttribute
	private String yob;
	@XmlAttribute
	private String co;
	@XmlAttribute
	private String house;
	@XmlAttribute
	private String street;
	@XmlAttribute
	private String lm;
	@XmlAttribute
	private String loc;
	@XmlAttribute
	private String vtc;
	@XmlAttribute
	private String po;
	@XmlAttribute
	private String dist;
	@XmlAttribute
	private String subdist;
	@XmlAttribute
	private String state;
	@XmlAttribute
	private String pc;
	@XmlAttribute
	private String dob;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getYob() {
		return yob;
	}

	public void setYob(String yob) {
		this.yob = yob;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLm() {
		return lm;
	}

	public void setLm(String lm) {
		this.lm = lm;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getVtc() {
		return vtc;
	}

	public void setVtc(String vtc) {
		this.vtc = vtc;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getSubdist() {
		return subdist;
	}

	public void setSubdist(String subdist) {
		this.subdist = subdist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AadharCardDetails [uid=");
		builder.append(uid);
		builder.append(", name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", yob=");
		builder.append(yob);
		builder.append(", co=");
		builder.append(co);
		builder.append(", house=");
		builder.append(house);
		builder.append(", street=");
		builder.append(street);
		builder.append(", lm=");
		builder.append(lm);
		builder.append(", loc=");
		builder.append(loc);
		builder.append(", vtc=");
		builder.append(vtc);
		builder.append(", po=");
		builder.append(po);
		builder.append(", dist=");
		builder.append(dist);
		builder.append(", subdist=");
		builder.append(subdist);
		builder.append(", state=");
		builder.append(state);
		builder.append(", pc=");
		builder.append(pc);
		builder.append(", dob=");
		builder.append(dob);
		builder.append("]");
		return builder.toString();
	}
}
