/****************************************************************************************
Name            : ConcreteDeveloper
Revision Log    : 2015-10-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create object of Developer.
                :
****************************************************************************************/

package factory;

import Engineermodel.Developer;
import Engineermodel.IEngineer;

public class ConcreteDeveloper extends EngineerFactory {

	@Override
	//createEngineer method return object of developer
	IEngineer createEngineer() {
		return Developer.getInstance();	
	}
	//End of createEngineer method.

}
//End of class
