package com.example.deityaphrodite;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeityAphroditeLearn extends Activity{

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_learn);
	
        Button buttonFavs = (Button) findViewById(R.id.button4);
        buttonFavs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	final Intent myIntent = new Intent(DeityAphroditeLearn.this, 
            			DeityAphroditeLearnAgencies.class);
        		startActivity(myIntent);
            }
        });

        Button buttonISS = (Button) findViewById(R.id.button1);
        buttonISS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	final Intent myIntent = new Intent(DeityAphroditeLearn.this, 
            			DeityAphroditeISS.class);
        		startActivity(myIntent);
            }
        });

        Button buttonPlanets = (Button) findViewById(R.id.buttonPlanets);
        buttonPlanets.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	final Intent myIntent = new Intent(DeityAphroditeLearn.this, 
            			DeityAphroditePlanets.class);
        		startActivity(myIntent);
            }
        });

        ActionBar actionBar = getActionBar();
		onPause();
		onStop();
		actionBar.setDisplayHomeAsUpEnabled(true);
		onDestroy();
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	
	private void showAgencies(View view)
	{
		//Intent intent = new Intent(this, DeityAphroditeSearch.class);
		//startActivity(intent);
		
		Intent myIntent = new Intent(this, DeityAphroditeLearnAgencies.class);
		EditText editText = (EditText) findViewById(R.id.initial_Text);
		String message = editText.getText().toString();
		myIntent.putExtra(EXTRA_MESSAGE, message);
		//myIntent.putExtra("key", value); //Optional parameters
		startActivity(myIntent);
	}
	
	
}
