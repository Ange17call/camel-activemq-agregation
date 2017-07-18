package com.distribuida.process;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.BindyType;

import com.distribuida.model.City;
import com.distribuida.model.District;


public class MyRouteBuilder extends RouteBuilder {

	
	public void configure() throws JAXBException{
		from("file:data/in?fileName=cities.csv&noop=true")
		.unmarshal().bindy(BindyType.Csv, City.class)
		.split().body()
		.setHeader("district",simple("${body.district}"))
		.aggregate(header("district"),new DistrictAggregationStrategy())
		.completionTimeout(1000)
		.aggregate(constant(true), new DistrictsAggregationStrategy())
		.completionTimeout(10000)
		.marshal(new JaxbDataFormat(
				JAXBContext.newInstance(District.class,DistrictCollection.class)))
		.to("file:data/out?fileName=districts.xml&fileExist=Override");
	}

}
