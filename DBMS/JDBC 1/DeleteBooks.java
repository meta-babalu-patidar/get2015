
/****************************************************************************************
Name            : Books
Revision Log    : 2015-09-16: Babalu patidar : created.
                : 
                : 
Use             : This class is used to delete books from book table
                :
****************************************************************************************/

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteBooks {
	
	private int numberOfBooksDeleted;

	//Start of getter setter
	public int getNumberOfBooksDeleted() {
		return numberOfBooksDeleted;
	}
	

	public void setNumberOfBooksDeleted(int numberOfBooksDeleted) {
		this.numberOfBooksDeleted = numberOfBooksDeleted;
	}
	//End of getter setter
	
	//Start of deletebooks method
	//Query for execute
	//Method return number of row that are deleted.
	public static DeleteBooks deleteBooks()
	{
		String query = "DELETE FROM books "
				+ "WHERE (accession_number "
				+ "NOT IN (SELECT accession_number FROM book_issue)"
				+ "AND DATEDIFF(now(),purchase_date)>365)"
				+ "OR accession_number "
				+ "IN (SELECT bi.accession_number FROM book_issue bi "
				+ "WHERE DATEDIFF(now(),bi.issue_date)>365 "
				+ "AND (bi.accession_number,bi.issue_date,bi.member_id) "
				+ "IN (SELECT br.accession_number,br.issue_date,br.member_id FROM book_return br));";
		Connection connection = null;
		int resultSet = 0;
		Statement statement = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		DeleteBooks deleteBooks = null;
		//Calls of getConnection method
		connection = connectionUtil.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeUpdate(query);
			deleteBooks = new DeleteBooks();
			deleteBooks.setNumberOfBooksDeleted(resultSet);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//End of try catch
		return deleteBooks;
	}
	//End of method
}
//End of class