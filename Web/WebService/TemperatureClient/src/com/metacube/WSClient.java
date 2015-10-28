/****************************************************************************************
Name            : WSClient
Revision Log    : 2015-10-28: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create convert farenheit to celcius.
                :
****************************************************************************************/

package com.metacube;

import java.util.Scanner;

import com.metacube.webservices.TemperatureConvertor;
import com.metacube.webservices.TemperatureConvertorServiceLocator;

public class WSClient {

	public static void main(String[] args) {
		
		TemperatureConvertorServiceLocator temperatureConvertorServiceLocator = new TemperatureConvertorServiceLocator();
		temperatureConvertorServiceLocator.setTemperatureConvertorEndpointAddress("http://localhost:8080/SimpleSOAPExample/services/TemperatureConvertor");
		
		try {
			TemperatureConvertor temperatureConvertor = temperatureConvertorServiceLocator.getTemperatureConvertor();
			
			double farenheit;
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n\nPlease Enter Farenheit value..");
			while(!scanner.hasNextDouble()) {
				
				System.out.println("Please Enter Integer Only");
				scanner.next();
			}
			farenheit=scanner.nextDouble();
			scanner.close();
			System.out.println(farenheit+" Farenhit = "+temperatureConvertor.convertor(farenheit)+" Celcius");
		} catch (Exception e) {
			System.out.println("Temprator convetor class not found.."+e.getMessage());
		}
		//End of try catch method.

	}
	//End of main method

}
//End of class
