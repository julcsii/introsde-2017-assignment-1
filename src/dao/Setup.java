package dao;

import java.util.Date;
import java.util.Random;

import xml.model.Activity;
import xml.model.Person;

public class Setup {
	
	private static String firstNames[] = new String[] {"John","Joe", "Julia"};
	private static String lastNames[] = new String[] {"Smith","Black", "Hermann"};
	private static String sbDates[] = new String[] {"02/02/1965","15/03/1963", "04/05/1993"};
	static Random rnd = new Random();
	static Activity basketball = new Activity(rnd.nextInt(100),"Basketball", "Ball game in teams where goal is to throw a ball into the other team's basket.", "Trento", new Date());
	static Activity yoga = new Activity(rnd.nextInt(100),"Yoga", "Ancient activty that helps both mental and physical health.", "Budapest", new Date());
	static Activity running = new Activity(rnd.nextInt(100),"Running", "Intensive cardio workout.", "Milan", new Date());
	
	private static Activity prefActivities[] = new Activity[] {basketball,yoga,running};
	
	public static void initializeDB(PeopleStore people) {
		Random random = new Random();
		int max = 3;

		for (int i = 0; i<20;i++) {
			Person person = new Person((long) i+1,firstNames[random.nextInt(max)], lastNames[random.nextInt(max)], sbDates[random.nextInt(max)], prefActivities[random.nextInt(max)]);
			people.getData().add(person);
		}
	}

}
