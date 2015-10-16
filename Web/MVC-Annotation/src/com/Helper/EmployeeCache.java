/****************************************************************************************
Name            : EmployeeCache
Revision Log    : 2015-10-15: Babalu patidar : created.
                : 
                : 
Use             : This class is used to store all employee information.
                :
****************************************************************************************/
package com.Helper;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.Model.Employee;


public class EmployeeCache {
	private static EmployeeCache employeeCache = new EmployeeCache();
	private static Map<Integer, Employee> cache = new ConcurrentHashMap<Integer, Employee>();
	private EmployeeCache() {
		
	}

	public static EmployeeCache getInstance() {
		return employeeCache;
	}
	//End of getInstance of Employee cache

	public Employee getEmployeeForId(int id) {
		if(!(cache.isEmpty())) {
			return cache.get(id);
		} else {
			return null;
		}
	}
	//End of getEmployeeId method.
	public Map<Integer, Employee> getAllEmployees() {
		//return (List<Employee>) cache.values();
		return cache;
	}
	//End of getAllEmployees method.
	public void updateEmployee(Employee employee) {
		cache.put(employee.getId(),employee);
	}
	//End of update employee method.
	public void addEmployee(Employee employee) {
		cache.put(employee.getId(),employee);
	}
	//ENd of add Employee mwthod

}
//End of class