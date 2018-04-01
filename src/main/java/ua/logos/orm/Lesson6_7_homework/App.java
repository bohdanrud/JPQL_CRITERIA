package ua.logos.orm.Lesson6_7_homework;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import database_tools.FillInDataBase;

public class App 
{
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
    	
		
		FillInDataBase.addRandomCountries(em);
    	
    	
		em.getTransaction().commit();
		em.close();
		factory.close();
    }
}
