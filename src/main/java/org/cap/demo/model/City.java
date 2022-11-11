package org.cap.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
	
	@Id
	private int cityid;
	private String cityname;
	private String statename;
	
	
	
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public City(int cityid, String cityname) {
		super();
		this.cityid = cityid;
		this.cityname = cityname;
	}
	public City() {
		super();
	}
	@Override
	public String toString() {
		return "City [cityid=" + cityid + ", cityname=" + cityname + ", statename=" + statename + "]";
	}
	


}
