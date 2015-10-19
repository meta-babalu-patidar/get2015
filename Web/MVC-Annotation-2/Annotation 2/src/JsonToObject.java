/****************************************************************************************
Name            : JsonToObject
Revision Log    : 2015-10-17: Babalu patidar : created.
                : 
                : 
Use             : This class is used to converts JSon file to employee object.
                :
****************************************************************************************/

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class JsonToObject {
	
	//Method converts JSon file to employee object.
	//Take input from json file.
	public static void convertJsonToObject() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Employee employee = mapper.readValue(
							new File(Constant.EMPLOYEE_FILE_PATH),Employee.class);
			System.out.println(employee.toString());
		} catch (JsonGenerationException e) {
			ExceptionHandler.handleException(e.getMessage());

		} catch (JsonMappingException e) {

			ExceptionHandler.handleException(e.getMessage());

		} catch (IOException e) {

			ExceptionHandler.handleException(e.getMessage());

		}
		//End of try catch block

	}

}
//End of class
