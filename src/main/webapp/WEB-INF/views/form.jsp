<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Weather Conditions</title>
    <style>
        .form-item { margin: 20px 0; }
        .form-label { font-weight: inherit; color: navy; }
        .form-error-field { background-color:buttonshadow; }
        .form-error-message { color: red; }
        .form-header{font-family:sans-serif;color:black;border-bottom: thick;font-size: 2em}
    </style>
</head>
<body>

<form:form commandName="zipcode" modelAttribute="zipcode">
<table border="0" > <tr><td>  <div class="form-header">Determine the weather conditions - Spring MVC</div></td></tr>
	<tr><td>
    <div class="form-item">
   <div class="form-label">Please enter the Zipcode:</div>
      <form:input path="zipCode" size="5" cssErrorClass="form-error-field"/>   </div></td>
     </tr>
    <tr>
    <td><div class="form-error-message"><form:errors path="zipCode"/></div></td> 
    </tr>
    <tr>
     <td> <div class="form-item">
       <input type="submit" value="Get Weather Details" />
    </div>
    </td>
    </tr>
</table>
 
</form:form>

</body>
</html>