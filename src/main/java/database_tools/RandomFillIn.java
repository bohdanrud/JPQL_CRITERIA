package database_tools;

import javax.persistence.EntityManager;

public class RandomFillIn {

	public static void fillInDatabase(EntityManager em) {
		FillInDataBase.addRandomCountries(em);
		FillInDataBase.addRandomCities(em);
		FillInDataBase.addRandomUsers(em);
	}
	
}
