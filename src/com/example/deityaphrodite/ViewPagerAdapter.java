package com.example.deityaphrodite;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ViewPagerAdapter extends PagerAdapter{

	private int imageArra[] = { R.drawable.esa, R.drawable.nasa,
			   R.drawable.roscosmos};
	
	Activity activity;
	 int imageArray[];

	 public ViewPagerAdapter(Activity act, int[] imgArra) {
	  imageArray = imageArra;
	  activity = act;
	 }
	 
	 public int getCount() {
		  return imageArray.length;
	 }

	 public Object instantiateItem(View collection, int position) {
		  ImageView view = new ImageView(activity);
		  view.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
		    LayoutParams.FILL_PARENT));
		  view.setScaleType(ScaleType.FIT_XY);
		  view.setBackgroundResource(imageArray[position]);
		  ((ViewPager) collection).addView(view, 0);
		  return view;
	 }
	 
	 @Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		 ((ViewPager) container).removeView((View) object);
	}
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == ((View) arg1);
	}
	
	@Override
	public Parcelable saveState() {
		// TODO Auto-generated method stub
		return null;
	}

}
