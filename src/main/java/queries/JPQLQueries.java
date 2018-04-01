package queries;


import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import entity.City;
import entity.Country;
import entity.User;

public class JPQLQueries {
	
	public static void jpqlQuery(EntityManager em, int key) {
		
		switch (key) {
		case 1:
			List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
			users.forEach(u -> System.out.println(u));
			break;
		case 2:
			List<Country> countries = em.createQuery("SELECT c FROM Country c ORDER BY c.id DESC", Country.class).getResultList();
			countries.forEach(c -> System.out.println(c));
			break;
		case 3:
			List<City> cities = em.createQuery("SELECT c FROM City c ORDER BY c.city_name ASC", City.class).getResultList();
			cities.forEach(c -> System.out.println(c));
			break;
		case 4:
			List<User> usersByNameDESC = em.createQuery("SELECT u From User u ORDER BY u.full_name DESC", User.class).getResultList();
			usersByNameDESC.forEach(u -> System.out.println(u));
			break;
		case 5:
			List<Country> countriesStartWithA = em.createQuery("SELECT c FROM Country c WHERE LOWER(c.country_name) LIKE LOWER(:letter)", Country.class).setParameter("letter", "a%").getResultList();
			countriesStartWithA.forEach(c -> System.out.println(c));
			break;
		case 6:
			List<City> countriesStartWith = em.createQuery("SELECT c FROM City c WHERE c.city_name LIKE :letter1 OR c.city_name LIKE :letter2", City.class).setParameter("letter1", "%n_").setParameter("letter2", "%r_").getResultList();
			countriesStartWith.forEach(c -> System.out.println(c));
			break;
		case 7:
			Integer minAge = em.createQuery("SELECT min(u.age) FROM User u", Integer.class).getSingleResult();
			List<User> usersWhithMinAges = em.createQuery("SELECT u FROM User u WHERE u.age = :age", User.class).setParameter("age", minAge).getResultList();
			usersWhithMinAges.forEach(u -> System.out.println(u));
			break;
		case 8:
			Double averageAge = em.createQuery("SELECT avg(u.age) FROM User u",Double.class).getSingleResult();
			System.out.println("Avarege age: " + averageAge);
			break;
		case 9:
			List<User> userWithCity = em.createQuery("SELECT u FROM User u JOIN u.city cc", User.class).getResultList();
			userWithCity.forEach(u -> System.out.println(u + " " + u.getCity()));
			break;
		case 10:
			List<User> userWithCityById = em.createQuery("SELECT u FROM User u JOIN u.city cc WHERE u.id NOT IN (:ids)", User.class).setParameter("ids", Arrays.asList(2,5,9,12,13,16)).getResultList();
			userWithCityById.forEach(u -> System.out.println(u + " " + u.getCity()));
			break;
		case 11:
			List<User> userWithCityAndCountry = em.createQuery("SELECT u FROM User u JOIN u.city cc JOIN u.country", User.class).getResultList();
			userWithCityAndCountry.forEach(u -> System.out.println(u + " " + u.getCity() + " " + u.getCountry()));
			break;
		default:
			break;
		}
		
	}

}
