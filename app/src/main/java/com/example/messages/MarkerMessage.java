package com.example.messages;


import com.example.markers.SMarker;

import java.io.Serializable;
import java.util.HashMap;


public class MarkerMessage implements Serializable {
	HashMap<String, SMarker> sMarkers;
	
	public MarkerMessage(){
		sMarkers = new HashMap();
	}
	
	public void put(SMarker sMarker){
		sMarkers.put(sMarker.getTitle(), sMarker);
	}
	
	public HashMap<String, SMarker> getAll(){
		return sMarkers;
	}
}
