/****************************************************************************************
Name            : DeleteBooksHelper
Revision Log    : 2015-09-16: Babalu patidar : created.
                : 
                : 
Use             : This class is used to delete books from book table
                :
****************************************************************************************/

public class DeleteBooksHelper {
	
	public static void main(String[] args){
	
		DeleteBooks deletedBooks=DeleteBooks.deleteBooks();
		if(deletedBooks.getNumberOfBooksDeleted()==0){
			System.out.println("No Books are deleted");
		}
		else{
			System.out.println("Number of book deleted = "+deletedBooks.getNumberOfBooksDeleted());
		}
		//End of else
	}
	//End of main method
}
//End of class
