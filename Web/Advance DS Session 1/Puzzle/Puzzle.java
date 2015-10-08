/****************************************************************************************
Name            : Puzzle
Revision Log    : 2015-10-05: Babalu patidar : created.
                : 
                : 
Use             : This class is used to contains logic and properties that are related to a sliding puzzle.
                :
****************************************************************************************/

import java.util.*;

public class Puzzle {

	//The initial state of the puzzle. 
	public PuzzleState initialState;

	// The current state of the puzzle. 
	public PuzzleState state;

	// The initial capacity of the queue.
	static final int CAPACITY = 100;

	// The priority queue used to solve the puzzle. 
	public final PriorityQueue<PuzzleState> queue = new PriorityQueue<PuzzleState>(CAPACITY, new Comparator<PuzzleState>() {
		@Override
		public int compare(PuzzleState o1, PuzzleState o2) {
			return o1.totalMoves() - o2.totalMoves();
		}
	});

	// A Hash set containing the states that have been visited. 
	public final HashSet<PuzzleState> visited = new HashSet<PuzzleState>();

	public Puzzle(int[] puzzleInput) {
		this.initialState = new PuzzleState(puzzleInput);
		this.state = this.initialState;
	}

	// This method checks whether or not the puzzle object it is called on is a solvable puzzle or not.
	public boolean isSolvable() {
		int inversions = 0;
		int[] p = this.state.array;
		
		for(int i = 0; i < p.length - 1; i++) {
			for(int j = i + 1; j < p.length; j++) {
				if(p[i] > p[j]){
					inversions++;
				}
			}
			
			if(p[i] == 0 && i % 2 == 1) {
				inversions++;
			}
		}
		
		return (inversions % 2 == 0);
	}

	// This method calculates the current heuristic for a puzzle's state. 
	public static int getHeuristic(int[] array) {
		int heuristic = 0;
		for(int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				heuristic += getManhattanDistance(i, array[i]);
			}
		}
		return heuristic;
	}

	// This method calculates the Manhattan Distance between a tile's location and it's goal location.
	
	public static int getManhattanDistance(int index, int number) {
		return Math.abs((index / 3) - ((number-1) / 3)) + Math.abs((index % 3) - ((number-1) % 3));
	}

	// This method handles adding the next state to the queue.
	private void addToQueue(PuzzleState nextState) {
		if(nextState != null && !this.visited.contains(nextState)) {
			this.queue.add(nextState);
		}
	}

	// This method handles the solving of the puzzle.
	public void solve() {
		// Clear the queue and add the initial state.
		queue.clear();
		queue.add(this.initialState);

		while(!queue.isEmpty()) {
			// Get the best next state.
			this.state = queue.poll();

			// Check if the state is a solution.
			if (this.state.isSolved()) {
				System.out.println(this.state.solutionMessage());
				return;
			}

			// Add this state to the visited HashSet so we don't revisit it.
			visited.add(state);

			// Add valid moves to the queue.
			this.addToQueue(PuzzleMove.up(state));
			this.addToQueue(PuzzleMove.down(state));
			this.addToQueue(PuzzleMove.left(state));
			this.addToQueue(PuzzleMove.right(state));
		}
		//End of while loop.
	}
	//ENd of solve method.
}
//End of class