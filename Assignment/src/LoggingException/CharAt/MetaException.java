/**
	 * @author Babalu Patidar
	 * 
	 * */
package LoggingException.CharAt;

import org.apache.log4j.Logger;


public class MetaException extends Exception {

	private static final long serialVersionUID = 1L;

	private final static Logger logger = Logger.getLogger(MetaException.class);
			
	MetaException(String message){
		super(message);
		 logger.info(message);
	}
}
