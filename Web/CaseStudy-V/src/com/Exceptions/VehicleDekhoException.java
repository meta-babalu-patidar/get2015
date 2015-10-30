/****************************************************************************************
Name            : VehicleDekhoException
Revision Log    : 2015-10-30: Babalu patidar : created.
                : 
                : 
Use             : This class is used to handle excception.
                :
****************************************************************************************/

package com.Exceptions;

public class VehicleDekhoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public VehicleDekhoException(String message) {
		super(message);
	}
	
	public VehicleDekhoException(String message, Throwable cause) {
		super(message, cause);
	}
	//End of constructor
}
//End of class