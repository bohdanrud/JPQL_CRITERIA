package queries;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import entity.City;
import entity.Country;
import entity.User;

public class CriteriaQueries {
	
	public static void criteriaQuery(EntityManager em, int key) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		switch (key) {
		case 1:
			CriteriaQuery<User> query = cb.createQuery(User.class);
			Root<User> root = query.from(User.class);   
			query.select(root);
			List<User> users = em.createQuery(query).getResultList();
			users.forEach(u -> System.out.println(u));
			break;
		case 2:
			CriteriaQuery<Country> queryC = cb.createQuery(Country.class);
			Root<Country> rootC = queryC.from(Country.class);
			queryC.select(rootC);
			queryC.orderBy(cb.desc(rootC.get("id")));
			List<Country> countriesDESC = em.createQuery(queryC).getResultList();
			countriesDESC.forEach(c -> System.out.println(c));
			break;
		case 3:
			CriteriaQuery<City> queryForCity = cb.createQuery(City.class);
			Root<City> rootForCity = queryForCity.from(City.class);
			queryForCity.select(rootForCity);
			queryForCity.orderBy(cb.asc(rootForCity.get("city_name")));
			List<City> citiesByName = em.createQuery(queryForCity).getResultList();
			citiesByName.forEach(c -> System.out.println(c));
			break;
		case 4:
			CriteriaQuery<User> queryUsersByNameDESC = cb.createQuery(User.class);
			Root<User> rootForUser = queryUsersByNameDESC.from(User.class);
			queryUsersByNameDESC.select(rootForUser);
			queryUsersByNameDESC.orderBy(cb.desc(rootForUser.get("full_name")));
			List<User> usersByName = em.createQuery(queryUsersByNameDESC).getResultList();
			usersByName.forEach(u -> System.out.println(u));
			break;
		case 5:
			CriteriaQuery<Country> queryCr = cb.createQuery(Country.class);
			Root<Country> rootCr = queryCr.from(Country.class);
			Expression<String> exp = rootCr.get("country_name");
			Predicate namePredicateUC = cb.like(exp, "A%");
			Predicate namePredicateLC = cb.like(exp, "a%");
			Predicate upperAndLowerCase = cb.or(namePredicateUC,namePredicateLC);
			queryCr.where(upperAndLowerCase);
			List<Country> countriesWithA = em.createQuery(queryCr).getResultList();
			countriesWithA.forEach(c -> System.out.println(c));
			break;
		case 6:
			CriteriaQuery<City> queryForCityWithLetters = cb.createQuery(City.class);
			Root<City> rootForCityWith = queryForCityWithLetters.from(City.class);
			Expression<String> exp1 = rootForCityWith.get("city_name");
			Predicate letter1 = cb.like(exp1, "%n_");
			Predicate letter2 = cb.like(exp1, "%r_");
			Predicate twoLetters = cb.or(letter1, letter2);
			queryForCityWithLetters.where(twoLetters);
			List<City> citiesWithLetters = em.createQuery(queryForCityWithLetters).getResultList();
			citiesWithLetters.forEach(c -> System.out.println(c));
			break;
		case 7:
			
			
			//List<User> usersWithMA = em.createQuery(queryUsersWithMinAge).getResultList();
			//usersWithMA.forEach(u -> System.out.println(u));
			break;
		case 8:
			
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		case 11:
			
			break;
		default:
			break;
		}
		
	}
}
