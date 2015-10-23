/****************************************************************************************
Name            : Cricket
Revision Log    : 2015-10-20: Babalu patidar : created.
                : 
                : 
Use             : This class is used to play cricket.
                :
****************************************************************************************/

package com.Assignment3;

public abstract class Cricket {
	abstract void initialize();
	   abstract void startPlay();
	   abstract void endPlay();

	   //template method
	   public final void play(){

	      //initialize the game
	      initialize();

	      //start game
	      startPlay();

	      //end game
	      endPlay();
	   }
}
//End of class
