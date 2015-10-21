/****************************************************************************************
Name            : IWorkstation
Revision Log    : 2015-10-21: Babalu patidar : created.
                : 
                : 
Use             : This interface is used to add engineer in list or displayList method.
                :
****************************************************************************************/

package workstation;

import java.util.ArrayList;
import java.util.List;

import Engineermodel.IEngineer;

public interface IWorkstation {
	
	public static List<IEngineer> engineerList = new ArrayList<IEngineer>();
	
	public void addEngineer( IEngineer engineer);
	public List<IEngineer> displayList();

}
//End of interface.
