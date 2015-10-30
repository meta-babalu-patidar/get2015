/****************************************************************************************
Name            : VehicleDekhoSystemException
Revision Log    : 2015-10-30: Babalu patidar : created.
                : 
                : 
Use             : This class is used to handle system excception.
                :
****************************************************************************************/

package com.Exceptions;

public class VehicleDekhoSystemException extends VehicleDekhoException {


	private static final long serialVersionUID = 1L;

	public VehicleDekhoSystemException(String message) {
		super(message);
	}
	
	public VehicleDekhoSystemException(String message, Throwable cause) {
		super(message, cause);
	}

}
