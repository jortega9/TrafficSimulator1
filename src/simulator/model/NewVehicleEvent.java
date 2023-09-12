package simulator.model;

import java.util.ArrayList;
import java.util.List;

public class NewVehicleEvent extends Event{
	
	private String id;
	private int maxSpeed;
	private int contClass;
	private List<String> itinerary;

	public NewVehicleEvent(int time, String id, int maxSpeed, int contClass, List<String> itinerary) {
		super(time);
		this.id = id;
		this.maxSpeed = maxSpeed;
		this.contClass = contClass;
		this.itinerary = new ArrayList<>(itinerary);
	}

	void execute(RoadMap map) {
		try {
			List<Junction> aux = new ArrayList<>();
			
			for(int i = 0; i < itinerary.size(); i++) {
				aux.add(map.getJunction(itinerary.get(i)));
			}
			
			Vehicle v = new Vehicle(id, maxSpeed, contClass, aux); 
			v.moveToNextRoad();
			map.addVehicle(v);
		}
		catch(IllegalArgumentException ie) {
			System.out.println(ie.getMessage() + " NewCityRoadEvent: addJunction \n");
		}
	}

}
