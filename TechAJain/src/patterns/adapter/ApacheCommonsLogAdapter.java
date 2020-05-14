package patterns.adapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

public class ApacheCommonsLogAdapter extends Logger {
	/*private Log logger = new Log4JLogger("MyLogger");
	@Override	
	public void trace(String str) {
		logger.trace(str);
	}

	@Override
	public void debug(String str) {
		logger.debug(str);
	}

	@Override
	public void log(String str) {
		logger.info(str);
	}*/

	@Override
	public void trace(String str) {

	}

	@Override
	public void debug(String str) {

	}

	@Override
	public void log(String str) {

	}
}
