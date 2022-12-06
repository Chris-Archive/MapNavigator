package com.example.markers;

import com.google.android.gms.maps.model.Marker;

import java.io.Serializable;

/**
 * A serializable version of a Marker. Used as a medium via intents.
 */
public class SMarker implements Serializable {
	double latitude;
	double longitude;
	String title;
	
	public SMarker(double latitude,
	               double longitude,
	               String title){
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.title = title;
	}
	
	public SMarker(Marker marker){
		latitude = marker.getPosition().latitude;
		longitude = marker.getPosition().longitude;
		title = marker.getTitle();
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
