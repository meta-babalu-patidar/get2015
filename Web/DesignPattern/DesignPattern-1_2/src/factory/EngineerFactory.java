/****************************************************************************************
Name            : EngineerFactory
Revision Log    : 2015-10-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create object of Engineer.
                :
****************************************************************************************/

package factory;

import Engineermodel.IEngineer;

public abstract class EngineerFactory {
	
	abstract IEngineer createEngineer();
}
//End of class
