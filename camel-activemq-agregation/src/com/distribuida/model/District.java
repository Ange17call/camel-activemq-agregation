package com.distribuida.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class District {
	@XmlAttribute(name="name")
	private String name;
	@XmlAttribute(name="inhabitants")
	private int inhabitants;
	
	private District(){
	}
	
	public District(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getInhabitants() {
		return inhabitants;
	}
	
	public void addCityInhabitants(City city){
		inhabitants+=city.getInhabitants();
	}

}
