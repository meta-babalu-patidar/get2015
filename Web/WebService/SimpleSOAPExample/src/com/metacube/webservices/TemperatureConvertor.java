/****************************************************************************************
Name            : TemperatureConvertor
Revision Log    : 2015-10-28: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create convert farenheit to celcius.
                :
****************************************************************************************/

package com.metacube.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TemperatureConvertor {
	
	@WebMethod
	public double convertor(double farhnaheit) {
		return ((farhnaheit-32) * 5 / 9);
	}
	//End of method convertor.

}
//End of webservice..
