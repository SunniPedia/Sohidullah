package com.srizwan.bookofsohidullah0;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yarolegovich.slidingrootnav.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.provider.Settings; 
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.content.Context;

public class NamazActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String fontName = "";
	private String typeace = "";
	private HashMap<String, Object> hostIP = new HashMap<>();
	private String City = "";
	private String Country = "";
	private String strCity = "";
	private String strCountry = "";
	private String d = "";
	private String Asr_remples = "";
	private String Maghrb_remplase = "";
	private String Isha_remplase = "";
	
	private ScrollView vscroll2;
	private LinearLayout farem;
	private LinearLayout namaz;
	private TextView Longitude;
	private TextView Latitude;
	private LinearLayout linear22;
	private LinearLayout linear14;
	private LinearLayout niz;
	private LinearLayout ci;
	private LinearLayout linear25;
	private LinearLayout co;
	private ImageView imageview11;
	private TextView textview44;
	private TextView textview34;
	private TextView city;
	private ImageView notification;
	private TextView textview46;
	private TextView textview48;
	private TextView country;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear19;
	private LinearLayout linear18;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private TextView textview19;
	private ImageView imageview5;
	private TextView fajr;
	private TextView textview36;
	private TextView textview20;
	private ImageView imageview6;
	private TextView duhur;
	private TextView textview39;
	private TextView textview21;
	private ImageView imageview7;
	private TextView asr;
	private TextView textview51;
	private TextView textview22;
	private ImageView imageview8;
	private TextView maghrib;
	private TextView textview52;
	private TextView textview23;
	private ImageView imageview9;
	private TextView isha;
	private TextView textview53;
	private TextView textview24;
	private ImageView imageview10;
	private TextView midnight;
	private TextView textview43;
	private TextView textview50;
	private TextView textview49;
	
	private Intent intent = new Intent();
	private SharedPreferences save;
	private RequestNetwork Rr;
	private RequestNetwork.RequestListener _Rr_request_listener;
	private RequestNetwork Salate;
	private RequestNetwork.RequestListener _Salate_request_listener;
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private TimerTask timer;
	private AlertDialog.Builder in;
	private AlertDialog.Builder inter;
	private AlertDialog.Builder Inter;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.namaz);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		vscroll2 = findViewById(R.id.vscroll2);
		farem = findViewById(R.id.farem);
		namaz = findViewById(R.id.namaz);
		Longitude = findViewById(R.id.Longitude);
		Latitude = findViewById(R.id.Latitude);
		linear22 = findViewById(R.id.linear22);
		linear14 = findViewById(R.id.linear14);
		niz = findViewById(R.id.niz);
		ci = findViewById(R.id.ci);
		linear25 = findViewById(R.id.linear25);
		co = findViewById(R.id.co);
		imageview11 = findViewById(R.id.imageview11);
		textview44 = findViewById(R.id.textview44);
		textview34 = findViewById(R.id.textview34);
		city = findViewById(R.id.city);
		notification = findViewById(R.id.notification);
		textview46 = findViewById(R.id.textview46);
		textview48 = findViewById(R.id.textview48);
		country = findViewById(R.id.country);
		linear15 = findViewById(R.id.linear15);
		linear16 = findViewById(R.id.linear16);
		linear19 = findViewById(R.id.linear19);
		linear18 = findViewById(R.id.linear18);
		linear20 = findViewById(R.id.linear20);
		linear21 = findViewById(R.id.linear21);
		textview19 = findViewById(R.id.textview19);
		imageview5 = findViewById(R.id.imageview5);
		fajr = findViewById(R.id.fajr);
		textview36 = findViewById(R.id.textview36);
		textview20 = findViewById(R.id.textview20);
		imageview6 = findViewById(R.id.imageview6);
		duhur = findViewById(R.id.duhur);
		textview39 = findViewById(R.id.textview39);
		textview21 = findViewById(R.id.textview21);
		imageview7 = findViewById(R.id.imageview7);
		asr = findViewById(R.id.asr);
		textview51 = findViewById(R.id.textview51);
		textview22 = findViewById(R.id.textview22);
		imageview8 = findViewById(R.id.imageview8);
		maghrib = findViewById(R.id.maghrib);
		textview52 = findViewById(R.id.textview52);
		textview23 = findViewById(R.id.textview23);
		imageview9 = findViewById(R.id.imageview9);
		isha = findViewById(R.id.isha);
		textview53 = findViewById(R.id.textview53);
		textview24 = findViewById(R.id.textview24);
		imageview10 = findViewById(R.id.imageview10);
		midnight = findViewById(R.id.midnight);
		textview43 = findViewById(R.id.textview43);
		textview50 = findViewById(R.id.textview50);
		textview49 = findViewById(R.id.textview49);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);
		Rr = new RequestNetwork(this);
		Salate = new RequestNetwork(this);
		network = new RequestNetwork(this);
		in = new AlertDialog.Builder(this);
		inter = new AlertDialog.Builder(this);
		Inter = new AlertDialog.Builder(this);
		
		_Rr_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				hostIP = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				if (hostIP.get("status").toString().equals("success")) {
					City = strCity;
					Country = strCountry;
					Salate.startRequestNetwork(RequestNetworkController.GET, "http://api.aladhan.com/v1/timingsByCity?city=".concat("Narayanganj".concat("&country=".concat("Bangladesh".concat("&method=8")))), "", _Salate_request_listener);
				} else {
					
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_Salate_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				d = _response;
				if (Country.contains("Bangladesh")) {
					Asr_remples = d.substring((int)(d.indexOf("\"Asr\":\"")), (int)(d.indexOf("\",\"Sunset\":\""))).replace("\"Asr\":\"", "");
					Maghrb_remplase = d.substring((int)(d.indexOf("\"Maghrib\":\"")), (int)(d.indexOf("\",\"Isha\":\""))).replace("\"Maghrib\":\"", "");
					Isha_remplase = d.substring((int)(d.indexOf("\"Isha\":\"")), (int)(d.indexOf("\",\"Imsak\":\""))).replace("\"Isha\":\"", "");
					asr.setText(Asr_remples);
					maghrib.setText(Maghrb_remplase);
					isha.setText(Isha_remplase);
					fajr.setText(d.substring((int)(d.indexOf("\"Fajr\":\"")), (int)(d.indexOf("\",\"Sunrise\":\""))).replace("\"Fajr\":\"", ""));
					midnight.setText(d.substring((int)(d.indexOf("\"Sunrise\":\"")), (int)(d.indexOf("\",\"Dhuhr\":\""))).replace("\"Sunrise\":\"", ""));
					duhur.setText(d.substring((int)(d.indexOf("\"Dhuhr\":\"")), (int)(d.indexOf("\",\"Asr\":\""))).replace("\"Dhuhr\":\"", ""));
					textview50.setText(d.substring((int)(d.indexOf("\"Imsak\":\"")), (int)(d.indexOf("\",\"Midnight\":\""))).replace("\"Imsak\":\"", ""));
				} else {
					fajr.setText(d.substring((int)(d.indexOf("\"Fajr\":\"")), (int)(d.indexOf("\",\"Sunrise\":\""))).replace("\"Fajr\":\"", ""));
					midnight.setText(d.substring((int)(d.indexOf("\"Sunrise\":\"")), (int)(d.indexOf("\",\"Dhuhr\":\""))).replace("\"Sunrise\":\"", ""));
					duhur.setText(d.substring((int)(d.indexOf("\"Dhuhr\":\"")), (int)(d.indexOf("\",\"Asr\":\""))).replace("\"Dhuhr\":\"", ""));
					maghrib.setText(d.substring((int)(d.indexOf("\"Maghrib\":\"")), (int)(d.indexOf("\",\"Isha\":\""))).replace("\"Maghrib\":\"", ""));
					isha.setText(d.substring((int)(d.indexOf("\"Isha\":\"")), (int)(d.indexOf("\",\"Imsak\":\""))).replace("\"Isha\":\"", ""));
					textview50.setText(d.substring((int)(d.indexOf("\"Imsak\":\"")), (int)(d.indexOf("\",\"Midnight\":\""))).replace("\"Imsak\":\"", ""));
					asr.setText(d.substring((int)(d.indexOf("\"Asr\":\"")), (int)(d.indexOf("\",\"Sunset\":\""))).replace("\"Asr\":\"", ""));
				}
				save.edit().putString("A", fajr.getText().toString()).commit();
				save.edit().putString("B", midnight.getText().toString()).commit();
				save.edit().putString("C", duhur.getText().toString()).commit();
				save.edit().putString("D", asr.getText().toString()).commit();
				save.edit().putString("E", maghrib.getText().toString()).commit();
				save.edit().putString("F", isha.getText().toString()).commit();
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				network.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com", "ss", _network_request_listener);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			network.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com", "ss", _network_request_listener);
			Rr.startRequestNetwork(RequestNetworkController.GET, "http://ip-api.com/json/", "", _Rr_request_listener);
		} else {
			Inter.setMessage("আপনার ইন্টারনেট সংযোগ চালু করুন।");
			Inter.setPositiveButton("ঠিক আছে", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			Inter.setNegativeButton("বাতিল", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			Inter.create().show();
		}
		textview50.setVisibility(View.GONE);
		_changeActivityFont("myfont");
		_GradientDrawable(linear15, 15, 0, 5, "#FFFFFF", "#9E9E9E", true, true, 25);
		_GradientDrawable(linear16, 15, 0, 5, "#FFFFFF", "#9E9E9E", true, true, 25);
		_GradientDrawable(linear21, 15, 0, 5, "#FFFFFF", "#9E9E9E", true, true, 25);
		_GradientDrawable(linear18, 15, 0, 5, "#FFFFFF", "#9E9E9E", true, true, 25);
		_GradientDrawable(linear19, 15, 0, 5, "#FFFFFF", "#9E9E9E", true, true, 25);
		_GradientDrawable(linear20, 15, 0, 5, "#FFFFFF", "#9E9E9E", true, true, 25);
		_GradientDrawable(ci, 15, 0, 5, "#FFFFFF", "#9E9E9E", true, true, 25);
		_GradientDrawable(co, 15, 0, 5, "#FFFFFF", "#9E9E9E", true, true, 25);
		_GradientDrawable(notification, 15, 0, 5, "#FFFFFF", "#9E9E9E", true, true, 25);
		android.graphics.drawable.GradientDrawable TARU_Ui = new android.graphics.drawable.GradientDrawable();
		int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
		TARU_Ui.setColor(0xFFFFFFFF);TARU_Ui.setCornerRadii(new float[]{
			d*47,d*47,d*47 ,d*47,d*0,d*0 ,d*0,d*0});
		TARU_Ui.setStroke(d*5,0xFF009688);
		android.graphics.drawable.RippleDrawable TARU_Ui_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), TARU_Ui, null);
		niz.setBackground(TARU_Ui_RD);
		niz.setClickable(true);
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			final Window window = NamazActivity.this.getWindow();
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(0xFF009688);
		}
		linear25.setVisibility(View.INVISIBLE);
		setTitle("নামাজের সময় সূচি");
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		if (save.getString("A", "").equals("")) {
			
		} else {
			fajr.setText(save.getString("A", ""));
		}
		if (save.getString("B", "").equals("")) {
			
		} else {
			midnight.setText(save.getString("B", ""));
		}
		if (save.getString("C", "").equals("")) {
			
		} else {
			duhur.setText(save.getString("C", ""));
		}
		if (save.getString("D", "").equals("")) {
			
		} else {
			asr.setText(save.getString("D", ""));
		}
		if (save.getString("E", "").equals("")) {
			
		} else {
			maghrib.setText(save.getString("E", ""));
		}
		if (save.getString("F", "").equals("")) {
			
		} else {
			isha.setText(save.getString("F", ""));
		}
		if (save.getString("cityii", "").equals("")) {
			
		} else {
			city.setText(save.getString("cityii", ""));
		}
		if (save.getString("countyi", "").equals("")) {
			
		} else {
			country.setText(save.getString("countyi", ""));
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
	}
	public void _detect_links_(final TextView _txt) {
		_txt.setClickable(true);
		android.text.util.Linkify.addLinks(_txt, android.text.util.Linkify.ALL);
		_txt.setLinkTextColor(Color.parseColor("#2196F3"));
		_txt.setLinksClickable(true);
	}
	
	
	public void _GradientDrawable(final View _view, final double _radius, final double _stroke, final double _shadow, final String _color, final String _borderColor, final boolean _ripple, final boolean _clickAnim, final double _animDuration) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int)_stroke,Color.parseColor(_borderColor));
			if (Build.VERSION.SDK_INT >= 21){
				_view.setElevation((int)_shadow);}
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9E9E9E")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		} else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			gd.setStroke((int)_stroke,Color.parseColor(_borderColor));
			_view.setBackground(gd);
			if (Build.VERSION.SDK_INT >= 21){
				_view.setElevation((int)_shadow);}
		}
		if (_clickAnim) {
			_view.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(_view);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration((int)_animDuration);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(_view);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration((int)_animDuration);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(_view);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration((int)_animDuration);
							scaleX.start();
							
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(_view);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues((float)1);
							scaleY.setDuration((int)_animDuration);
							scaleY.start();
							
							break;
						}
					}
					return false;
				}
			});
		}
	}
	
	
	public void _changeActivityFont(final String _fontname) {
		fontName = "fonts/".concat(_fontname.concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
		try {
			Typeface 
			typeace = Typeface.createFromAsset(getAssets(), fontName);;
			if ((v instanceof ViewGroup)) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}
			} else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(typeace);
				} else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(typeace);
					} else {
						if ((v instanceof Button)) {
							((Button) v).setTypeface(typeace);
						}
					}
				}
			}
		}
		catch(Exception e)
		
		{
			SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
		};
	}
	
	
	public void _advancedCorners(final View _view, final String _color, final double _n1, final double _n2, final double _n3, final double _n4) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n4,(int)_n4,(int)_n3,(int)_n3});
		
		_view.setBackground(gd);
	}
	
	
	public void _SetBackground(final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		} else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
	}
	
	
	public String _replaceArabicNumber(final String _n) {
		String result = _n.replace("1", "১").replace("2", "২").replace("3", "৩").replace("4", "৪").replace("5", "৫").replace("6", "৬").replace("7", "৭").replace("8", "৮").replace("9", "৯").replace("0", "০");
		
		return result;
	}
	
}