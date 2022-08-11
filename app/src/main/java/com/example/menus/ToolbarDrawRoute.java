package com.example.menus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import com.example.mapnavigator.R;

public class ToolbarDrawRoute extends AppCompatActivity {
	
	private void setToolbar(){
		Toolbar main_toolbar = findViewById(R.id.draw_route_toolbar);
		main_toolbar.setTitle(R.string.draw_route_toolbar_settings_title);
		setSupportActionBar(main_toolbar);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.draw_route_toolbar);
		
		setToolbar();
	}
	
	@Override
	public void onBackPressed(){
		Intent intent = new Intent();
		intent.putExtra("name", this.getClass().getSimpleName());
		setResult(0, intent);
		ToolbarDrawRoute.super.onBackPressed();
	}
}