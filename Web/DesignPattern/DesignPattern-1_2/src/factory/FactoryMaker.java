/****************************************************************************************
Name            : FactoryMaker
Revision Log    : 2015-10-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to create object of Engineer according to role of engineer.
                :
****************************************************************************************/

package factory;

import Engineermodel.EngineerType;
import Engineermodel.IEngineer;

public class FactoryMaker {
	private static IEngineer iEngineer = null;
	
	//getFactory method create object according to role of engineer
	//return instance of engineer
		public static IEngineer getFactory(EngineerType engineerType) { 
			EngineerFactory engineerFactory;
			if(engineerType.equals(EngineerType.Developer)) {
				engineerFactory = new ConcreteDeveloper();
				iEngineer = engineerFactory.createEngineer();
			} else {
				engineerFactory = new ConcreteMechanicalEngineer();
				iEngineer = engineerFactory.createEngineer();
			}
			return iEngineer;
		}
	//End of getFactory method

}
//End of class
