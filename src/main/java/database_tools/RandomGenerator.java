package database_tools;

import java.util.Random;

public class RandomGenerator {
	
	static Random rnd = new Random();
	
	public static int generateRandomAge() {
		int randomAge = 1;
		
		randomAge = (rnd.nextInt(99)+1);
		return randomAge;
	}
	
	public static int generateRandomCity() {
		int randomCity = 1;
		
		randomCity = (rnd.nextInt(38)+1);
		return randomCity;
	}
	
	public static int generateRandomCountry() {
		int randomCountry = 1;
		
		randomCountry = (rnd.nextInt(19)+1);
		return randomCountry;
	}

}
