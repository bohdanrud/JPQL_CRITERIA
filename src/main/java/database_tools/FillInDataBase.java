package database_tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.persistence.EntityManager;

import entity.City;
import entity.Country;
import entity.User;

public class FillInDataBase {
	
	public static void addRandomCountries(EntityManager em) {
		
		 try {
	            File file = new File("random_countries.txt");
	            FileReader fileReader = new FileReader(file);
	            BufferedReader BReader = new BufferedReader(fileReader);
	            String newCountry = BReader.readLine();
	            while (newCountry != null) {
	                System.out.println("Country " + newCountry + " added to the database!");
	                Country country = new Country();
	        		country.setCountry_name(newCountry);
	        		em.persist(country);
	                newCountry = BReader.readLine();
	            }
	            BReader.close();
	            fileReader.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		System.out.println("Adding countries to the database was finished!");
	}
	
	public static void addRandomCities(EntityManager em) {
		try {
            File file = new File("random_cities.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader BReader = new BufferedReader(fileReader);
            String newCity = BReader.readLine();
            while (newCity != null) {
                System.out.println("City " + newCity + " added to the database!");
                City city = new City();
        		city.setCity_name(newCity);
        		em.persist(city);
        		newCity = BReader.readLine();
            }
            BReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	System.out.println("Adding cities to the database was finished!");
	}
	
	public static void addRandomUsers(EntityManager em) {
		try {
            File file = new File("random_user_names.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader BReader = new BufferedReader(fileReader);
            String newName = BReader.readLine();
            while (newName != null) {
                System.out.println("User " + newName + " added to the database!");
                User user = new User();
        		Country country = em.createQuery("SELECT c FROM Country c WHERE c.id = :id", Country.class).setParameter("id", RandomGenerator.generateRandomCountry())
    					.getSingleResult();
        		City city = em.createQuery("SELECT c FROM City c WHERE c.id = :id", City.class).setParameter("id", RandomGenerator.generateRandomCity())
    					.getSingleResult();
                user.setFull_name(newName);
        		user.setAge(RandomGenerator.generateRandomAge());
        		user.setCountry(country);
        		user.setCity(city);
        		em.persist(user);
        		newName = BReader.readLine();
            }
            BReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	System.out.println("Adding users to the database was finished!");
	}
	
}
