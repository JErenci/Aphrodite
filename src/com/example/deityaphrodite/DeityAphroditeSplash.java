package com.example.deityaphrodite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

public class DeityAphroditeSplash extends Activity{

    private final int SPLASH_DISPLAY_LENGHT = 2000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	       setContentView(R.layout.layout_splash);

	        /* New Handler to start the Menu-Activity 
	         * and close this Splash-Screen after some seconds.*/
	        new Handler().postDelayed(new Runnable(){
	            @Override
	            public void run() {
	                /* Create an Intent that will start the Menu-Activity. */
	                Intent mainIntent = new Intent(DeityAphroditeSplash.this,
	                		DeityAphroditeMainActivity.class);
	                startActivity(mainIntent);
	                finish();
	            }
	        }, SPLASH_DISPLAY_LENGHT);
	}
}
