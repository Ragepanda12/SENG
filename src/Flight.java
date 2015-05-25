import java.util.Calendar;
import java.util.GregorianCalendar;

public class Flight {
	private GregorianCalendar departureTime;
	private GregorianCalendar arrivalTime;
	private City origin;
	private City destination;
	private int travelTime;
	private String airline;
	private int cost;
	
	public Flight(GregorianCalendar departureTime, City origin, 
			City destination, int travelTime, String airline, int cost){
		this.departureTime = departureTime;
		this.arrivalTime = (GregorianCalendar) departureTime.clone();
		this.arrivalTime.add(Calendar.HOUR_OF_DAY, travelTime);
		this.origin = origin;
		this.destination = destination;
		this.travelTime = travelTime;
		this.airline = airline;
		this.cost = cost;
	}
	
	public GregorianCalendar getDepartureTime() {
		return departureTime;
	}
	
	public GregorianCalendar getArrivalTime() {
		return arrivalTime;
	}

	public City getOrigin() {
		return origin;
	}

	public City getDestination() {
		return destination;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public String getAirline() {
		return airline;
	}

	public int getCost() {
		return cost;
	}
}
