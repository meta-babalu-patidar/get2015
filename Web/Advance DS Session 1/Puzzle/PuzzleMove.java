/****************************************************************************************
Name            : PuzzleMove
Revision Log    : 2015-10-05: Babalu patidar : created.
                : 
                : 
Use             : This class is used to handles the moving of the pieces on the puzzle board.
                :
****************************************************************************************/

public class PuzzleMove {

	// Method Returns a new state with the blank space swapped with the tile above it.
	static PuzzleState up(PuzzleState state)  {
	    if (state.blankIndex > 2) {
	    	return new PuzzleState(state, state.blankIndex - 3);
	    }
	    return null;
	}
	//End of up method

	// Method Returns a new state with the blank space swapped with the tile below it.
  
	public static PuzzleState down(PuzzleState state) {
	    if (state.blankIndex < 6) {
	    	return new PuzzleState(state, state.blankIndex + 3);
	    }
	    return null;
	}
	//End off down method method

	// Returns a new state with the blank space swapped with the tile to the left of it.
  
	public static PuzzleState left(PuzzleState state) {
		
	    if (state.blankIndex % 3 > 0){
	    	return new PuzzleState(state, state.blankIndex - 1);
	    }
	    
	    return null;
	}
	//End of left method

	
	// Returns a new state with the blank space swapped with the tile to the right of it.
	public static PuzzleState right(PuzzleState state) {
	    if (state.blankIndex % 3 < 2) {
	    	return new PuzzleState(state, state.blankIndex + 1);
	    }
	    return null;
  	}
	//End of right method.
}
//End of class

