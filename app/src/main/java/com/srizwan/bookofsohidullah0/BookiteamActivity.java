package com.srizwan.bookofsohidullah0;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class BookiteamActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private double click = 0;
	private String a = "";
	private String b = "";
	private String sharecopy = "";
	private String search = "";
	private double length = 0;
	private double r = 0;
	private String value1 = "";
	private String fontName = "";
	private String typeace = "";
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout main;
	private ListView listview1;
	
	private Intent json123 = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.bookiteam);
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
		main = findViewById(R.id.main);
		listview1 = findViewById(R.id.listview1);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (map.get((int)_position).get("2").toString().equals("")) {
					
				} else {
					json123.setClass(getApplicationContext(), ReadingActivity.class);
					json123.putExtra("1", String.valueOf((long)(_position)));
					json123.putExtra("0", getIntent().getStringExtra("1"));
					startActivity(json123);
				}
			}
		});
	}
	
	private void initializeLogic() {
		setTitle(getIntent().getStringExtra("1"));
		_changeActivityFont("solaimanlipi");
		click = 0;
		try{
			java.io.InputStream inputstream1 = getAssets().open(getIntent().getStringExtra("1"));
			map = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(map));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}catch(Exception e){
			
		}
	}
	
	public String _replaceArabicNumber(final String _n) {
		String result = _n.replace("1", "১").replace("2", "২").replace("3", "৩").replace("4", "৪").replace("5", "৫").replace("6", "৬").replace("7", "৭").replace("8", "৮").replace("9", "৯").replace("0", "০");
		
		return result;
	}
	
	
	public String _Arabic(final String _n) {
		String result = _n.replace("<b>", " ").replace("</b>"," ").replace("(রহঃ)", "(رحمة الله)").replace("(রাঃ)", "(رضي الله عنه)").replace("(সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)", "(ﷺ)").replace(" (সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)","(ﷺ)").replace("(‘আঃ)", "(عليه السلام)").replace("(সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)", "(ﷺ)").replace("(রাঃ)", "(رضي الله عنه)").replace("[১]", "").replace("[২]", "").replace("[৩]", "").replace("(রহ)", "(رحمة الله)").replace("(রা)", "(رضي الله عنه)").replace("(সা)", "(ﷺ)").replace(" (সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)","(ﷺ)").replace("(‘আ)", "(عليه السلام)").replace("(সাঃ)", "(ﷺ)").replace("(রাঃ)", "(رضي الله عنه)").replace("(স)", "(ﷺ)").replace("বিবিন্‌ত", "বিন্‌ত").replace("বিন্ত", "বিন্‌ত").replace("(সা.)", "(ﷺ)").replace("(স.)", "(ﷺ)");
		return result;
	}
	
	
	public void _changeActivityFont(final String _fontname) {
		fontName = "fonts/".concat("solaimanlipi".concat(".ttf"));
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
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.booklist, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView textview7 = _view.findViewById(R.id.textview7);
			
			textview1.setText(_Arabic(map.get((int)_position).get("1").toString()));
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
			textview2.setVisibility(View.GONE);
			_changeActivityFont("solaimanlipi");
			if (map.get((int)_position).get("2").toString().equals("")) {
				linear1.setEnabled(false);
				textview1.setEnabled(false);
				textview2.setEnabled(false);
				textview1.setTextColor(0xFFFFFFFF);
				textview1.setTypeface(Typeface.DEFAULT, 1);
				linear1.setBackgroundColor(0xFF000000);
				textview1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
				textview1.setSingleLine(false);
				textview1.setGravity(Gravity.CENTER);
				textview1.setText(_Arabic(map.get((int)_position).get("1").toString()));
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
					SketchUi.setColor(0xFF000000);
					SketchUi.setCornerRadius(d*12);
					linear1.setElevation(d*6);
					linear1.setBackground(SketchUi);
				}
			} else {
				linear1.setEnabled(true);
				textview1.setEnabled(true);
				textview2.setEnabled(true);
				textview1.setSingleLine(true);
				linear1.setBackgroundColor(0xFFFFFFFF);
				textview1.setText(_Arabic(map.get((int)_position).get("1").toString()));
				textview1.setTypeface(Typeface.DEFAULT, 0);
				textview1.setTextColor(0xFF000000);
				textview1.setGravity(Gravity.LEFT); textview1.setTextDirection(View.TEXT_DIRECTION_RTL);
				if(Build.VERSION.SDK_INT >= 21) {
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
					SketchUi.setColor(0xFFFFFFFF);
					SketchUi.setCornerRadius(d*15);
					SketchUi.setStroke(d*1,0xFF009688);
					linear1.setElevation(d*8);
					android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF80CBC4}), SketchUi, null);
					linear1.setBackground(SketchUi_RD);
				}
			}
			if (map.get((int)_position).get("1").toString().contains("(দ:)")) {
				textview1.setText(map.get((int)_position).get("1").toString().replace("(দ:)", "(ﷺ)"));
			} else {
				
			}
			if (map.get((int)_position).get("1").toString().contains("(রা:)")) {
				textview1.setText(map.get((int)_position).get("1").toString().replace("(রা:)", "(رضي الله عنه)"));
			} else {
				
			}
			if (map.get((int)_position).get("1").toString().contains("(রহ:)")) {
				textview1.setText(map.get((int)_position).get("1").toString().replace("(রহ:)", "(رحمة الله)"));
			} else {
				
			}
			textview7.setText(_replaceArabicNumber(String.valueOf((long)(_position))));
			textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
			android.view.animation.Animation animation = new android.view.animation.ScaleAnimation(0f, 1f, 0f, 1f, android.view.animation.Animation.RELATIVE_TO_SELF, 0f, android.view.animation.Animation.RELATIVE_TO_SELF, 1f);
			animation.setFillAfter(true);
			animation.setDuration(300);
			linear1.setAnimation(animation);
			
			return _view;
		}
	}
}