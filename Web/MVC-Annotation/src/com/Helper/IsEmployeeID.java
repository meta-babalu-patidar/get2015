/****************************************************************************************
Name            : IsEmployeeID
Revision Log    : 2015-10-15: Babalu patidar : created.
                : 
                : 
Use             : This class is used to check employee id in cache.
                :
****************************************************************************************/

package com.Helper;

import com.Helper.EmployeeCache;

//this class is check that id is not null to registration

public class IsEmployeeID {
	
	public static boolean  check(int Id){
		EmployeeCache employeeCache = EmployeeCache.getInstance();
		if(employeeCache.getEmployeeForId(Id) == null) {
			return true;
		} else {
			return false;
		}
	}
	//End of check method
}
//End of class
