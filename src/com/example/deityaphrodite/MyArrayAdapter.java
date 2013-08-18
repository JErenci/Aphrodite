package com.example.deityaphrodite;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<String> {
	  private final Context context;
	  private final String[] values;

	  public MyArrayAdapter(Context context, String[] values) {
	    super(context, R.layout.layout_planets, values);
	    this.context = context;
	    this.values = values;
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.layout_planets, parent, false);
	    TextView textView = (TextView) rowView.findViewById(R.id.descrPlanet);
	    ImageView imageView = (ImageView) rowView.findViewById(R.id.iconPlanet);
	    
	    String s = values[position];
	    textView.setText(s);
	    // Change the icon for Windows and iPhone

	    String name = s.toLowerCase();
	    int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
	    Log.e("id", String.valueOf(id));
	    Log.e("id", s);
	    Log.e("id", name);
	    
	    imageView.setImageResource(id);

	    return rowView;
	  }
	} 