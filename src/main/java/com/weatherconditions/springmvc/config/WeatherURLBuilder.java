package com.weatherconditions.springmvc.config;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages={"com.weatherconditions.springmvc","com.weatherconditions.springmvc.service","com.weatherconditions.springmvc.controller"})
@PropertySource("classpath:weatherForm.properties")
@EnableWebMvc
public class WeatherURLBuilder {

	private @Value("${weatherForm.key}") String key;
    private @Value("${weatherForm.baseUrl}") String baseUrl;
    private @Value("${weatherForm.pathPrefix}") String pathPrefix;
    private @Value("${weatherForm.extension}") String extension;
   

   public @Bean(name = "weatherURLBuilder") WeatherURLBuilder getWeatherUrlBuilder() {
       return this;
   }

    public String getUrlForZipcode(int zipcode) {
      return baseUrl + key+ "/"+pathPrefix+zipcode+"."+extension;
    }
}