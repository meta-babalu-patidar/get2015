/****************************************************************************************
Name            : MechanicalEngineer 
Revision Log    : 2015-10-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement all method of MechanicalEngineer.
                :
****************************************************************************************/

package Engineermodel;

public class MechanicalEngineer implements IEngineer {

	String name;
	EngineerType role;
	
	//Private Constructor
	private MechanicalEngineer() {
		
	}
	
	//Method return instance of new object
	public static MechanicalEngineer getInstance() {
		return new MechanicalEngineer();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setRole(EngineerType role) {
		// TODO Auto-generated method stub
		this.role = role;
	}

	@Override
	public EngineerType getRole() {
		// TODO Auto-generated method stub
		return role;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name:"+name+" Role:"+role;
	}
	

}
//End of class