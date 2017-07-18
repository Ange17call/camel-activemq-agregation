package com.distribuida.process;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.distribuida.model.City;

import com.distribuida.model.District;

public class DistrictAggregationStrategy implements AggregationStrategy {

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		
		City city=newExchange.getIn().getBody(City.class);
		
		if(oldExchange==null){
			District district=new District(city.getDistrict());
			district.addCityInhabitants(city);
			newExchange.getIn().setBody(district);
			return newExchange;
			
		}
		else{
			District district = oldExchange.getIn().getBody(District.class);
			district.addCityInhabitants(city);
			return oldExchange;
		}
	}

}
