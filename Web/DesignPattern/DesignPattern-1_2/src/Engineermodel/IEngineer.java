/****************************************************************************************
Name            : IEngineer
Revision Log    : 2015-10-21: Babalu patidar : created.
                : 
                : 
Use             : This Interface is used to implement all method of engineer.
                :
****************************************************************************************/
package Engineermodel;

public interface IEngineer {
	public void setName( String name);
	public String getName();
	public void setRole( EngineerType role);
	public EngineerType getRole();
	public String toString();
}
//End of interface