package database_tools;

import javax.persistence.EntityManager;

import entity.Country;

public class FillInDataBase {
	
	public static void addRandomCountries(EntityManager em) {
		
		Country country = new Country();
		country.setCountry_name("test");
		em.persist(country);
	}

}
