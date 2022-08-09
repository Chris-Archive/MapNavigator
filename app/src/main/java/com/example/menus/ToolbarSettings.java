package com.example.menus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mapnavigator.R;

public class ToolbarSettings extends AppCompatActivity {
	private Spinner unit_type;
	private String[] distance_units;
	private String unit;
	
	/**
	 * Automatically set the selected unit in the dropdown spinner menu to save results
	 */
	private void getSelectedSpinnerOption(){
		unit_type.setSelection(0);
		
		for(int i = 0; i < distance_units.length; ++i){
			if(unit.equals(distance_units[i].toLowerCase())){
				unit_type.setSelection(i);
				return;
			}
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toolbar_settings);
		unit_type = findViewById(R.id.main_toolbar_settings_distanceunit);
		distance_units = new String[]{"Metric", "Imperial"};
		unit = getIntent().getStringExtra("unit");
		ArrayAdapter<String> adapter = new ArrayAdapter<>(
				ToolbarSettings.this,
				R.layout.toolbar_settings_settings_distanceunit_textview,
				distance_units
		);
		
		adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
		unit_type.setAdapter(adapter);
		getSelectedSpinnerOption();
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
		
	}
	
	@Override
	public void onBackPressed(){
		Intent intent = new Intent();
		intent.putExtra("unit", unit);
		setResult(0, intent);
		ToolbarSettings.super.onBackPressed();
	}
}
