
/****************************************************************************************
Name            : SeniorMentor
Revision Log    : 2015-10-20: Babalu patidar : created.
                : 
                : 
Use             : This class is used to approve leave by Senoir Mentor.
                :
****************************************************************************************/
package com.Assignment2;

public class SeniorMentor extends LeaveApprover {

	@Override
	public void ProcessRequest(int leave) {
		if (leave <= 2) {
			System.out.println("Leave approved by Senior Mentor");
		} else if (successor != null) {
			successor.ProcessRequest(leave);
		}
	}

}
//End of class
