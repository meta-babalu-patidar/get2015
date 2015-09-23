
/****************************************************************************************
Name            : VehicleMain
Revision Log    : 2015-09-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to call WriteConnectionXml so that xml is created.
                :
****************************************************************************************/

package VehicleXML;

import helper.MyException;

public class WriteConnectionXmlMain {
	
	public static void main(String[] args) throws MyException {
		
		// make object of WriteConnectionXml
	    WriteConnectionXml connectionXml = new WriteConnectionXml();
	    // call method set file and pass argument as a file name which we want to created
	    connectionXml.setFile("connection.xml"); 
	    try {
	    	
	    	// call save Config method to put contents in file and save it
	    	connectionXml.saveConfig();
	    } 
	    catch (Exception e) {
	    	throw new MyException(e);
	    }
	}
	//End of main method
} 
//End of class