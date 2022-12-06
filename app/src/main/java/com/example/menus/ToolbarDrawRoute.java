package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mapnavigator.R;
import com.example.markers.SMarker;
import com.example.messages.MarkerMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ToolbarDrawRoute extends AppCompatActivity {
	HashMap<String, SMarker> sMarkers;
	String start;
	String end;
	
	public ToolbarDrawRoute(){
		start = "";
		end = "";
	}
	
	private void setToolbar(){
		Toolbar main_toolbar = findViewById(R.id.draw_route_toolbar);
		main_toolbar.setTitle(R.string.draw_route_toolbar_settings_title);
		setSupportActionBar(main_toolbar);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.draw_route_toolbar);
		Button draw_route_btn = findViewById(R.id.draw_route_btn);
		
		MarkerMessage markerMessage = (MarkerMessage) getIntent().getSerializableExtra("markers");
		sMarkers = markerMessage.getAll();
		
		draw_route_btn.setOnClickListener(press -> {
			Toast.makeText(ToolbarDrawRoute.this, String.valueOf(sMarkers.size()), Toast.LENGTH_LONG).show();
			
			if(!start.equals(end) &&
					!start.equals("") &&
					!end.equals("")){
				this.onBackPressed();
			}
		});
		
		setToolbar();
		setSpinners();
	}
	
	@Override
	public void onBackPressed(){
		Intent intent = new Intent();
		intent.putExtra("name", this.getClass().getSimpleName());
		intent.putExtra("start", sMarkers.get(start));
		intent.putExtra("end", sMarkers.get(end));
		setResult(0, intent);
		ToolbarDrawRoute.super.onBackPressed();
	}
	
	private void setSpinners(){
		final Spinner drawRouteStartMarker = findViewById(R.id.draw_route_start_marker);
		final Spinner drawRouteEndMarker = findViewById(R.id.draw_route_end_marker);
		
		ArrayList<String> markerNames = new ArrayList<>(sMarkers.keySet());
		
		ArrayAdapter<String> adapter = new ArrayAdapter<>(ToolbarDrawRoute.this,
				R.layout.travel_method_list, markerNames);
		
		adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
		drawRouteStartMarker.setAdapter(adapter);
		drawRouteEndMarker.setAdapter(adapter);
		
		drawRouteStartMarker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
				start = adapterView.getItemAtPosition(i).toString();
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
				start = "";
			}
		});
		
		drawRouteEndMarker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
				end = adapterView.getItemAtPosition(i).toString();
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
				end = "";
			}
		});
	}
}