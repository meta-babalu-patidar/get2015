/****************************************************************************************
Name            : TestCricket
Revision Log    : 2015-10-20: Babalu patidar : created.
                : 
                : 
Use             : This class is used to play Test cricket.
                :
****************************************************************************************/

package com.Assignment3;

public class TestCricket extends Cricket{

	@Override
	void initialize() {
		// TODO Auto-generated method stub
		 System.out.println("Test Cricket Initialized! Start playing.");
		
	}

	@Override
	void startPlay() {
		// TODO Auto-generated method stub
		System.out.println("Test Cricket Started. Enjoy the game!");
	}

	@Override
	void endPlay() {
		// TODO Auto-generated method stub
		 System.out.println("Test Cricket  Finished!");
	}

}
//End of class
