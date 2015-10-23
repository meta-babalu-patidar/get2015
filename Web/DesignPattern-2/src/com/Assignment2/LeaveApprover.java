/****************************************************************************************
Name            : LeaveApprover
Revision Log    : 2015-10-20: Babalu patidar : created.
                : 
                : 
Use             : This class is used to leave and hold successor.
                :
****************************************************************************************/

package com.Assignment2;

public abstract class LeaveApprover {
	protected LeaveApprover successor;

	public void setSuccessor(LeaveApprover successor) {
		this.successor = successor;
	}

	public abstract void ProcessRequest(int leave);

}
//End of class.
