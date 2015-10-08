/****************************************************************************************
Name            : PuzzleState
Revision Log    : 2015-10-05: Babalu patidar : created.
                : 
                : 
Use             : This class is responsible for holding the current state of the puzzle.
                :
****************************************************************************************/

import java.util.Arrays;

public class PuzzleState {
	
	
	
	
	// The array representing the puzzle's state.
	public int[] array = new int[9];
	
	// The index location of the blank tile in the current state.
	public int blankIndex;
	
	// The number of moves since the start. 
	private int movesStart;
	
	// The number of moves to the goal. 
	private int movesGoal;
	
	// The previous state.
	private PuzzleState previous;
	
	
	// constructor for State class.
	public PuzzleState(int[] input) {
	    this.array = input;
	    this.blankIndex = getIndex(input, 0);
	    this.previous = null;
	    this.movesStart = 0;
	    this.movesGoal = Puzzle.getHeuristic(this.array);
	}
	
	public PuzzleState(PuzzleState previous, int blankIndex) {
	    this.array = Arrays.copyOf(previous.array, previous.array.length);
	    this.array[previous.blankIndex] = this.array[blankIndex];
	    this.array[blankIndex] = 0;
	    this.blankIndex = blankIndex;
	    this.movesStart = previous.movesStart + 1;
	    this.movesGoal = Puzzle.getHeuristic(this.array);
	    this.previous = previous;
	}
	
	// This method gets the index of a particular value in array.
	public static int getIndex(int[] array, int value) {
	    for (int i = 0; i < array.length; i++)
	      if (array[i] == value) return i;
	    return -1;
	}
	
	// This method checks to see if the current state is the solved state.  
	public boolean isSolved() {
	    int[] p = this.array;
	    for (int i = 1; i < p.length - 1; i++)
	      if(p[i-1] > p[i]) return false;
	
	    return (p[0] == 1);
	}
	
	//This returns a human-readable string representation of the current state of the puzzle it is called on.
	public String toString() {
	    int[] state = this.array;
	    String s = "\n\n";
	    for(int i = 0; i < state.length; i++) {
	      if(i % 3 == 0 && i != 0) s += "\n";
	      s += (state[i] != 0) ? String.format("%d ", state[i]) : "  ";
	    }
	    return s;
	}
	
	// This method returns a string representation of all steps taken to solve the puzzle.
	public String allSteps() {
		
	    StringBuilder sb = new StringBuilder();
	    if (this.previous != null) sb.append(previous.allSteps());
	    sb.append(this.toString());
	    return sb.toString();
	}
	
	// This method creates a solution message for when the puzzle has been solved using a StringBuilder.  
	public String solutionMessage()  {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Here are the steps to the goal state:");
	    sb.append(this.allSteps());
	    sb.append("\n\nGiven puzzle is SOLVED!");
	    sb.append("\nSolution took " + this.movesStart + " steps.\n");
	    return sb.toString();
	}
	
	//This method returns the g(n) part of the cost function. It is the amount of steps that the current state.
	public int movesStart() {
	    return this.movesStart;
	}
	
	public int movesGoal() {
	    return this.movesGoal;
	}
	
	public int totalMoves() {
	    return movesStart() + movesGoal();
	}
	
	// Getter for the previous field. 
	public PuzzleState getPrevious() {
	    return this.previous;
	}

}
//End of class
