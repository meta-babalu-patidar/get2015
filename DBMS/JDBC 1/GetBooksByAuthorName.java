/****************************************************************************************
Name            : GetBooksByAuthorName
Revision Log    : 2015-09-16: Babalu patidar : created.
                : 
                : 
Use             : This class is used to select books title by author name
                :
****************************************************************************************/

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class GetBooksByAuthorName {
	
	public static void main(String[] args) throws IOException {
		Scanner scan =new Scanner(System.in);
		String authorName;
		System.out.println("Enter Author Name : ");
		authorName = scan.next();
		//Calling of getBooksByAuthorName method
		ArrayList<Books> titleList = Books.getBooksByAuthorName(authorName);
		ListIterator<Books> iterator = titleList.listIterator();
		
		if(!iterator.hasNext()){
			System.out.println("No Books found for this author name..");
		}
		else{
			System.out.println("Books are as follow: ");
			while(iterator.hasNext()){
				System.out.println(iterator.next().getTitleName()+"\t");
			}
			//End of while

		}
		//End of else
		scan.close();
	}
	//End of main method
	
}
//End of class