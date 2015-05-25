import java.util.ArrayList;

public class City {
	private String name;
	private ArrayList<Flight> departingFlights;
	private int numPaths; // Number of paths leading to it

	public City (String name){
		this.name = name;
		departingFlights = new ArrayList<Flight>();
		numPaths = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public void addFlight(Flight flight){
		departingFlights.add(flight);
	}
	
	public ArrayList<Flight> getFlights(){
		return departingFlights;
	}
    
    public Flight getFlightTo(City dest) {
        for(Flight f : departingFlights){
            if(dest.equals(f.getDestination()))
                return f;
        }
        return null;
    }

	public int getNumPaths() {
		return this.numPaths;
	}

	public void incrementNumPaths() {
		this.numPaths++;
	}
    
    public boolean equals (Object o) {
        if (o instanceof City){
            City c = (City) o;
            if(c.name.equals(name) && c.departingFlights.equals(departingFlights))
                return true;
        }
        return false;
    }
}
