package com.example.deityaphrodite;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.ListView;

public class DeityAphroditePlanets extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_listview);
		
	    ListView listview = (ListView) findViewById(R.id.listview);
	    String[] values = new String[] { "Mercury", "Venus", "Earth",
	    		"Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};

	    MyArrayAdapter adapter = new MyArrayAdapter(this, values);
	    listview.setAdapter(adapter);
	    
	    //adapter.setListAdapter(adapter);
	        //	        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

	        //	          @Override
	        //	          public void onItemClick(AdapterView<?> parent, final View view,
	        //    int position, long id) {
	        //	            final String item = (String) parent.getItemAtPosition(position);
	        //	            view.animate().setDuration(2000).alpha(0)
	        //	                .withEndAction(new Runnable() {
	        //	                  @Override
	        //	                  public void run() {
	        //	                    list.remove(item);
	        //	                    adapter.notifyDataSetChanged();
	        //	                    view.setAlpha(1);
	        //	                  }
	        //	                });
	        //	          }

	        //	        });
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

}
