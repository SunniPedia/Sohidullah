package com.srizwan.bookofsohidullah0;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ReadingActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String endStr = "";
	private double i = 0;
	private String a = "";
	private String b = "";
	private double textsize = 0;
	private String newName = "";
	private String copyshare = "";
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private ViewPager viewpager1;
	
	private TimerTask timer;
	private SharedPreferences book;
	private Intent inn = new Intent();
	private Intent intent = new Intent();
	private TimerTask time;
	private AlertDialog.Builder renameDialog;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.reading);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		viewpager1 = findViewById(R.id.viewpager1);
		book = getSharedPreferences("book", Activity.MODE_PRIVATE);
		renameDialog = new AlertDialog.Builder(this);
		
		viewpager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				
			}
			
			@Override
			public void onPageSelected(int _position) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				
			}
		});
	}
	
	private void initializeLogic() {
		try{
			java.io.InputStream inputstream1 = getAssets().open(getIntent().getStringExtra("0"));
			map = new Gson().fromJson(SketchwareUtil.copyFromInputStream(inputstream1), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			viewpager1.setAdapter(new Viewpager1Adapter(map));
			((PagerAdapter)viewpager1.getAdapter()).notifyDataSetChanged();
		}catch(Exception e){
			
		}
		viewpager1.setCurrentItem((int)Double.parseDouble(getIntent().getStringExtra("1")));
		viewpager1.setPageTransformer(true, new DefaultTransformer());
		
		((androidx.viewpager.widget.PagerAdapter)viewpager1.getAdapter()).notifyDataSetChanged();
		textsize = 16;
	}
	
	public void _enable_copy_textview(final TextView _tv) {
		_tv.setTextIsSelectable(true);
	}
	
	
	public void _type_effect(final String _Text, final TextView _textview, final double _deley) {
		endStr = "";
		i = 0;
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (!(i == _Text.length())) {
							String jg=""+_Text;
							
							char ug = jg.charAt((int) i);
							
							endStr = endStr+""+ug;
							
							_textview.setText(endStr);
							i++;
						} else {
							timer.cancel();
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(_deley), (int)(_deley));
	}
	
	
	public void _marquue(final TextView _text, final String _texto) {
		_text.setText(_texto);
		_text.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		_text.setSelected(true);
		_text.setHorizontallyScrolling(true);
		_text.setMarqueeRepeatLimit(-1);
		_text.setSingleLine(true);
		_text.setFocusable(true);
		_text.setFocusableInTouchMode(true);
	}
	
	
	public void _shadow(final View _v) {
		//15 - height of shadow
		try {
			if(Build.VERSION.SDK_INT >= 21) {
				_v.setElevation(10f);
			}
		} catch (Exception e) {}
	}
	
	
	public String _replaceArabicNumber(final String _n) {
		String result = _n.replace("<b>", " ").replace("</b>"," ").replace("(রহঃ)", "(رحمة الله)").replace("(রাঃ)", "(رضي الله عنه)").replace("(সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)", "(ﷺ)").replace(" (সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)","(ﷺ)").replace("(‘আঃ)", "(عليه السلام)").replace("(সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)", "(ﷺ)").replace("(রাঃ)", "(رضي الله عنه)").replace("[১]", "").replace("[২]", "").replace("[৩]", "").replace("(রহ)", "(رحمة الله)").replace("(রা)", "(رضي الله عنه)").replace("(সা)", "(ﷺ)").replace(" (সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)","(ﷺ)").replace("(‘আ)", "(عليه السلام)").replace("(সাঃ)", "(ﷺ)").replace("(রাঃ)", "(رضي الله عنه)").replace("(স)", "(ﷺ)").replace("বিবিন্‌ত", "বিন্‌ত").replace("বিন্ত", "বিন্‌ত").replace("(সা.)", "(ﷺ)").replace("(স.)", "(ﷺ)");
		return result;
	}
	
	
	public String _Arabic(final String _n) {
		String result = _n.replace("<b>", " ").replace("</b>"," ").replace("(রহঃ)", "(رحمة الله)").replace("(রাঃ)", "(رضي الله عنه)").replace("(সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)", "(ﷺ)").replace(" (সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)","(ﷺ)").replace("(‘আঃ)", "(عليه السلام)").replace("(সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)", "(ﷺ)").replace("(রাঃ)", "(رضي الله عنه)").replace("[১]", "").replace("[২]", "").replace("[৩]", "").replace("(রহ)", "(رحمة الله)").replace("(রা)", "(رضي الله عنه)").replace("(সা)", "(ﷺ)").replace(" (সাল্লাল্লাহু ‘আলাইহি ওয়া সাল্লাম)","(ﷺ)").replace("(‘আ)", "(عليه السلام)").replace("(সাঃ)", "(ﷺ)").replace("(রাঃ)", "(رضي الله عنه)").replace("(স)", "(ﷺ)").replace("বিবিন্‌ত", "বিন্‌ত").replace("বিন্ত", "বিন্‌ত").replace("(সা.)", "(ﷺ)").replace("(স.)", "(ﷺ)");
		return result;
	}
	
	
	public void _ViewPagerAnimationsLibrary() {
	}
	public static abstract class BaseTransformer implements androidx.viewpager.widget.ViewPager.PageTransformer {
		protected abstract void onTransform(View view, float position);
		@Override
		public void transformPage(View view, float position) {
			onPreTransform(view, position);
			onTransform(view, position);
			onPostTransform(view, position);
		}
		protected boolean hideOffscreenPages() {
			return true;
		}
		protected boolean isPagingEnabled() {
			return false;
		}
		protected void onPreTransform(View view, float position) {
			final float width = view.getWidth();
			view.setRotationX(0);
			view.setRotationY(0);
			view.setRotation(0);
			view.setScaleX(1);
			view.setScaleY(1);
			view.setPivotX(0);
			view.setPivotY(0);
			view.setTranslationY(0);
			view.setTranslationX(isPagingEnabled() ? 0f : -width * position);
			if (hideOffscreenPages()) {
				view.setAlpha(position <= -1f || position >= 1f ? 0f : 1f);
			} else {
				view.setAlpha(1f);
			}
		}
		protected void onPostTransform(View view, float position) {
		}
	}
	public static class AccordionTransformer extends BaseTransformer {
		@Override
		protected void onTransform(View view, float position) {
			view.setPivotX(position < 0 ? 0 : view.getWidth());
			view.setScaleX(position < 0 ? 1f + position : 1f - position);
		}
	}
	public static class BackgroundToForegroundTransformer extends BaseTransformer {
		@Override
		protected void onTransform(View view, float position) {
			final float height = view.getHeight();
			final float width = view.getWidth();
			final float scale = min(position < 0 ? 1f : Math.abs(1f - position), 0.5f);
			view.setScaleX(scale);
			view.setScaleY(scale);
			view.setPivotX(width * 0.5f);
			view.setPivotY(height * 0.5f);
			view.setTranslationX(position < 0 ? width * position : -width * position * 0.25f);
		}
		private static final float min(float val, float min) {
			return val < min ? min : val;
		}
	}
	public static class CubeInTransformer extends BaseTransformer {
		@Override
		protected void onTransform(View view, float position) {
			view.setPivotX(position > 0 ? 0 : view.getWidth());
			view.setPivotY(0);
			view.setRotationY(-90f * position);
		}
		@Override
		public boolean isPagingEnabled() {
			return true;
		}
	}
	public static class CubeOutTransformer extends BaseTransformer {
		@Override
		protected void onTransform(View view, float position) {
			view.setPivotX(position < 0f ? view.getWidth() : 0f);
			view.setPivotY(view.getHeight() * 0.5f);
			view.setRotationY(90f * position);
		}
		@Override
		public boolean isPagingEnabled() {
			return true;
		}
	}
	public static class DefaultTransformer extends BaseTransformer {
		@Override protected void onTransform(View view, float position) {}
		@Override public boolean isPagingEnabled() {
			return true;
		}
	}
	public static class DepthPageTransformer extends BaseTransformer {
		private static final float MIN_SCALE = 0.75f;
		@Override
		protected void onTransform(View view, float position) {
			if (position <= 0f) {
				view.setTranslationX(0f);
				view.setScaleX(1f);
				view.setScaleY(1f);
			} else if (position <= 1f) {
				final float scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position));
				view.setAlpha(1 - position);
				view.setPivotY(0.5f * view.getHeight());
				view.setTranslationX(view.getWidth() * -position);
				view.setScaleX(scaleFactor);
				view.setScaleY(scaleFactor);
			}
		}
		@Override
		protected boolean isPagingEnabled() {
			return true;
		}
	}
	public static class ZoomOutTranformer extends BaseTransformer {
		@Override
		protected void onTransform(View view, float position) {
			final float scale = 1f + Math.abs(position);
			view.setScaleX(scale);
			view.setScaleY(scale);
			view.setPivotX(view.getWidth() * 0.5f);
			view.setPivotY(view.getHeight() * 0.5f);
			view.setAlpha(position < -1f || position > 1f ? 0f : 1f - (scale - 1f));
			if(position == -1){
				view.setTranslationX(view.getWidth() * -1);
			}
		}
	}
	public static class StackTransformer extends BaseTransformer {
		@Override
		protected void onTransform(View view, float position) {
			view.setTranslationX(position < 0 ? 0f : -view.getWidth() * position);
		}
	}
	public static class TabletTransformer extends BaseTransformer {
		private static final Matrix OFFSET_MATRIX = new Matrix();
		private static final Camera OFFSET_CAMERA = new Camera();
		private static final float[] OFFSET_TEMP_FLOAT = new float[2];
		@Override
		protected void onTransform(View view, float position) {
			final float rotation = (position < 0 ? 30f : -30f) * Math.abs(position);
			view.setTranslationX(getOffsetXForRotation(rotation, view.getWidth(), view.getHeight()));
			view.setPivotX(view.getWidth() * 0.5f);
			view.setPivotY(0);
			view.setRotationY(rotation);
		}
		protected static final float getOffsetXForRotation(float degrees, int width, int height) {
			OFFSET_MATRIX.reset();
			OFFSET_CAMERA.save();
			OFFSET_CAMERA.rotateY(Math.abs(degrees));
			OFFSET_CAMERA.getMatrix(OFFSET_MATRIX);
			OFFSET_CAMERA.restore();
			OFFSET_MATRIX.preTranslate(-width * 0.5f, -height * 0.5f);
			OFFSET_MATRIX.postTranslate(width * 0.5f, height * 0.5f);
			OFFSET_TEMP_FLOAT[0] = width;
			OFFSET_TEMP_FLOAT[1] = height;
			OFFSET_MATRIX.mapPoints(OFFSET_TEMP_FLOAT);
			return (width - OFFSET_TEMP_FLOAT[0]) * (degrees > 0.0f ? 1.0f : -1.0f);
		}
	}
	public static class ZoomInTransformer extends BaseTransformer {
		@Override
		protected void onTransform(View view, float position) {
			final float scale = position < 0 ? position + 1f : Math.abs(1f - position);
			view.setScaleX(scale);
			view.setScaleY(scale);
			view.setPivotX(view.getWidth() * 0.5f);
			view.setPivotY(view.getHeight() * 0.5f);
			view.setAlpha(position < -1f || position > 1f ? 0f : 1f - (scale - 1f));
		}
	}
	public static class ZoomOutSlideTransformer extends BaseTransformer {
		private static final float MIN_SCALE = 0.85f;
		private static final float MIN_ALPHA = 0.5f;
		@Override
		protected void onTransform(View view, float position) {
			if (position >= -1 || position <= 1) {
				final float height = view.getHeight();
				final float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
				final float vertMargin = height * (1 - scaleFactor) / 2;
				final float horzMargin = view.getWidth() * (1 - scaleFactor) / 2;
				view.setPivotY(0.5f * height);
				if (position < 0) {
					view.setTranslationX(horzMargin - vertMargin / 2);
				} else {
					view.setTranslationX(-horzMargin + vertMargin / 2);
				}
				view.setScaleX(scaleFactor);
				view.setScaleY(scaleFactor);
				view.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));
			}
		}
	}
	public static class ForegroundToBackgroundTransformer extends BaseTransformer {
		@Override
		protected void onTransform(View view, float position) {
			final float height = view.getHeight();
			final float width = view.getWidth();
			final float scale = min(position > 0 ? 1f : Math.abs(1f + position), 0.5f);
			view.setScaleX(scale);
			view.setScaleY(scale);
			view.setPivotX(width * 0.5f);
			view.setPivotY(height * 0.5f);
			view.setTranslationX(position > 0 ? width * position : -width * position * 0.25f);
		}
		private static final float min(float val, float min) {
			return val < min ? min : val;
		}
	}
	public static class ParallaxPageTransformer extends BaseTransformer {
		private final int viewToParallax;
		public ParallaxPageTransformer(final int viewToParallax) {
			this.viewToParallax = viewToParallax;
		}
		@Override
		protected void onTransform(View view, float position) {
			int pageWidth = view.getWidth();
			if (position < -1) {
				view.setAlpha(1);
			} else if (position <= 1) {
				view.findViewById(viewToParallax).setTranslationX(-position * (pageWidth / 2));
			} else {
				view.setAlpha(1);
			}
		}
	}
	public static class RotateDownTransformer extends BaseTransformer {
		private static final float ROT_MOD = -15f;
		@Override
		protected void onTransform(View view, float position) {
			final float width = view.getWidth();
			final float height = view.getHeight();
			final float rotation = ROT_MOD * position * -1.25f;
			view.setPivotX(width * 0.5f);
			view.setPivotY(height);
			view.setRotation(rotation);
		}
		@Override
		protected boolean isPagingEnabled() {
			return true;
		}
	}
	public static class RotateUpTransformer extends BaseTransformer {
		private static final float ROT_MOD = -15f;
		@Override
		protected void onTransform(View view, float position) {
			final float width = view.getWidth();
			final float rotation = ROT_MOD * position;
			view.setPivotX(width * 0.5f);
			view.setPivotY(0f);
			view.setTranslationX(0f);
			view.setRotation(rotation);
		}
		@Override
		protected boolean isPagingEnabled() {
			return true;
		}
	}
	public static class DrawFromBackTransformer implements androidx.viewpager.widget.ViewPager.PageTransformer {
		private static final float MIN_SCALE = 0.75f;
		@Override
		public void transformPage(View view, float position) {
			int pageWidth = view.getWidth();
			if (position < -1 || position > 1) {
				view.setAlpha(0);
				return;
			}
			if (position <= 0) {
				view.setAlpha(1 + position);
				view.setTranslationX(pageWidth * -position);
				float scaleFactor = MIN_SCALE
				+ (1 - MIN_SCALE) * (1 - Math.abs(position));
				view.setScaleX(scaleFactor);
				view.setScaleY(scaleFactor);
				return;
			}
			if (position > 0.5 && position <= 1) {
				view.setAlpha(0);
				view.setTranslationX(pageWidth * -position);
				return;
			}
			if (position > 0.3 && position <= 0.5) {
				view.setAlpha(1);
				view.setTranslationX(pageWidth * position);
				float scaleFactor = MIN_SCALE;
				view.setScaleX(scaleFactor);
				view.setScaleY(scaleFactor);
				return;
			}
			if (position <= 0.3) {
				view.setAlpha(1);
				view.setTranslationX(pageWidth * position);
				float v = (float) (0.3 - position);
				v = v >= 0.25f ? 0.25f : v;
				float scaleFactor = MIN_SCALE + v;
				view.setScaleX(scaleFactor);
				view.setScaleY(scaleFactor);
			}
		}
	}
	public static class FlipHorizontalTransformer extends BaseTransformer {
		@Override
		protected void onTransform(View view, float position) {
			final float rotation = 180f * position;
			view.setVisibility(rotation > 90f || rotation < -90f ? View.INVISIBLE : View.VISIBLE);
			view.setPivotX(view.getWidth() * 0.5f);
			view.setPivotY(view.getHeight() * 0.5f);
			view.setRotationY(rotation);
		}
	}
	public static class FlipVerticalTransformer extends BaseTransformer {
		@Override
		protected void onTransform(View view, float position) {
			final float rotation = -180f * position;
			view.setVisibility(rotation > 90f || rotation < -90f ? View.INVISIBLE : View.VISIBLE);
			view.setPivotX(view.getWidth() * 0.5f);
			view.setPivotY(view.getHeight() * 0.5f);
			view.setRotationX(rotation);
		}
	}
	
	public static class VerticalShutTransformation implements androidx.viewpager.widget.ViewPager.PageTransformer{
		@Override
		public void transformPage(View page, float position) {
			
			page.setTranslationX(-position*page.getWidth());
			page.setCameraDistance(999999999);
			
			if (position < 0.5 && position > -0.5){
				page.setVisibility(View.VISIBLE);
			}
			else {
				page.setVisibility(View.INVISIBLE);
			}
			
			
			
			if (position < -1){     // [-Infinity,-1)
				// This page is way off-screen to the left.
				page.setAlpha(0);
				
			}
			else if (position <= 0 ){    // [-1,0]
				page.setAlpha(1);
				page.setRotationX(180*(1-Math.abs(position)+1));
				
			}
			else if (position <= 1){    // (0,1]
				page.setAlpha(1);
				page.setRotationX(-180*(1-Math.abs(position)+1));
				
			}
			else {    // (1,+Infinity]
				// This page is way off-screen to the right.
				page.setAlpha(0);
				
			}
			
			
		}
	}
	
	
	public static class TossTransformation implements androidx.viewpager.widget.ViewPager.PageTransformer {
		@Override
		public void transformPage(View page, float position) {
			
			page.setTranslationX(-position * page.getWidth());
			page.setCameraDistance(20000);
			
			
			if (position < 0.5 && position > -0.5) {
				page.setVisibility(View.VISIBLE);
				
			} else {
				page.setVisibility(View.INVISIBLE);
				
			}
			
			
			if (position < -1) {     // [-Infinity,-1)
				// This page is way off-screen to the left.
				page.setAlpha(0);
				
			}
			else if (position <= 0) {    // [-1,0]
				page.setAlpha(1);
				page.setScaleX(Math.max(0.4f, (1 - Math.abs(position))));
				page.setScaleY(Math.max(0.4f, (1 - Math.abs(position))));
				page.setRotationX(1080 * (1 - Math.abs(position) + 1));
				page.setTranslationY(-1000*Math.abs(position));
				
			}
			else if (position <= 1) {    // (0,1]
				page.setAlpha(1);
				page.setScaleX(Math.max(0.4f, (1-Math.abs(position))));
				page.setScaleY(Math.max(0.4f, (1-Math.abs(position))));
				page.setRotationX(-1080 * (1 - Math.abs(position) + 1));
				page.setTranslationY(-1000*Math.abs(position));
				
			}
			else {    // (1,+Infinity]
				// This page is way off-screen to the right.
				page.setAlpha(0);
				
			}
		}
	}
	
	{
	}
	
	
	public void _variable() {
	}
	private androidx.viewpager.widget.ViewPager viewpager;
	{
	}
	
	
	public String _num(final String _n) {
		String result = _n.replace("1", "১").replace("2", "২").replace("3", "৩").replace("4", "৪").replace("5", "৫").replace("6", "৬").replace("7", "৭").replace("8", "৮").replace("9", "৯").replace("0", "০").replace("-", "");
		
		return result;
	}
	
	
	public String _REPLACE(final String _n) {
		String result = _n.replace("১", "1").replace("২", "2").replace("৩", "3").replace("৪", "4").replace("৫", "5").replace("৬", "6").replace("৭", "7").replace("৮", "8").replace("৯", "9").replace("০", "0").replace("/ ", "");
		
		return result;
	}
	
	
	public void _space(final TextView _txt) {
		_txt.setLineSpacing(1,2);
	}
	
	public class Viewpager1Adapter extends PagerAdapter {
		
		Context _context;
		ArrayList<HashMap<String, Object>> _data;
		
		public Viewpager1Adapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {
			_context = _ctx;
			_data = _arr;
		}
		
		public Viewpager1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_context = getApplicationContext();
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public boolean isViewFromObject(View _view, Object _object) {
			return _view == _object;
		}
		
		@Override
		public void destroyItem(ViewGroup _container, int _position, Object _object) {
			_container.removeView((View) _object);
		}
		
		@Override
		public int getItemPosition(Object _object) {
			return super.getItemPosition(_object);
		}
		
		@Override
		public CharSequence getPageTitle(int pos) {
			// Use the Activity Event (onTabLayoutNewTabAdded) in order to use this method
			return "page " + String.valueOf(pos);
		}
		
		@Override
		public Object instantiateItem(ViewGroup _container,  final int _position) {
			View _view = LayoutInflater.from(_context).inflate(R.layout.viewpager, _container, false);
			
			final LinearLayout bg = _view.findViewById(R.id.bg);
			final LinearLayout hideview = _view.findViewById(R.id.hideview);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ScrollView vscroll = _view.findViewById(R.id.vscroll);
			final LinearLayout ad = _view.findViewById(R.id.ad);
			final LinearLayout Tab = _view.findViewById(R.id.Tab);
			final ImageView back = _view.findViewById(R.id.back);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear12 = _view.findViewById(R.id.linear12);
			final LinearLayout next = _view.findViewById(R.id.next);
			final LinearLayout pagenumberbox = _view.findViewById(R.id.pagenumberbox);
			final TextView heding = _view.findViewById(R.id.heding);
			final ImageView imageview3 = _view.findViewById(R.id.imageview3);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView page = _view.findViewById(R.id.page);
			final TextView pagenumber = _view.findViewById(R.id.pagenumber);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final LinearLayout back1 = _view.findViewById(R.id.back1);
			final LinearLayout share = _view.findViewById(R.id.share);
			final LinearLayout copy = _view.findViewById(R.id.copy);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final LinearLayout high = _view.findViewById(R.id.high);
			final LinearLayout low = _view.findViewById(R.id.low);
			final LinearLayout next1 = _view.findViewById(R.id.next1);
			final ImageView imageview4 = _view.findViewById(R.id.imageview4);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final ImageView imageview5 = _view.findViewById(R.id.imageview5);
			final ImageView imageview6 = _view.findViewById(R.id.imageview6);
			final ImageView imageview7 = _view.findViewById(R.id.imageview7);
			final ImageView imageview8 = _view.findViewById(R.id.imageview8);
			final TextView hide = _view.findViewById(R.id.hide);
			final LinearLayout book = _view.findViewById(R.id.book);
			final LinearLayout bookback = _view.findViewById(R.id.bookback);
			final LinearLayout linear20 = _view.findViewById(R.id.linear20);
			final LinearLayout booknext0 = _view.findViewById(R.id.booknext0);
			final ImageView imageview9 = _view.findViewById(R.id.imageview9);
			final ImageView imageview14 = _view.findViewById(R.id.imageview14);
			
			if (map.get((int)_position).containsKey("1")) {
				heding.setText(_replaceArabicNumber(map.get((int)_position).get("1").toString()));
			}
			if (map.get((int)_position).containsKey("2")) {
				textview1.setText(_replaceArabicNumber(map.get((int)_position).get("2").toString()).trim());
			}
			if (textview1.getText().toString().contains("(রা:)")) {
				textview1.setText(textview1.getText().toString().replace("(রা:)", "(رضي الله عنه)"));
			}
			if (textview1.getText().toString().contains("(রহ:)")) {
				textview1.setText(textview1.getText().toString().replace("(রহ:)", "(رحمة الله)"));
			}
			if (map.get((int)_position).get("1").toString().contains("(দ:)")) {
				heding.setText(map.get((int)_position).get("1").toString().replace("(দ:)", "(ﷺ)"));
			}
			if (heding.getText().toString().contains("(রা:)")) {
				heding.setText(map.get((int)_position).get("1").toString().replace("(রা:)", "(رضي الله عنه)"));
			}
			if (heding.getText().toString().contains("(রহ:)")) {
				heding.setText(map.get((int)_position).get("1").toString().replace("(রহ:)", "(رحمة الله)"));
			}
			if (textview1.getText().toString().contains("</p>") || textview1.getText().toString().contains("<br>")) {
				textview1.setText(Html.fromHtml(map.get((int)_position).get("2").toString()));
			}
			heding.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
			_shadow(linear2);
			_enable_copy_textview(textview1);
			if (map.get((int)_position).get("2").toString().equals("")) {
				bg.setVisibility(View.GONE);
				heding.setText("❏ ".concat(_Arabic(map.get((int)_position).get("1").toString())));
			} else {
				bg.setVisibility(View.VISIBLE);
				heding.setText(_Arabic(map.get((int)_position).get("1").toString()));
			}
			if (map.get((int)_position).containsKey("1")) {
				hide.setText(_Arabic(map.get((int)_position).get("1").toString()));
			}
			hide.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 1);
			android.view.animation.Animation animation = new android.view.animation.ScaleAnimation(0f, 1f, 0f, 1f, android.view.animation.Animation.RELATIVE_TO_SELF, 0f, android.view.animation.Animation.RELATIVE_TO_SELF, 1f);
			animation.setFillAfter(true);
			animation.setDuration(300);
			bg.setAnimation(animation);
			hideview.setAnimation(animation);
			back.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					finish();
				}
			});
			_marquue(heding, _Arabic(map.get((int)_position).get("1").toString()));
			next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					viewpager1.setCurrentItem((int)_position + 1);
				}
			});
			Tab.setVisibility(View.VISIBLE);
			back1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (_position == 0) {
						
					} else {
						viewpager1.setCurrentItem((int)_position - 1);
					}
				}
			});
			next1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (_position == Double.parseDouble(_REPLACE(pagenumber.getText().toString()))) {
						
					} else {
						viewpager1.setCurrentItem((int)_position + 1);
					}
				}
			});
			bookback.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (_position == 0) {
						
					} else {
						viewpager1.setCurrentItem((int)_position - 1);
					}
				}
			});
			booknext0.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (_position == Double.parseDouble(_REPLACE(pagenumber.getText().toString()))) {
						
					} else {
						viewpager1.setCurrentItem((int)_position + 1);
					}
				}
			});
			share.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					SketchwareUtil.showMessage(getApplicationContext(), heding.getText().toString().concat(" শেয়ার করা হয়েছে"));
					a = "এপ্সটি শেয়ার করুন";
					b = heding.getText().toString().concat("\n____________________\n".concat(textview1.getText().toString().concat("\n".concat(textview2.getText().toString().concat(copyshare)))));
					Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_SUBJECT, a); i.putExtra(android.content.Intent.EXTRA_TEXT, b); startActivity(Intent.createChooser(i,"লেখা গুলো শেয়ার করুন"));
				}
			});
			copy.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					SketchwareUtil.showMessage(getApplicationContext(), heding.getText().toString().concat(" কপি করা হয়েছে"));
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", heding.getText().toString().concat("\n".concat(textview1.getText().toString()))));
				}
			});
			high.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					textsize++;
					heding.setTextSize((int)textsize);
					textview1.setTextSize((int)textsize);
				}
			});
			low.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					textsize--;
					heding.setTextSize((int)textsize);
					textview1.setTextSize((int)textsize);
				}
			});
			textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
			pagenumber.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
			page.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/solaimanlipi.ttf"), 0);
			page.setText(_num(getIntent().getStringExtra("1")));
			pagenumber.setText(_num(" / ".concat(String.valueOf((long)(1 - map.size())))));
			pagenumberbox.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					renameDialog.setTitle("Go to page");
					LinearLayout layout = new LinearLayout(ReadingActivity.this);
					layout.setOrientation(LinearLayout.VERTICAL);
					
					LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT); 
					final EditText edittxt3 = new EditText(ReadingActivity.this);
					edittxt3.setHint("Enter page number");
					edittxt3.setInputType(InputType.TYPE_CLASS_NUMBER);
					edittxt3.setLayoutParams(lp);
					edittxt3.setElevation(6f);
					layout.addView(edittxt3);
					renameDialog.setView(layout);
					renameDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							SketchwareUtil.hideKeyboard(getApplicationContext());
						}
					});
					renameDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							newName = edittxt3.getText().toString();
							if (newName.equals("") || (Double.parseDouble(newName) > map.size())) {
								SketchwareUtil.showMessage(getApplicationContext(), "No page found");
								SketchwareUtil.hideKeyboard(getApplicationContext());
							} else {
								viewpager1.setCurrentItem((int)Double.parseDouble(newName));
								SketchwareUtil.hideKeyboard(getApplicationContext());
							}
						}
					});
					renameDialog.create().show();
				}
			});
			ViewPager viewPager = findViewById(R.id.viewpager1);
			
			viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
				@Override
				public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
					// Code for onPageScrolled event
				}
				
				@Override
				public void onPageSelected(int position) {
					page.setText(_num(String.valueOf((long)(_position))));
					pagenumber.setText(_num(" / ".concat(String.valueOf((long)(1 - map.size())))));
				}
				
				@Override
				public void onPageScrollStateChanged(int state) {
					// Code for onPageScrollStateChanged event
				}
			});
			_space(textview1);
			
			_container.addView(_view);
			return _view;
		}
	}
}