/****************************************************************************************
Name            : ConcreteMechanicalEngineer
Revision Log    : 2015-10-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create object of MechanicalEngineer.
                :
****************************************************************************************/

package factory;

import Engineermodel.IEngineer;
import Engineermodel.MechanicalEngineer;

public class ConcreteMechanicalEngineer extends EngineerFactory {

	@Override
	//createEngineer method return object of MechanicalEngineer.
	IEngineer createEngineer() {
		return MechanicalEngineer.getInstance();
	}
	//End of createEngineer method.

}
//End of class
