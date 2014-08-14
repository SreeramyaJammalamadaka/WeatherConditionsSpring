package com.weatherconditions.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import com.weatherconditions.springmvc.service.WeatherService;
import com.weatherconditions.springmvc.weather.zipcode;

import javax.validation.Valid;

import javax.validation.constraints.Pattern;

import java.io.IOException;

/**
 * Spring MVC {@link Controller} for displaying the weather conditions in a
 * given zipcode.
 */
@Controller
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@Autowired
	private Validator validator;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String get(ModelMap modalMap) {
		modalMap.addAttribute("zipcode", new GetZipCodeInformation());
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String processWeather(
			@ModelAttribute("zipcode") GetZipCodeInformation userInput,
			BindingResult result, Model model) {

		validator.validate(userInput, result);
		if (result.hasErrors()) {
			return "form";	
		}

		try {
			zipcode zipcode = weatherService.getWeatherResults(Integer
					.parseInt(userInput.getZipCode()));
			if (zipcode.getCurrentObservation() == null) {
				System.out.println("form errors object null");
				result.addError(new FieldError("zipcode", "zipCode",
						"zipcode not found"));
				return "form";
			}
			model.addAttribute("weather", zipcode);
			return "WeatherSuccess";
		} catch (IOException e) {
			return "WeatherUnknown";
		}

	}

	public static class GetZipCodeInformation {

		@Pattern(regexp = ("\\d\\d\\d\\d\\d"), message = "Please enter a valid 5 digit zipcode")
		private String zipCode;

		public String getZipCode() {
			return zipCode;
		}

		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
	}

}
