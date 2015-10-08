/****************************************************************************************
Name            : PuzzleMain
Revision Log    : 2015-10-05: Babalu patidar : created.
                : 
                : 
Use             : This class is used to implement puzzle problem.
                :
****************************************************************************************/
public class PuzzleMain {
	public static void main(String[] args) {
		System.out.println("3*3 Sliding Puzzle\n");
		char choice;
		do
		{
		
		    int p[] = PuzzleInput.getArrayInput("Enter 8 sliding puzzle : ");
			Puzzle puzzle = new Puzzle(p);
			System.out.println("Given puzzle:\n"+ puzzle.state.toString());
			
			// Check if the puzzle is solvable.
			if (!puzzle.isSolvable()) 
			{
				System.out.println("Given puzzle:\n\nis NOT solvable!\n"+ puzzle.state.toString());
				System.exit(0);
			}
	
			// Solve the puzzle.
			try{
				puzzle.solve();
			}
			catch( Exception e){
				e.printStackTrace();
			}
			choice = PuzzleInput.getCharacterInput("Do you want to continue press y otherwise n");
		}while(choice == 'y' || choice == 'Y');
	}
	//End of main method.
}
//End of class
