/****************************************************************************************
Name            : BookIssueByBookNameAndAuthorName
Revision Log    : 2015-09-16: Babalu patidar : created.
                : 
                : 
Use             : This class is used to  Issue Book By BookName And AuthorName
                :
****************************************************************************************/

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class BookIssueByBookNameAndAuthorName {
	
	public static void main(String arg[]) {
		
		String bookName;
		String memberName;
		Scanner scan =new Scanner(System.in);
		System.out.print("\n Enter title of Book : ");
		bookName = scan.nextLine();
		System.out.print("\n Enter member name : ");
		memberName = scan.nextLine();
		boolean flag = bookIssueByBookName(bookName,memberName);
		if(flag){
			System.out.print("\n Book has issued to :"+memberName);
		}
		else{
			System.out.print("\n Book can't be issued ");
		}
		//end of else 
		scan.close();
	}
	//End of main method 
	
	//@param query : Specify query that has to execute.
	//Method return flag that contain true if member issued a book
	public static boolean bookIssueByBookName( String bookName,String memberName )
	{
		String query = "INSERT INTO Book_issue(issue_date, accession_number, member_id, due_date) "
					+ "VALUES(now(),"
					+ "(select accession_number  from Books where status=0 and title_id = ( select title_id from Titles where title_name= '"+bookName+"')), "
					+ "(select member_id from Members where member_name = '"+memberName+"'),'2015-11-06');";
		
		String query1="Update books SET Status=1 where  status=0 and title_id = ( select title_id Li from Titles where title_name= '"+bookName+"') Limit 1;";
		boolean result=false;
		Connection connection = null;
		Statement statement = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		connection = conUtil.getConnection();
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
			result=true;
			statement.executeUpdate(query1);
		} catch (SQLException e) {
			return result;
		}
		//End of try catch
		return result;
	}
	//End of method

}
//End of class