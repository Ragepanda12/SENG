import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class ConsoleSystem {
	public static void main(String[] args) {
		Scanner sc = null;
		
	      try {
	          sc = new Scanner(new FileReader(args[0]));
	          
	          //scans in the format
	          //[12/5/2015,10:34,Sydney,Melbourne,90,Airlinea,30]
	          while(sc.hasNext()) {
	        	  String string = sc.next();
	        	  String[] parts = string.split(",");
	        	  String part1 = parts[0]; //[12/5/2015
	        	  String part2 = parts[1]; //10:34
	        	  String part3 = parts[2]; //Sydney
	        	  String part4 = parts[3]; //Melbourne
	        	  String part5 = parts[4]; //90
	        	  String part6 = parts[5]; //Airlinea
	        	  String part7 = parts[6]; //30]
	        	  
	        	  part1 = part1.substring(1);	//deletes the "["
	        	  part7 = part7.substring(0, part7.length()-1);	//deletes the "]"
	        	 
	        	  
	        	  /*if(sc.next().equals("[")) {
	        		  int day = sc.nextInt();
	        		  sc.next();
	        		  int month = sc.nextInt();
	        		  sc.next();
	        		  int year = sc.nextInt();
	        		  sc.next();
	        		  
	        		  int hour = sc.nextInt();
	        		  sc.next();
	        		  int minutes = sc.nextInt();
	        		  sc.next();
	        		  
	        		  String origin = sc.next();
	        		  sc.next();
	        		  String destination = sc.next();
	        		  sc.next();
	        		  
	        		  int duration = sc.nextInt();
	        		  sc.next();
	        		  
	        		  String airline = sc.next();
	        		  sc.next();
	        		  
	        		  int number = sc.nextInt();
	        		  sc.next();
	        		  
	        		  System.out.println(day + " " + month + " " + year + " " + hour + " " + minutes + " " + origin + " "
	        				  + destination + " " + duration + " " + airline + " " + number);
	        	  }*/
	          }
	          
	          sc.close();
	      }
	      catch (FileNotFoundException e) {
	    	  e.printStackTrace();
	      }
	}

}
