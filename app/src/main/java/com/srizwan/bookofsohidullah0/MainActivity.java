package com.srizwan.bookofsohidullah0;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.color.MaterialColors;
import com.yarolegovich.slidingrootnav.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout ln_1;
	
	private Intent in = new Intent();
	private TimerTask time;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		ln_1 = findViewById(R.id.ln_1);
	}
	
	private void initializeLogic() {
		PlanetView bcv = new PlanetView(this); ln_1.addView(bcv);
		time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						in.setClass(getApplicationContext(), Main0Activity.class);
						startActivity(in);
					}
				});
			}
		};
		_timer.schedule(time, (int)(1500));
	}
	
	public void onLowMemory() {
		super.onLowMemory();
		
	}
	public void _extraplanet() {
	} 
	
	public class PlanetView extends View { 
		
		private double angle=0;
		private Paint myPaint; 
		public PlanetView(Context context){ 
			super(context); 
			myPaint = new Paint(); 
			angle = 0; 
		} 
		
		@Override protected void onDraw(Canvas canvas) { 
			
			int viewWidth = this.getMeasuredWidth(); 
			int viewHeight = this.getMeasuredHeight(); angle = (angle + 0.001)%360; 
			
			float x = Math.round(260*Math.sin(Math.toDegrees(angle))); 
			float y = Math.round(140*Math.cos(Math.toDegrees(angle))); 
			float x2 = Math.round(120*Math.sin(90+Math.toDegrees(angle))); 
			float y2 = Math.round(290*Math.cos(90+Math.toDegrees(angle))); 
			float x3 = Math.round(130*Math.sin(180+Math.toDegrees(angle))); 
			float y3 = Math.round(230*Math.cos(180+Math.toDegrees(angle)));
			float x4 = Math.round(120*Math.sin(270+Math.toDegrees(angle))); 
			float y4 = Math.round(250*Math.cos(270+Math.toDegrees(angle)));
			
			
			myPaint.setStyle(android.graphics.Paint.Style.FILL); 
			
			myPaint.setColor(Color.parseColor("#eeeeee")); 
			canvas.drawCircle(viewWidth/2, viewHeight/2, (int)(x*1.5), myPaint);
			myPaint.setColor(Color.parseColor("#ffffff")); 
			canvas.drawCircle(viewWidth/2, viewHeight/2, (int)(x*1.5)-25, myPaint);
			
			myPaint.setColor(Color.parseColor("#f44235")); canvas.drawCircle(viewWidth/2 + x, viewHeight/2 + y, 15, myPaint);
			
			myPaint.setColor(Color.parseColor("#2096f3")); canvas.drawCircle(viewWidth/2 + x2, viewHeight/2 + y2, 20, myPaint);
			
			myPaint.setColor(Color.parseColor("#00e676")); canvas.drawCircle(viewWidth/2 + x3, viewHeight/2 + y3, 30, myPaint);
			
			myPaint.setColor(Color.parseColor("#ffff00")); canvas.drawCircle(viewWidth/2 + x4, viewHeight/2 + y4, 10, myPaint);
			
			
			
			android.graphics.drawable.Drawable d = getResources().getDrawable(R.drawable.all_211, null);
			d.setBounds((int)((viewWidth/2)-80-x/11), (int)((viewHeight/2)-80-x/11), (int)((viewWidth/2)+80+x/11), (int)((viewHeight/2)+80+x/11)); 
			d.draw(canvas);
			
			
			invalidate(); 
			
		}
	}
	
}
