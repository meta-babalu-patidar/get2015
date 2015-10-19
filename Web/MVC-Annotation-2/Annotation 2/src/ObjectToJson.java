/****************************************************************************************
Name            : ObjectToJson
Revision Log    : 2015-10-17: Babalu patidar : created.
                : 
                : 
Use             : This class is used to converts employee object to JSon file.
                :
****************************************************************************************/

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class ObjectToJson {
	
	//Method converts employee object to JSon file.
	//Method store value in Json file.
	public static void convertObjectToJson() {
		Employee employee = new Employee();
		employee.setEmployeeName(Constant.NAME);
		employee.setEmployeeId(Constant.E_ID);
		employee.setCtcPerAnnum(Constant.CPA);
		employee.setDateOfBirth(Constant.DOB);
		employee.setEmailId(Constant.EMAIL);
		employee.setDateOfJoining(Constant.DOJ);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File(Constant.EMPLOYEE_JSON_FILE_PATH),employee);
			System.out.println(mapper.writeValueAsString(employee));
		} catch (JsonGenerationException e) {
			ExceptionHandler.handleException(e.getMessage());

		} catch (JsonMappingException e) {
			ExceptionHandler.handleException(e.getMessage());

		} catch (IOException e) {
			ExceptionHandler.handleException(e.getMessage());

		}

	}
	//End of try catch block.

}
//End of class
