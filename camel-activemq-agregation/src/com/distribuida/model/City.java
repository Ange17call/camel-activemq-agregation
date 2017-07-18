package com.distribuida.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator=",",crlf="WINDOWS")
public class City {
	
	@DataField(pos=1)
	private int id;
	@DataField(pos=2)
	private String name;
	@DataField(pos=3)
	private String district;
	@DataField(pos=4)
	private int inhabitants;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDistrict() {
		return district;
	}
	public int getInhabitants() {
		return inhabitants;
	}
	
	

}
