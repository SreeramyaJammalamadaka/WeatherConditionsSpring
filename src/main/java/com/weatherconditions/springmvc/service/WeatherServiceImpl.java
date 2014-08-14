package com.weatherconditions.springmvc.service;

import java.io.IOException;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherconditions.springmvc.config.WeatherURLBuilder;
import com.weatherconditions.springmvc.weather.zipcode;
@Service
public class WeatherServiceImpl implements WeatherService{
	@Autowired
	private WeatherURLBuilder builder;
	public zipcode getWeatherResults(int zipcode) throws IOException{
		//Implement code for webservices here
		String url = builder.getUrlForZipcode(zipcode);
		//Convert JSON Object to Java 
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new URL(url), zipcode.class);
		
	}
}
