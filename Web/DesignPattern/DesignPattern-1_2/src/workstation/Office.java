/****************************************************************************************
Name            : Office
Revision Log    : 2015-10-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to add engineer in list or displayList.
                :
****************************************************************************************/

package workstation;

import java.util.List;

import Engineermodel.IEngineer;

public class Office implements IWorkstation {
	
	private static Office office = new Office();
	
	private Office() {
		
	}
	
	//Return instance of office object.
	public static Office getInstance() {
		return office;
	}

	@Override
	public void addEngineer(IEngineer engineer) {
		engineerList.add(engineer);
		
	}

	@Override
	public List<IEngineer> displayList() {
		return engineerList;
	}

}
//End of class
