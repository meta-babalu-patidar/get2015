/****************************************************************************************
Name            : ConnectionItems
Revision Log    : 2015-09-21: Babalu patidar : created.
                : 
                : 
Use             : This class is used to establish connection from database.
                :
****************************************************************************************/

package VehicleXML;

public class ConnectionItems {
	
	  private String url; 
	  private String driver;
	  private String username;
	  private String password;
 
	  //Start of getter setter
	  public String geturl() {
	    return url;
	  }
	  public void setUrl(String url) {
	    this.url = url;
	  }
	  public String getDriver() {
	    return driver;
	  }
	  public void setDriver(String driver) {
	    this.driver =driver;
	  }
	  public String getUsername() {
	    return username;
	  }
	  public void setUsername(String username) {
	    this.username= username;
	  }
	  public String getPassword() {
	    return password;
	  }
	  public void setPassword(String password) {
	    this.password= password;
	  }
	  //End of getter setter
	   @Override
	  public String toString() {
	    return  "[url=" + url+ ", driver="
	        + driver + ", username=" + username + ", password=" +password + "]";
	  }
	   
} 
//End of Connection item class

