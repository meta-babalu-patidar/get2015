
/****************************************************************************************
Name            : Employee
Revision Log    : 2015-11-02: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create object of employee.
                :
****************************************************************************************/
package com.metacube.model;
public class Employee {
	
	String name;
	int age;
	String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Name="+name+", ID="+id+", Age=" + age;
	} 

}
//End of class