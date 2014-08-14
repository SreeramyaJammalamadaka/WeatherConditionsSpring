<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Weather Conditions Success</title>
</head>
<body>
    <div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Weather Details!</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>Here's the weather report for the zipcode entered:</h3>
                </td>
            </tr>
            <tr>
                <td>ZipCode:</td>
                <td>${weather.currentObservation.displayLocation.zip}</td>
            </tr>
            <tr>
                <td>City:</td>
                <td>${weather.currentObservation.displayLocation.city}</td>
            </tr>
            <tr>
                <td>State:</td>
                <td>${weather.currentObservation.displayLocation.state}</td>
            </tr>
            <tr>
                <td>Temperature in Fahrenheit:</td>
                <td>${weather.currentObservation.currentTemperature} degrees</td>
            </tr>
 
        </table>
    </div>
</body>
</html>