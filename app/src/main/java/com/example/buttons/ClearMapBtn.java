package com.example.buttons;

import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Functionality for the Clear Button button.
 */
public class ClearMapBtn extends AppCompatActivity {
	public ClearMapBtn(){
	
	}
	
	public void clearMap(Button clear_map_btn,
	                     ConcurrentHashMap<Marker, Integer> markers,
	                     ConcurrentHashMap<Polyline, Integer> polylines){
		
		clear_map_btn.setOnClickListener(press -> {
			//Each marker must be cleared individually
			for(Marker marker : markers.keySet()){
				marker.remove();
			}
			
			markers.clear();
			
			for(Polyline polyline : polylines.keySet()){
				polyline.remove();
			}
			
			polylines.clear();
		});
	}
}
