package com.weatherconditions.springmvc.service;

import java.io.IOException;

import com.weatherconditions.springmvc.weather.zipcode;


public interface WeatherService {
	public zipcode getWeatherResults(int zip) throws IOException;
}

