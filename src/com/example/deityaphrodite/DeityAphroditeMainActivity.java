package com.example.deityaphrodite;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.QuickContactBadge;

public class DeityAphroditeMainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final int REQUEST_CODE = 1;
    private Bitmap bitmap;
    private ImageView imageView;
    private QuickContactBadge badge;
	// private int imageArra[] = { R.drawable.esa, R.drawable.nasa,
	//		   R.drawable.space};

	@Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        imageView = (ImageView) findViewById(R.id.result);
        badge = (QuickContactBadge) findViewById(R.id.badge);

        Button buttonLearn = (Button) findViewById(R.id.buttonStart1);
        buttonLearn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	final Intent myIntent = new Intent(DeityAphroditeMainActivity.this, 
            			DeityAphroditeLearn.class);
        		startActivity(myIntent);
            }
        });
    
        Button buttonPlay = (Button) findViewById(R.id.buttonStart2);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	final Intent myIntent = new Intent(DeityAphroditeMainActivity.this, 
            			DeityAphroditePlay.class);
        		startActivity(myIntent);
            }
        });
        
        Button buttonFavs = (Button) findViewById(R.id.buttonStart3);
        buttonFavs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	final Intent myIntent = new Intent(DeityAphroditeMainActivity.this, 
            			DeityAphroditeFavs.class);
        		startActivity(myIntent);
            }
        });
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        
        // ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageArra);
        // ViewPager myPager = (ViewPager) findViewById(R.id.myfivepanelpager);
        // myPager.setAdapter(adapter);
        // myPager.setCurrentItem(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.deity_aphrodite_main, menu);
        // return true;
    	ActionBar actionBar = getActionBar();

    	// Inflate the menu items for use in the action bar
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.deity_aphrodite_menu, menu);
        return true;
        // return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
            	Intent intent = new Intent(Intent.ACTION_VIEW,
            	          Uri.parse("content://contacts/people"));
            	if (intent != null)
            	      startActivity(intent);
                return true;
            case R.id.action_compose:
            	// Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));
            	//Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
            	// intent2.putExtra(intent2.EXTRA_EMAIL, false);
            	// if (intent2 != null)
            	//	startActivity(intent2);
            	openSearch();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

	private void openSearch() {
		// TODO Auto-generated method stub
		// Intent intent = new Intent(this, DeityAphroditeSearch.class);
		// startActivity(intent);
		
		Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK)
            try {
                // We need to recyle unused bitmaps
                if (bitmap != null) {
                    bitmap.recycle();
                }
                InputStream stream = getContentResolver().openInputStream(
                        data.getData());
                bitmap = BitmapFactory.decodeStream(stream);
                stream.close();
                imageView.setImageBitmap(bitmap);
                //badge.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        super.onActivityResult(requestCode, resultCode, data);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	private void sendMessageLearn(View view)
	{
		//Intent intent = new Intent(this, DeityAphroditeSearch.class);
		//startActivity(intent);
		
		Intent myIntent = new Intent(this, DeityAphroditeLearn.class);
		EditText editText = (EditText) findViewById(R.id.initial_Text);
		String message = editText.getText().toString();
		myIntent.putExtra(EXTRA_MESSAGE, message);
		//myIntent.putExtra("key", value); //Optional parameters
		startActivity(myIntent);
	}

	private void sendMessagePlay(View view)
	{
		//Intent intent = new Intent(this, DeityAphroditeSearch.class);
		//startActivity(intent);
		
		Intent myIntent = new Intent(this, DeityAphroditePlay.class);
		EditText editText = (EditText) findViewById(R.id.initial_Text);
		String message = editText.getText().toString();
		myIntent.putExtra(EXTRA_MESSAGE, message);
		//myIntent.putExtra("key", value); //Optional parameters
		startActivity(myIntent);
	}

	private void sendMessageFavs(View view)
	{
		//Intent intent = new Intent(this, DeityAphroditeSearch.class);
		//startActivity(intent);
		
		Intent myIntent = new Intent(this, DeityAphroditeFavs.class);
		EditText editText = (EditText) findViewById(R.id.initial_Text);
		String message = editText.getText().toString();
		myIntent.putExtra(EXTRA_MESSAGE, message);
		//myIntent.putExtra("key", value); //Optional parameters
		startActivity(myIntent);
	}

}
