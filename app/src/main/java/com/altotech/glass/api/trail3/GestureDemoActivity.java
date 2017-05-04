package com.altotech.glass.api.trail3;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.GestureDetector;

public class GestureDemoActivity extends Activity {

	private static final String TAG = "GestureDemoActivity";
	GestureDetector mGestureDetector = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture_demo);
		mGestureDetector = new GestureDetector(this,
				new MySimpleGestureDetectorListener());
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return mGestureDetector.onTouchEvent(event);
	}

	class MySimpleGestureDetectorListener extends
			GestureDetector.SimpleOnGestureListener {

		@Override
		public boolean onDown(boolean fromPhone) {
			Log.d(TAG, "onDown");
			return super.onDown(fromPhone);
		}

		@Override
		public boolean onLongPress(boolean fromPhone) {
			Log.d(TAG, "onLongPress");
			return super.onLongPress(fromPhone);
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY, boolean fromPhone) {
			Log.d(TAG, "onScroll");
			return super.onScroll(e1, e2, distanceX, distanceY, fromPhone);
		}

		@Override
		public boolean onSlideDown(boolean fromPhone) {
			Log.d(TAG, "onSlideDown");
			finish();
			return super.onSlideDown(fromPhone);
		}

		@Override
		public boolean onSlideLeft(boolean fromPhone) {
			Log.d(TAG, "onSlideLeft");
			return super.onSlideLeft(fromPhone);
		}

		@Override
		public boolean onSlideRight(boolean fromPhone) {
			Log.d(TAG, "onSlideRight");
			return super.onSlideRight(fromPhone);
		}

		@Override
		public boolean onSlideUp(boolean fromPhone) {
			Log.d(TAG, "onSlideUp");
			return super.onSlideUp(fromPhone);
		}

		@Override
		public boolean onTap(boolean fromPhone) {
			Log.d(TAG, "onTap");
			return super.onTap(fromPhone);
		}

		@Override
		public boolean onUp(MotionEvent ev, boolean fromPhone) {
			Log.d(TAG, "onUp");
			return super.onUp(ev, fromPhone);
		}

	}
}
