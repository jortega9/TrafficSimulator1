package simulator.factories;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import simulator.misc.Pair;
import simulator.model.Event;
import simulator.model.SetWeatherEvent;
import simulator.model.Weather;

public class SetWeatherEventBuilder extends Builder<Event>{

	public SetWeatherEventBuilder() {
		super("set_weather");
	}

	protected Event createTheInstance(JSONObject data) {
		int time = data.getInt("time");
		JSONArray ws = data.getJSONArray("info");
		List<Pair<String,Weather>> w = new ArrayList<>();
		JSONObject aux;
		for(int i = 0; i < ws.length(); i++) {
			aux = ws.getJSONObject(i);
			w.add(new Pair<String, Weather>(aux.getString("road"), Weather.valueOf(aux.getString("weather"))));
		}
		
		return new SetWeatherEvent(time, w);
	}

}
