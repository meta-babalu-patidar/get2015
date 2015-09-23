/****************************************************************************************
Name            : ReadConnectionMain
Revision Log    : 2015-09-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to read connection from database.
                :
****************************************************************************************/

package VehicleXML;



import helper.MyException;


public class ReadConnectionMain {
   
	public static void main(String args[]) throws MyException {
		
		ReadConnectionXml read = new ReadConnectionXml();
		ConnectionItems connectionItems =  read.readConfig("connection.xml");
	    System.out.println(connectionItems);
	    
	}
}
