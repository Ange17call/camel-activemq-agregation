package com.distribuida.process;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import com.distribuida.model.District;

public class DistrictsAggregationStrategy implements AggregationStrategy {

	
	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		District district=newExchange.getIn().getBody(District.class);
		if(oldExchange==null){
			DistrictCollection districts=new DistrictCollection();
			districts.addDistrict(district);
			newExchange.getIn().setBody(districts);
			return newExchange;
			
		}
		else{
			DistrictCollection districts =
					oldExchange.getIn().getBody(DistrictCollection.class);
			districts.addDistrict(district);
			return oldExchange;
		}
	}

}
