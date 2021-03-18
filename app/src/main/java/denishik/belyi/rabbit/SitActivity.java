package denishik.belyi.rabbit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Switch;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.speech.SpeechRecognizer;
import android.speech.RecognizerIntent;
import android.speech.RecognitionListener;
import android.speech.tts.TextToSpeech;
import java.util.Timer;
import java.util.TimerTask;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class SitActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	
	private HashMap<String, Object> ma0 = new HashMap<>();
	private double pass = 0;
	private String pas1 = "";
	
	private LinearLayout skelet;
	private LinearLayout top;
	private LinearLayout body;
	private LinearLayout toolbar;
	private ImageView imageview1;
	private LinearLayout xz;
	private ImageView logo_athor;
	private LinearLayout info_block;
	private LinearLayout sit_block;
	private LinearLayout wifioff_block;
	private LinearLayout noinet_block;
	private TextView text_norm;
	private LinearLayout file_block;
	private ImageView imageview4;
	private TextView textview1;
	private LinearLayout linear5;
	private Button wifi_but;
	private ImageView imageview5;
	private TextView textview2;
	private LinearLayout linear6;
	private Button inet_but;
	private ImageView file_pic;
	private TextView textview3;
	private LinearLayout linear8;
	private Button button1;
	private LinearLayout wifi_sit;
	private LinearLayout linear9;
	private ImageView imageview6;
	private Switch wifu_switch;
	private ImageView dev_photo;
	private Switch dev_switch;
	private ImageView help;
	private ImageView sitt;
	
	private Intent browser = new Intent();
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private SharedPreferences data;
	private SpeechRecognizer rech;
	private TextToSpeech reee;
	private TimerTask timer;
	private AlertDialog.Builder dialog1;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.sit);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECORD_AUDIO}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		skelet = (LinearLayout) findViewById(R.id.skelet);
		top = (LinearLayout) findViewById(R.id.top);
		body = (LinearLayout) findViewById(R.id.body);
		toolbar = (LinearLayout) findViewById(R.id.toolbar);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		xz = (LinearLayout) findViewById(R.id.xz);
		logo_athor = (ImageView) findViewById(R.id.logo_athor);
		info_block = (LinearLayout) findViewById(R.id.info_block);
		sit_block = (LinearLayout) findViewById(R.id.sit_block);
		wifioff_block = (LinearLayout) findViewById(R.id.wifioff_block);
		noinet_block = (LinearLayout) findViewById(R.id.noinet_block);
		text_norm = (TextView) findViewById(R.id.text_norm);
		file_block = (LinearLayout) findViewById(R.id.file_block);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		wifi_but = (Button) findViewById(R.id.wifi_but);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		inet_but = (Button) findViewById(R.id.inet_but);
		file_pic = (ImageView) findViewById(R.id.file_pic);
		textview3 = (TextView) findViewById(R.id.textview3);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		button1 = (Button) findViewById(R.id.button1);
		wifi_sit = (LinearLayout) findViewById(R.id.wifi_sit);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		wifu_switch = (Switch) findViewById(R.id.wifu_switch);
		dev_photo = (ImageView) findViewById(R.id.dev_photo);
		dev_switch = (Switch) findViewById(R.id.dev_switch);
		help = (ImageView) findViewById(R.id.help);
		sitt = (ImageView) findViewById(R.id.sitt);
		network = new RequestNetwork(this);
		data = getSharedPreferences("datas", Activity.MODE_PRIVATE);
		rech = SpeechRecognizer.createSpeechRecognizer(this);
		reee = new TextToSpeech(getApplicationContext(), null);
		dialog1 = new AlertDialog.Builder(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		logo_athor.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				browser.setAction(Intent.ACTION_VIEW);
				browser.setData(Uri.parse("http://vk.com/denis_hik"));
				startActivity(browser);
			}
		});
		
		wifi_but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		inet_but.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		dev_switch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		dev_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					if (Double.parseDouble(data.getString("Dev", "")) == 1) {
						
					}
					else {
						final AlertDialog dialog1 = new AlertDialog.Builder(SitActivity.this).create();
						View inflate = getLayoutInflater().inflate(R.layout.devdia,null); dialog1.setView(inflate);
						
						
						dialog1.setTitle ("Dev");
						
						final ImageView go = (ImageView) inflate.findViewById (R.id.go);
						final EditText pas1s = (EditText) inflate.findViewById (R.id.pass);
						
						
						go.setOnClickListener(new OnClickListener() { public void onClick(View view) { pas1 = pas1s.getText().toString();
								if (Double.parseDouble(pas1) == 3432) {
									data.edit().putString("Dev", "1").commit();
									dialog1.dismiss();
								}
								else {
									dev_switch.setChecked(false);
								}
							} });
						
						
						dialog1.show();
						
						
						
						dialog1.setCancelable(false);
					}
				}
				else {
					data.edit().putString("Dev", "0").commit();
				}
			}
		});
		
		help.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				info_block.setVisibility(View.VISIBLE);
				sit_block.setVisibility(View.GONE);
				info_block.setBackgroundColor(0xFF757575);
				sit_block.setBackgroundColor(Color.TRANSPARENT);
				help.setColorFilter(0xFF03A9F4, PorterDuff.Mode.MULTIPLY);
				sitt.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
			}
		});
		
		sitt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				info_block.setVisibility(View.GONE);
				sit_block.setVisibility(View.VISIBLE);
				info_block.setBackgroundColor(Color.TRANSPARENT);
				sit_block.setBackgroundColor(0xFF757575);
				sitt.setColorFilter(0xFF03A9F4, PorterDuff.Mode.MULTIPLY);
				help.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
			}
		});
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				noinet_block.setVisibility(View.VISIBLE);
				text_norm.setVisibility(View.GONE);
			}
		};
	}
	
	private void initializeLogic() {
		sit_block.setVisibility(View.GONE);
		info_block.setVisibility(View.GONE);
		wifioff_block.setVisibility(View.GONE);
		noinet_block.setVisibility(View.GONE);
		text_norm.setVisibility(View.VISIBLE);
		file_block.setVisibility(View.GONE);
		network.startRequestNetwork(RequestNetworkController.GET, "http://www.google.com", "A", _network_request_listener);
		if (data.getString("Dev", "").equals("1")) {
			dev_switch.setChecked(true);
		}
		else {
			dev_switch.setChecked(false);
		}
		_RadiusGradient4(toolbar, "#757575", "#757575", 25, 25, 0, 0, 0, "#757575");
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _RadiusGradient4 (final View _view, final String _color1, final String _color2, final double _lt, final double _rt, final double _rb, final double _lb, final double _border, final String _color3) {
		int[] colors = { Color.parseColor(_color1), Color.parseColor(_color2) }; android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, colors);
		gd.setCornerRadii(new float[]{(int)_lt,(int)_lt,(int)_rt,(int)_rt,(int)_rb,(int)_rb,(int)_lb,(int)_lb});
		gd.setStroke((int) _border, Color.parseColor(_color3));
		_view.setBackground(gd);
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