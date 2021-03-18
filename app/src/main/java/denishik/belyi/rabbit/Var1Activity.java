package denishik.belyi.rabbit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.util.*;
import android.webkit.*;

import java.util.*;

import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.EditText;
import android.app.Activity;
import android.content.SharedPreferences;
import android.animation.ObjectAnimator;

import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.webkit.WebViewClient;
import android.graphics.Typeface;


public class Var1Activity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	
	private String urlbr = "";
	private double f = 0;
	private double t = 0;
	
	private LinearLayout skelet;
	private LinearLayout top;
	private LinearLayout body;
	private LinearLayout toolbar;
	private ImageView imageview1;
	private TextView wifitext;
	private LinearLayout huyna;
	private TextView info;
	private ImageView logo;
	private WebView webview1;
	private EditText urledit;
	private ImageView go;
	
	private SharedPreferences data;
	private ObjectAnimator text = new ObjectAnimator();
	private TimerTask timer;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.var1);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		skelet = (LinearLayout) findViewById(R.id.skelet);
		top = (LinearLayout) findViewById(R.id.top);
		body = (LinearLayout) findViewById(R.id.body);
		toolbar = (LinearLayout) findViewById(R.id.toolbar);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		wifitext = (TextView) findViewById(R.id.wifitext);
		huyna = (LinearLayout) findViewById(R.id.huyna);
		info = (TextView) findViewById(R.id.info);
		logo = (ImageView) findViewById(R.id.logo);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		urledit = (EditText) findViewById(R.id.urledit);
		go = (ImageView) findViewById(R.id.go);
		data = getSharedPreferences("datas", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				toolbar.setVisibility(View.VISIBLE);
				webview1.loadUrl("http://youtube.com");
				webview1.zoomOut();
				webview1.zoomOut();
				webview1.zoomOut();
				webview1.getSettings().setDisplayZoomControls(false);
			}
		});
		
		wifitext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				urledit.setText("Loading.... ");
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				urledit.setText(_url);
				if (_url.contains("https://m.youtube.com/watch?v=") && !_url.contains("#dialog")) {
					toolbar.setVisibility(View.GONE);
					urlbr = _url.substring((int)("https://m.youtube.com/watch?v=".length()), (int)("https://m.youtube.com/watch?v=5J9ATcMmC0A".length()));
					MoreUtil.showMessage(getApplicationContext(), urlbr);
					webview1.loadUrl("data:text/html, <iframe width=\"100%\" height=\"100%\" src=\"http://www.youtube.com/embed/".concat(urlbr.concat("\" frameborder=\"1\"></iframe>")));
					webview1.zoomIn();
					webview1.zoomIn();
					webview1.zoomIn();
					webview1.getSettings().setBuiltInZoomControls(true);
				}else {
					
				}
				super.onPageFinished(_param1, _param2);
			}
		});
		
		go.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (urledit.getText().toString().contains("https://m.youtube.com/watch?v=")) {
					toolbar.setVisibility(View.GONE);
					urlbr = urledit.getText().toString().substring((int)("https://m.youtube.com/watch?v=".length()), (int)("https://m.youtube.com/watch?v=5J9ATcMmC0A".length()));
					MoreUtil.showMessage(getApplicationContext(), urlbr);
					webview1.loadUrl("data:text/html, <iframe width=\"100%\" height=\"100%\" src=\"http://www.youtube.com/embed/".concat(urlbr.concat("\" frameborder=\"1\"></iframe>")));
					webview1.zoomIn();
					webview1.zoomIn();
					webview1.zoomIn();
					webview1.getSettings().setBuiltInZoomControls(true);
				}else {
					urledit.setBackgroundColor(0xFFEF5350);
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									urledit.setBackgroundColor(0xFFFFCC80);
								}
							});
						}
					};
					_timer.schedule(timer, (int)(500));
				}
			}
		});
	}
	
	private void initializeLogic() {
		
getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

		wifitext.setText(data.getString("Wifi", ""));
		info.setText(data.getString("Info", ""));
		wifitext.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/text1.ttf"), 0);
		info.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/text3.ttf"), 0);
		webview1.setWebChromeClient(new CustomWebClient());
		webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		webview1.loadUrl("http://www.youtube.com");
	}
	
	public class CustomWebClient extends WebChromeClient {
		private View mCustomView;
		private WebChromeClient.CustomViewCallback mCustomViewCallback;
		protected FrameLayout frame;

		private int mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
		private int mOriginalSystemUiVisibility;

		public CustomWebClient() {}
		
		public Bitmap getDefaultVideoPoster() {
			if (Var1Activity.this == null) {
				return null; }
			return BitmapFactory.decodeResource(Var1Activity.this.getApplicationContext().getResources(), 2130837573); }
		
		public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback viewCallback) {
			if (this.mCustomView != null) {
				onHideCustomView();
				return; }
			this.mCustomView = paramView;
			this.mOriginalSystemUiVisibility = Var1Activity.this.getWindow().getDecorView().getSystemUiVisibility();
			// When CustomView is shown screen orientation changes to mOriginalOrientation (Landscape).
			Var1Activity.this.setRequestedOrientation(this.mOriginalOrientation);
			// After that mOriginalOrientation is set to portrait.
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
			this.mCustomViewCallback = viewCallback; ((FrameLayout)Var1Activity.this.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1)); Var1Activity.this.getWindow().getDecorView().setSystemUiVisibility(3846);
		}
		
		public void onHideCustomView() {
			((FrameLayout)Var1Activity.this.getWindow().getDecorView()).removeView(this.mCustomView);
			this.mCustomView = null;
			Var1Activity.this.getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
			Var1Activity.this.setRequestedOrientation(this.mOriginalOrientation);
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE; this.mCustomViewCallback.onCustomViewHidden();
			this.mCustomViewCallback = null;
		}
	}
	
	{
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);

		switch (_requestCode) {

			default:
			break;
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		finish();
	}
	public void _Toolbar (final boolean _v) {
		if (_v) {
			getSupportActionBar().show();
		}
		else {
			getSupportActionBar().hide();
		}
	}
	
	
	public void _time () {
		
	}
	
	
	public void _picj () {
		
	}
	
	
	public void _urlyou (final String _url) {
		urlbr = "";
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
