package ua.logos.orm.Lesson6_7_homework;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import database_tools.FillInDataBase;
import database_tools.RandomFillIn;
import queries.JPQLQueries;

public class App 
{
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
    	
		//RandomFillIn.fillInDatabase(em);
		JPQLQueries.jpqlQuery(em,1);
    	
		em.getTransaction().commit();
		em.close();
		factory.close();
    }
}
