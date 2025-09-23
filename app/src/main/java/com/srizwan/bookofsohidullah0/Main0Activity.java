package com.srizwan.bookofsohidullah0;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
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
import com.yarolegovich.slidingrootnav.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class Main0Activity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String a = "";
	private String b = "";
	private String copyshare = "";
	
	private LinearLayout main;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private ImageView imageview1;
	private LinearLayout linear2;
	private LinearLayout book;
	private TextView textview1;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout book1;
	private LinearLayout linear7;
	private LinearLayout book2;
	private LinearLayout linear9;
	private LinearLayout book3;
	private ImageView imageview2;
	private TextView textview2;
	private ImageView imageview3;
	private TextView textview3;
	private ImageView imageview4;
	private TextView textview5;
	private LinearLayout book6;
	private LinearLayout linear30;
	private LinearLayout book7;
	private LinearLayout linear32;
	private LinearLayout book8;
	private ImageView imageview13;
	private TextView textview11;
	private ImageView imageview17;
	private EditText edittext1;
	private TextView textview15;
	private ImageView imageview18;
	private TextView textview16;
	private LinearLayout book4;
	private LinearLayout linear23;
	private LinearLayout book5;
	private LinearLayout linear24;
	private LinearLayout book9;
	private ImageView imageview10;
	private TextView textview7;
	private ImageView imageview11;
	private EditText edittext2;
	private TextView textview8;
	private ImageView imageview12;
	private TextView textview10;
	private TextView textview6;
	private ImageView imageview6;
	private LinearLayout linear19;
	private ImageView imageview7;
	private LinearLayout linear20;
	private ImageView imageview8;
	private LinearLayout linear21;
	private ImageView imageview9;
	
	private Intent in = new Intent();
	private AlertDialog.Builder exit;
	private Intent mail = new Intent();
	private Intent rate = new Intent();
	private Intent inn = new Intent();
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main_0);
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
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		linear2 = findViewById(R.id.linear2);
		book = findViewById(R.id.book);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		linear5 = findViewById(R.id.linear5);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		book1 = findViewById(R.id.book1);
		linear7 = findViewById(R.id.linear7);
		book2 = findViewById(R.id.book2);
		linear9 = findViewById(R.id.linear9);
		book3 = findViewById(R.id.book3);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		imageview3 = findViewById(R.id.imageview3);
		textview3 = findViewById(R.id.textview3);
		imageview4 = findViewById(R.id.imageview4);
		textview5 = findViewById(R.id.textview5);
		book6 = findViewById(R.id.book6);
		linear30 = findViewById(R.id.linear30);
		book7 = findViewById(R.id.book7);
		linear32 = findViewById(R.id.linear32);
		book8 = findViewById(R.id.book8);
		imageview13 = findViewById(R.id.imageview13);
		textview11 = findViewById(R.id.textview11);
		imageview17 = findViewById(R.id.imageview17);
		edittext1 = findViewById(R.id.edittext1);
		textview15 = findViewById(R.id.textview15);
		imageview18 = findViewById(R.id.imageview18);
		textview16 = findViewById(R.id.textview16);
		book4 = findViewById(R.id.book4);
		linear23 = findViewById(R.id.linear23);
		book5 = findViewById(R.id.book5);
		linear24 = findViewById(R.id.linear24);
		book9 = findViewById(R.id.book9);
		imageview10 = findViewById(R.id.imageview10);
		textview7 = findViewById(R.id.textview7);
		imageview11 = findViewById(R.id.imageview11);
		edittext2 = findViewById(R.id.edittext2);
		textview8 = findViewById(R.id.textview8);
		imageview12 = findViewById(R.id.imageview12);
		textview10 = findViewById(R.id.textview10);
		textview6 = findViewById(R.id.textview6);
		imageview6 = findViewById(R.id.imageview6);
		linear19 = findViewById(R.id.linear19);
		imageview7 = findViewById(R.id.imageview7);
		linear20 = findViewById(R.id.linear20);
		imageview8 = findViewById(R.id.imageview8);
		linear21 = findViewById(R.id.linear21);
		imageview9 = findViewById(R.id.imageview9);
		exit = new AlertDialog.Builder(this);
		
		linear12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		book1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), BookiteamActivity.class);
				in.putExtra("1", textview2.getText().toString());
				startActivity(in);
			}
		});
		
		book2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), BookiteamActivity.class);
				in.putExtra("1", textview3.getText().toString());
				startActivity(in);
			}
		});
		
		book3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), BookiteamActivity.class);
				in.putExtra("1", textview5.getText().toString());
				startActivity(in);
			}
		});
		
		book6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), BookiteamActivity.class);
				in.putExtra("1", textview11.getText().toString());
				startActivity(in);
			}
		});
		
		book7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), BookiteamActivity.class);
				in.putExtra("1", textview15.getText().toString());
				startActivity(in);
			}
		});
		
		book8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), BookiteamActivity.class);
				in.putExtra("1", textview16.getText().toString());
				startActivity(in);
			}
		});
		
		edittext1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				book7.performClick();
			}
		});
		
		book4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), BookiteamActivity.class);
				in.putExtra("1", textview7.getText().toString());
				startActivity(in);
			}
		});
		
		book5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), BookiteamActivity.class);
				in.putExtra("1", textview8.getText().toString());
				startActivity(in);
			}
		});
		
		book9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), NamazActivity.class);
				startActivity(in);
			}
		});
		
		edittext2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				book5.performClick();
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				mail.setAction(Intent.ACTION_VIEW);
				mail.setData(Uri.parse("mailto:muhammodrizwan0@gmail.com"));
				startActivity(mail);
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				rate.setAction(Intent.ACTION_VIEW);
				rate.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.srrizwan.book"));
				startActivity(rate);
			}
		});
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				a = "এপ্সটি শেয়ার করুন";
				b = "শহিদুল্লাহ বাহাদুর গ্রন্থ সমগ্র\nhttps://play.google.com/store/apps/details?id=com.srizwan.bookofsohidullah";
				Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"এপ্সটি শেয়ার করুন"));
			}
		});
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				exit.setTitle("আপনি কি বের হতে চান?");
				exit.setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finishAffinity();
					}
				});
				exit.setNegativeButton("না", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				exit.create().show();
			}
		});
	}
	
	private void initializeLogic() {
		new SlidingRootNavBuilder(this)
		.withMenuLayout(R.layout.custom_view)
		.withRootViewElevation(25)
		.withDragDistance(210)
		.withRootViewScale(0.7f)
		.withToolbarMenuToggle(_toolbar)
		.inject();
		LinearLayout b1 = findViewById(R.id.color1);
		LinearLayout b2 = findViewById(R.id.color2);
		LinearLayout b3 = findViewById(R.id.color3);
		LinearLayout b4 = findViewById(R.id.color4);
		LinearLayout b5 = findViewById(R.id.color5);
		LinearLayout b6 = findViewById(R.id.color6);
		LinearLayout b7 = findViewById(R.id.color7);
		LinearLayout b8 = findViewById(R.id.color8);
		LinearLayout b9 = findViewById(R.id.color9);
		LinearLayout b10 = findViewById(R.id.color10);
		LinearLayout b11 = findViewById(R.id.color11);
		LinearLayout b12 = findViewById(R.id.color12);
		LinearLayout b13 = findViewById(R.id.color13);
		LinearLayout b14 = findViewById(R.id.color14);
		TextView t1 = findViewById(R.id.home);
		TextView t2 = findViewById(R.id.report);
		
		b8.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				inn.setAction(Intent.ACTION_VIEW);
				inn.setData(Uri.parse("https://www.facebook.com/faysal.ahmed.503645"));
				startActivity(inn);
			} });
		b1.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				inn.setAction(Intent.ACTION_VIEW);
				inn.setData(Uri.parse("https://www.sunni-encyclopedia.blogspot.com"));
				startActivity(inn);
			} });
		b2.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				inn.setAction(Intent.ACTION_VIEW);
				inn.setData(Uri.parse("https://www.facebook.com/md.masumbillah88"));
				startActivity(inn);
			} });
		
		b3.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				inn.setAction(Intent.ACTION_VIEW);
				inn.setData(Uri.parse("https://www.facebook.com/itsumon91"));
				startActivity(inn);
			} });
		
		b4.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				inn.setAction(Intent.ACTION_VIEW);
				inn.setData(Uri.parse("https://www.facebook.com/sirajum.munir.tanvir86"));
				startActivity(inn);
			} });
		
		b5.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				inn.setAction(Intent.ACTION_VIEW);
				inn.setData(Uri.parse("https://www.facebook.com/mahmud.hasan.ag"));
				startActivity(inn);
			} });
		
		b6.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				inn.setAction(Intent.ACTION_VIEW);
				inn.setData(Uri.parse("https://www.facebook.com/profile.php?id=61558924634935"));
				startActivity(inn);
			} });
		
		b7.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				inn.setAction(Intent.ACTION_VIEW);
				inn.setData(Uri.parse("https://www.facebook.com/itsumon91"));
				startActivity(inn);
			} });
		
		b11.setOnClickListener(new OnClickListener() { public void onClick(View view) {
			} });
		t1.setOnClickListener(new OnClickListener() { public void onClick(View view) {
			} });
		t2.setOnClickListener(new OnClickListener() { public void onClick(View view) {
			} });
		b9.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				intent.setAction(Intent.ACTION_VIEW);
						intent.setData(Uri.parse("https://play.google.com/store/apps/dev?id=6425257549079866616"));
						startActivity(intent);
						
			} });
		b10.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				inn.setAction(Intent.ACTION_VIEW);
						inn.setData(Uri.parse("https://play.google.com/store/apps/dev?id=7388137597678084794"));
						startActivity(inn);
						
			} });
		b11.setOnClickListener(new OnClickListener() { public void onClick(View view) {
			} });
		
		b12.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				imageview8.performClick();
			} });
		
		b13.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				imageview7.performClick();
			} });
		
		b14.setOnClickListener(new OnClickListener() { public void onClick(View view) {
				imageview9.performClick();
			} });
		
		
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		textview16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/font.ttf"), 0);
		_box(book1);
		_box(book2);
		_box(book3);
		_box(book4);
		_box(book5);
		_box(book6);
		_box(book7);
		_box(book8);
		_box(book9);
		edittext1.setEnabled(false);
		edittext2.setEnabled(false);
		edittext1.setSingleLine(true);
		edittext2.setSingleLine(true);
	}
	
	@Override
	public void onBackPressed() {
		exit.setTitle("আপনি কি বের হতে চান?");
		exit.setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finishAffinity();
			}
		});
		exit.setNegativeButton("না", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		exit.create().show();
	}
	public void _statusbarcolor(final String _color) {
		try {
			if(Build.VERSION.SDK_INT >= 21) {
				Window w = this.getWindow();
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
				w.setStatusBarColor(Color.parseColor(_color));
			}
		} catch (Exception e) {}
	}
	
	
	public void _box(final View _linear) {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF009688);
			SketchUi.setCornerRadius(d*18);
			SketchUi.setStroke(d*1,0xFFFFFFFF);
			_linear.setElevation(d*5);
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF009688}), SketchUi, null);
			_linear.setBackground(SketchUi_RD);
		}
	}
	
	
	public void _select() {
		
	}
	
}
