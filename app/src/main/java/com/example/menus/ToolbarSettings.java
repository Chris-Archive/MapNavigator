package com.example.menus;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mapnavigator.R;
import com.example.tracecallbacks.SettingsCallback;

import java.sql.Array;
import java.util.Locale;

public class ToolbarSettings extends AppCompatActivity {
	private SettingsCallback settingsCallback;
	private Spinner unit_type;
	private String[] distance_units;
	private String unit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		unit_type = findViewById(R.id.main_toolbar_settings_distanceunit);
		distance_units = new String[]{"Metric", "Imperial"};
		unit = "metric";
		settingsCallback = (SettingsCallback) ToolbarSettings.this;
		
		ArrayAdapter<String> adapter = new ArrayAdapter<>(ToolbarSettings.this,
				R.layout.travel_method_list, distance_units);
		
		adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
		unit_type.setAdapter(adapter);
		unit_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
				unit = adapterView.getItemAtPosition(i).toString();
				Toast.makeText(ToolbarSettings.this, unit + " selected", Toast.LENGTH_SHORT).show();
				unit = unit.toLowerCase();
				System.out.printf("%s\n", unit);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
				unit = "metric";
			}
		});
		
		settingsCallback.onDistanceSetting(unit);
	}
}
