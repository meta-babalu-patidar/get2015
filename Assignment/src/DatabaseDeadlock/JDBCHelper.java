
/**
 *@author:Babalu Patidar
 *
 **/

package DatabaseDeadlock;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCHelper {
	/**
	 * Method update customer table first than update order table.
	 */
	public void firstMethod() {
		ConnectionUtill connectionUtill = new ConnectionUtill();
		Connection connection = connectionUtill.getConnection();
		Statement statement = null;
		try {

			String query = "START TRANSACTION";
			statement = connection.createStatement();
			statement.executeQuery(query);
			String query1 = "UPDATE Customer SET first_name = 'Babalu' WHERE customer_id=1";
			statement = connection.createStatement();
			statement.executeUpdate(query1);
			String query3 = "select SLEEP(2) ";
			statement = connection.createStatement();
			statement.executeQuery(query3);
			String query4 = " UPDATE Orders SET customer_id = 1 WHERE order_id = 1";
			statement = connection.createStatement();
			statement.executeUpdate(query4);
			String query5 = "COMMIT";
			statement = connection.createStatement();
			statement.executeQuery(query5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 *  Method update customer order first than update customer table.
	 */
	public void secondMethod() {
		ConnectionUtill connectionUtill = new ConnectionUtill();
		Connection connection = connectionUtill.getConnection();
		Statement statement = null;
		try {
			String query = "start TRANSACTION";
			statement = connection.createStatement();
			statement.executeQuery(query);
			String query2 = "UPDATE Orders SET order_name = 'Good' WHERE order_id = 1";
			statement = connection.createStatement();
			statement.executeUpdate(query2);
			String query3 = "select SLEEP(2)";
			statement = connection.createStatement();
			statement.executeQuery(query3);
			String query4 = "UPDATE customer SET first_name = 'Mike' WHERE customer_id=1";
			statement = connection.createStatement();
			statement.executeUpdate(query4);
			String query5 = "COMMIT";
			statement = connection.createStatement();
			statement.executeQuery(query5);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
	}
}
