
/****************************************************************************************
Name            : LogFile
Revision Log    : 2015-10-20: Babalu patidar : created.
                : 
                : 
Use             : This class is used to store exception in log file.
                :
****************************************************************************************/
package LogFile;

import java.util.logging.FileHandler;


import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LogFile {
		private static Logger logger = Logger.getLogger(LogFile.class.getName());
		private static LogFile loggerClass = new LogFile();
		Handler fileHandler;
		private LogFile() {
			try {
				fileHandler = new FileHandler("Exceptionfile.log",true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		public static LogFile getInstance() {
			return loggerClass;
		}
		public void catchException( String string ) {
			
			logger.removeHandler(fileHandler);
			logger.addHandler(fileHandler);
			logger.setLevel(Level.ALL);
			logger.log(Level.FINE,string);
		}
}

