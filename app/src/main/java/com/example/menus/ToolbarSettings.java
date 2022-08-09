package com.example.menus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.mapnavigator.R;

public class ToolbarSettings extends AppCompatActivity {
	private Spinner unit_type;
	private String[] distance_units;
	private String unit;
	
	/**
	 * Set and localize the top toolbar for the settings option.
	 */
	private void setToolbar(){
		Toolbar main_toolbar = findViewById(R.id.main_toolbar);
		main_toolbar.setTitle(R.string.main_toolbar_settings_title);
		setSupportActionBar(main_toolbar);
	}
	
	/**
	 * Set the distance spinners to allocate the available values.
	 */
	private void setDistanceSpinner(){
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
				if(!unit.equals(adapterView.getItemAtPosition(i).toString().toLowerCase())){
					unit = adapterView.getItemAtPosition(i).toString();
					Toast.makeText(ToolbarSettings.this, unit + " selected", Toast.LENGTH_SHORT).show();
				}
				unit = unit.toLowerCase();
				System.out.printf("%s\n", unit);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {
				unit = "metric";
			}
		});
	}
	
	/**
	 * Automatically set the selected unit in the dropdown spinner menu to save results
	 */
	private void getSelectedSpinnerOption(){
		for(int i = 0; i < distance_units.length; ++i){
			if(unit.equals(distance_units[i].toLowerCase())){
				unit_type.setSelection(i);
				return;
			}
		}
		
		unit_type.setSelection(0);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toolbar_settings);
		setToolbar();
		unit_type = findViewById(R.id.main_toolbar_settings_distanceunit);
		distance_units = new String[]{"Metric", "Imperial"};
		unit = getIntent().getStringExtra("unit");
		
		this.setDistanceSpinner();
		
	}
	
	@Override
	public void onBackPressed(){
		Intent intent = new Intent();
		intent.putExtra("unit", unit);
		setResult(0, intent);
		ToolbarSettings.super.onBackPressed();
	}
}
