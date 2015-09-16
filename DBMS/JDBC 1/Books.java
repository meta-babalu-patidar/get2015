/****************************************************************************************
Name            : Books
Revision Log    : 2015-09-16: Babalu patidar : created.
                : 
                : 
Use             : This class is used to select books title by author name
                :
****************************************************************************************/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Books {
	
	private String titleName;
	
	//Getter Setter for class
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	//End of getter Setter
	
	//@param Query : Specify query that has to execute.
	//Method return list of books class object
	public static ArrayList<Books> getBooksByAuthorName(String authorName)
	{
		String query = "SELECT t.title_name FROM Titles t, Authors a, Title_author ta WHERE ta.title_id = t.title_id AND ta.author_id = a.author_id AND a.author_name = '"+authorName+"';";
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Books title;
		//Calling of getConnnection method
		connection = connectionUtil.getConnection();
		ArrayList<Books> titleList = new ArrayList<Books>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				title = new Books();
				title.setTitleName(resultSet.getString(1));
				titleList.add(title);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//End of try catch
		return titleList;
	}
	//End of method

}
//End of class
