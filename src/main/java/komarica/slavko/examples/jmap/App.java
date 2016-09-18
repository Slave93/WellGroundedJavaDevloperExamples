package komarica.slavko.examples.jmap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	private static final int WAIT_TIME_IN_SECONDS_ALITTLE = 60*1;
	private static final int WAIT_TIME_IN_SECONDS_ALOT = 60*60*1;
	private static final int PERSONS_SPAWN_COUNT = 50000*200;
	
	private static PersonsManager personsManager = new PersonsManager();
	
	
	public static void main(String[] args) {
		personsManager.spawnNewPersons(PERSONS_SPAWN_COUNT);
		logPersonsCount();
		waitAlittle();
		personsManager.clearPersons();
		logPersonsCount();
		waitAlot();
		logger.debug("This is the END my only friend, THE END");
	}
	
	private static void waitAlittle(){
		waitForSomeTime(WAIT_TIME_IN_SECONDS_ALITTLE);
	}
	
	private static void waitAlot(){
		waitForSomeTime(WAIT_TIME_IN_SECONDS_ALOT);
	}
	
	private static void waitForSomeTime(int waitTimeInSeconds) {
		try {
			logger.debug("Going to sllep for "+waitTimeInSeconds+" seconds");
			Thread.sleep(waitTimeInSeconds * 1000);
		} catch (InterruptedException e) {
			// not a problem
		}		
		logger.debug("Awaiken");
	}
	
	private static void logPersonsCount(){
		if(logger.isDebugEnabled()){
			logger.debug("Persons count: "+personsManager.getPersonsCount());
		}
	}

}
