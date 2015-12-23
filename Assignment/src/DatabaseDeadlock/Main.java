
/**
 *@author:Babalu Patidar
 *
 **/
package DatabaseDeadlock; 

public class Main {
	public static void main(String args[]) {

		ThreadFirst T1 = new ThreadFirst();
		ThreadSecond T2 = new ThreadSecond();
		T2.start();
		T1.start();
	}

	/**
	 * Class run first method of JdbcHelper class
	 */
	private static class ThreadFirst extends Thread {
		public void run() {
			JDBCHelper jdbcHelper = new JDBCHelper();
			jdbcHelper.firstMethod();
		}
	}
	
	/**
	 * Class run secondMethod of JdbcHelper class
	 */
	private static class ThreadSecond extends Thread {
		public void run() {
			JDBCHelper jdbcHelper = new JDBCHelper();
			jdbcHelper.secondMethod();
		}
	}
}
