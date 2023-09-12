package simulator.model;

import java.util.List;

import simulator.misc.Pair;

public class SetContClassEvent extends Event {

	private List<Pair<String, Integer>> cs;

	public SetContClassEvent(int time, List<Pair<String, Integer>> cs) {
		super(time);
		if (cs == null)
			throw new IllegalArgumentException("ERROR en constructor NewSetContClassEvent: cs es null");
		this.cs = cs;
	}

	void execute(RoadMap map) {
		for (Pair<String, Integer> p : cs) {
			try {
				map.getVehicle(p.getFirst()).setContClass(p.getSecond());
			} catch (IllegalArgumentException ie) {
				System.out.println(ie.getMessage() + " NewSetContClassEvent: No Existe vehiculo \n");
			}
		}
	}

}
