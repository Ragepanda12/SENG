import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class ConsoleSystem {
	private static String input;
	private static ArrayList<String> lines = new ArrayList<String>();
	private static ArrayList<City> cities = new ArrayList<City>();
	private static String debugLastLine; //remove later
	
	public static void main(String[] args) {

	    Scanner sc = null;
	    try{
	    	sc = new Scanner(new FileReader(args[0]));
		    input = sc.useDelimiter("\\Z").next(); //dodgily read entire file into a string
	    }catch (FileNotFoundException e) {
	    }finally{
	        if (sc != null) sc.close();
	    }
	    //removes all newlines and spaces
	    input = input.replaceAll("\\s","");
	    
	    boolean validData = true;
	    //#####################################################################
	    FlightDataProcessing: 
	    if ((input.charAt(0) == '[') && (input.charAt(input.length()-1) == ']')){
		    input = input.substring(1, input.length()-1); 		//strips first [ and last ] 
		    String[] linesArray = input.split("\\]\\[");		//splits separate flights
		    for (String line: linesArray){
		    	lines.add(line); 								//because ArrayList > String[]!!! 
		    }
		    
		    GregorianCalendar departureTime = null;				//Is dateTime is valid for each flight
		    boolean originExists = false;						//Does city object for origin exist
		    boolean destinationExists = false;					//Does city object for destination exist
		    City origin = null;
		    City destination = null;
		    for (String line: lines){
		    	validData = true;								//can remove later, need now bc of "Continue"
		    	debugLastLine = line;
		    	String[] temp = line.split(",");
		    	if (temp.length != 7){
		    		validData = false;
		    		//break FlightDataProcessing; //temporarily commented out for debugging
		    		System.out.println("incorrectly formatted flight data: "+debugLastLine); //remove later
		    	} else {
		    		boolean validOrigin = checkName(temp[2]);
		    		boolean validDestination = checkName(temp[3]);
	    			int travelTime = checkNumber(temp[4]);
	    			boolean validAirline = checkName(temp[5]);
	    			int cost = checkNumber(temp[6]);
	    			if ((!validOrigin)||(!validDestination)||(travelTime == -1) || (!validAirline) || (cost == -1 )){
	    				validData = false;
	    				//break FlightDataProcessing; //temporarily commented out for debugging
	    				System.out.println("incorrectly formatted flight data: "+debugLastLine); //remove later
	    			}
	    			String[] date = temp[0].split("/");
	    			String[] time = temp[1].split(":");
	    			if ((date.length != 3) || (time.length != 2)){
	    				validData = false;
	    				System.out.println("incorrectly formatted flight data: "+debugLastLine); //remove later
	    				continue; //remove later
	    				//break FlightDataProcessing;	//temporarily commented out for debugging
	    			}
	    			int day = checkNumber(date[0]);
	    			int month = checkNumber(date[1]);
	    			int year = checkNumber(date[2]);
	    			int hour = checkNumber(time[0]);
	    			int minute = checkNumber(time[1]);
	    			
	    			if ((day == -1)||(month == -1)||(year == -1)||(hour == -1)||(minute == -1)){
	    				validData = false;
	    				System.out.println("incorrectly formatted flight data: "+debugLastLine); //remove later
	    				continue; //remove later
	    				//break FlightDataProcessing;	//temporarily commented out for debugging	    				
	    			}
	    			
	    			departureTime = checkDateTime(day, month, year, hour, minute);
		    		if (departureTime != null){
		    			// ========== [START] FIND/MAKE CITY OBJECTS ==========
		    		    originExists = false;
		    		    destinationExists = false;
		    			for (City c: cities){					
		    				if (c.getName().equals(temp[2])){
		    					originExists = true;
		    					origin = c;
		    				} else if (c.getName().equals(temp[3])){
		    					destinationExists = true;
		    					destination = c;
		    				}
		    			}
		    			if (!originExists){
		    				origin = new City(temp[2]);
		    				cities.add(origin);
		    			}
		    			if (!destinationExists){
		    				destination = new City(temp[3]);
		    				cities.add(destination);
		    			}
		    			// ========== [END] FIND/MAKE CITY OBJECTS ==========

		    			Flight newFlight = new Flight(departureTime, origin, destination, travelTime, temp[5], cost); 
		    			origin.addFlight(newFlight);
		    			System.out.println("Flight made"); //remove later
		    		} else {
		    			System.out.println("Invalid date/time in entry: [" + line + "]" );
		    		}
		    	}
		    }
	    } else {
	    	validData = false;
	    }
	    
	    //#######################################################################
	    if (validData){//currently not accurate because validData is reset before each line for debugging purposes
	    	System.out.println("Valid file, continue"); //remove later 
	    	//TODO process queries and stuff
	    } else {
	    	System.out.println("incorrectly formatted flight data");
	    	System.out.println("["+debugLastLine+"]"); //remove later
	    }
	    
	}
	
	private static GregorianCalendar checkDateTime(int day, int month, int year, int hour, int minute){
		if ((day < 1)||(day > 31)||
				(month < 1)||(month > 12)||
				(year < 2000) || (year > 2500)||
				(hour < 0 ) || (hour > 23)|| 
				(minute < 0) || (minute > 59)){
			return null;
		}
		
		//TODO check for specific days of month, e.g. february 30th,
		//TODO do we have to check leap years :(
		//TODO maybe we can use some kind of "TRY make gregorian calendar, CATCH if fails then return null" kinda thing??
		
		GregorianCalendar newCalendar = new GregorianCalendar(year, month-1, day, hour, minute);
		
		return newCalendar;
	}

	//returns the string as an integer
	//returns -1 if cannot be converted into integer
	private static int checkNumber(String str){
		for (int i=0; i < str.length(); i++){
			char c = str.charAt(i);
			if (c<'0'||c>'9'){
				return -1;
			}
		}
		return Integer.parseInt(str);
	}
	
	private static boolean checkName(String str){
		char c = str.charAt(0);
		if (c<'A'||c>'Z'){
			return false;
		} else {
			for (int i=1; i < str.length(); i++){
				c = str.charAt(i);
				if (c<'a'||c>'z'){
					return false;
				}
			}
		}
		return true;
	}
}
