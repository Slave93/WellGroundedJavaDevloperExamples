package komarica.slavko.examples.jmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonsManager {

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	private static final int PERSONS_SPAWN_COUNT = 10000000;
	private static final String PERSON_NAME_PREFIX = "PERSON_";
	private static final String PERSON_LAST_NAME_PREFFIX = "_";
	private static final Random RANDOM = new Random();

	private List<Person> persons = new ArrayList<Person>();

	public List<Person> getPersons() {
		return persons;
	}
	
	public void clearPersons() {
		logger.debug("Going to clear up persons");
		this.persons.clear();
	}
	
	public int getPersonsCount(){
		return this.persons.size();
	}

	public void spawnNewPersons() {
		spawnNewPersons(PERSONS_SPAWN_COUNT);
	}

	public void spawnNewPersons(int personsSpawnCount) {
		logger.debug("Spawning new persons");
		int i = 0;
		while (i < personsSpawnCount) {
			persons.add(new Person(PERSON_NAME_PREFIX + i,
					PERSON_LAST_NAME_PREFFIX + i, i, generateJmbg()));
			logger.debug("Person "+i +" spawned");
			i++;
		}		
	}

	private String generateJmbg() {
		return String.valueOf(RANDOM.nextInt(999999999));
	}

}
