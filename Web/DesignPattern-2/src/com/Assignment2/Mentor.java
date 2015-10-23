/****************************************************************************************
Name            : Mentor
Revision Log    : 2015-10-20: Babalu patidar : created.
                : 
                : 
Use             : This class is used to approve leave byMentor.
                :
****************************************************************************************/
package com.Assignment2;

public class Mentor extends LeaveApprover {

	@Override
	public void ProcessRequest(int leave) {
		if (leave <= 1) {
			System.out.println("Leave approved by Mentor");
		} else if (successor != null) {
			successor.ProcessRequest(leave);
		}
	}
}
//End of class
