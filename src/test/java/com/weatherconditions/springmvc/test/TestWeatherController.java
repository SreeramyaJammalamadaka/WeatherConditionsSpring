package com.weatherconditions.springmvc.test;


import org.springframework.ui.ExtendedModelMap;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.ObjectError;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

import junit.framework.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.web.WebAppConfiguration;

import com.weatherconditions.springmvc.config.MvcConfiguration;
import com.weatherconditions.springmvc.config.WeatherURLBuilder;
import com.weatherconditions.springmvc.controller.WeatherController;
import com.weatherconditions.springmvc.weather.zipcode;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
    @ContextConfiguration(classes = MvcConfiguration.class),
    @ContextConfiguration(classes = WeatherURLBuilder.class)
})
public class TestWeatherController {
	@Autowired
    private WeatherController controller;
	 @Test
	    public void testValidWeatherDetails(){
	        WeatherController.GetZipCodeInformation information = new WeatherController.GetZipCodeInformation();
	        information.setZipCode("98007");
	        MapBindingResult mapBindingResult = new MapBindingResult(new HashMap(), "zipcode");
	        ExtendedModelMap model = new ExtendedModelMap();
	        controller.processWeather(information, mapBindingResult, model);

	        Map targetMap = mapBindingResult.getTargetMap();
	        Assert.assertEquals(0, mapBindingResult.getAllErrors().size());
	        zipcode zipcode = (zipcode) model.get("weather");
	        
	        Assert.assertEquals("Bellevue", zipcode.getCurrentObservation().getDisplayLocation().getCity());

	    }

	 @Test
	    public void testInvalidZipCode(){
	        WeatherController.GetZipCodeInformation information = new WeatherController.GetZipCodeInformation();
	        information.setZipCode("00000");
	        MapBindingResult mapBindingResult = new MapBindingResult(new HashMap(), "zipcode");
	        ExtendedModelMap model = new ExtendedModelMap();
	        controller.processWeather(information, mapBindingResult, model);
	        List<ObjectError> allErrors = mapBindingResult.getAllErrors();
	        Assert.assertEquals(1, allErrors.size());
	        
	        Assert.assertEquals("zipcode not found",allErrors.get(0).getDefaultMessage());
	    }

	    @Test
	    public void testIncorrectZipCode(){
	        WeatherController.GetZipCodeInformation information = new WeatherController.GetZipCodeInformation();
	        information.setZipCode("abcd");
	        MapBindingResult mapBindingResult = new MapBindingResult(new HashMap(), "zipcode");
	        ExtendedModelMap model = new ExtendedModelMap();
	        controller.processWeather(information, mapBindingResult, model);
	        List<ObjectError> allErrors = mapBindingResult.getAllErrors();
	        Assert.assertEquals(1, allErrors.size());

	        Assert.assertEquals("Please enter a valid 5 digit zipcode",allErrors.get(0).getDefaultMessage());
	    }


}
