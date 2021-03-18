package denishik.belyi.rabbit;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.os.*;
import android.widget.*;
import android.graphics.*;
import android.util.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Switch;
import android.content.Intent;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.ClipData;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;

import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class MainActivity extends  AppCompatActivity  { 
	
	public final int REQ_CD_FILESPICK = 101;
	
	private FloatingActionButton _fab;
	private boolean athor = false;
	private double pic = 0;
	private String nomberpic = "";
	
	private ArrayList<String> pickers = new ArrayList<>();
	
	private LinearLayout skelet;
	private LinearLayout meh;
	private LinearLayout buttons;
	private LinearLayout photosinput;
	private LinearLayout edittexts;
	private ImageView sit_pic;
	private LinearLayout linear2;
	private ImageView imageview2;
	private ImageView imageview1;
	private ImageView photoinput1;
	private ImageView photoinput2;
	private ImageView photoinput3;
	private LinearLayout wifipasstext;
	private LinearLayout savephoto_block;
	private LinearLayout infotext;
	private LinearLayout autosave_block;
	private TextView wifipasstextt;
	private EditText inputwifi;
	private CheckBox checkbox1;
	private TextView textview1;
	private EditText inputinfo;
	private Switch autosave_sweetch;
	private TextView autosave_text;
	
	private Intent var1 = new Intent();
	private SharedPreferences data;
	private Intent filespick = new Intent(Intent.ACTION_GET_CONTENT);
	private AlertDialog.Builder dia;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		}else {
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
		
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		skelet = (LinearLayout) findViewById(R.id.skelet);
		meh = (LinearLayout) findViewById(R.id.meh);
		buttons = (LinearLayout) findViewById(R.id.buttons);
		photosinput = (LinearLayout) findViewById(R.id.photosinput);
		edittexts = (LinearLayout) findViewById(R.id.edittexts);
		sit_pic = (ImageView) findViewById(R.id.sit_pic);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		photoinput1 = (ImageView) findViewById(R.id.photoinput1);
		photoinput2 = (ImageView) findViewById(R.id.photoinput2);
		photoinput3 = (ImageView) findViewById(R.id.photoinput3);
		wifipasstext = (LinearLayout) findViewById(R.id.wifipasstext);
		savephoto_block = (LinearLayout) findViewById(R.id.savephoto_block);
		infotext = (LinearLayout) findViewById(R.id.infotext);
		autosave_block = (LinearLayout) findViewById(R.id.autosave_block);
		wifipasstextt = (TextView) findViewById(R.id.wifipasstextt);
		inputwifi = (EditText) findViewById(R.id.inputwifi);
		checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
		textview1 = (TextView) findViewById(R.id.textview1);
		inputinfo = (EditText) findViewById(R.id.inputinfo);
		autosave_sweetch = (Switch) findViewById(R.id.autosave_sweetch);
		autosave_text = (TextView) findViewById(R.id.autosave_text);
		data = getSharedPreferences("datas", Activity.MODE_PRIVATE);
		filespick.setType("image/*");
		filespick.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		dia = new AlertDialog.Builder(this);
		
		sit_pic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				var1.setClass(getApplicationContext(), SitActivity.class);
				startActivity(var1);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				MoreUtil.showMessage(getApplicationContext(), "В разработке");
				photosinput.setVisibility(View.VISIBLE);
				edittexts.setVisibility(View.VISIBLE);
				_fab.setVisibility(View.GONE); 
				infotext.setVisibility(View.INVISIBLE);
				autosave_block.setVisibility(View.INVISIBLE);
				savephoto_block.setVisibility(View.VISIBLE);
				if (data.getString("Sph", "").equals("1")) {
					var1.setClass(getApplicationContext(), Var2Activity.class);
					dia.setMessage("Запустить с прошедшими фотками? ");
					dia.setPositiveButton("Продолжить", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							startActivity(var1);
						}
					});
					dia.create().show();
				}
				else {
					
				}
				imageview2.setBackgroundColor(0xFFFFB74D);
				imageview1.setBackgroundColor(Color.TRANSPARENT);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittexts.setVisibility(View.VISIBLE);
				infotext.setVisibility(View.VISIBLE);
				autosave_block.setVisibility(View.VISIBLE);
				photosinput.setVisibility(View.GONE);
				savephoto_block.setVisibility(View.GONE);
				imageview1.setBackgroundColor(0xFFFFB74D);
				imageview2.setBackgroundColor(Color.TRANSPARENT);
			}
		});
		
		photoinput1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(filespick, REQ_CD_FILESPICK);
				pic = 1;
			}
		});
		
		photoinput2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(filespick, REQ_CD_FILESPICK);
				pic = 2;
			}
		});
		
		photoinput3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(filespick, REQ_CD_FILESPICK);
				pic = 3;
			}
		});
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					data.edit().putString("Sph", "1").commit();
				}
				else {
					data.edit().putString("Sph", "0").commit();
				}
			}
		});
		
		inputinfo.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (inputinfo.getText().toString().equals("")) {
					_fab.setVisibility(View.GONE);
				}
				else {
					final ObjectAnimator animator = ObjectAnimator.ofInt(_fab, "backgroundTint", Color.rgb(0, 121, 107), Color.rgb(226, 143, 34));
					animator.setDuration(2000L);
					animator.setEvaluator(new ArgbEvaluator());
					animator.setInterpolator(new DecelerateInterpolator(2));
					animator.addUpdateListener(new ObjectAnimator.AnimatorUpdateListener() {
						    @Override
						    public void onAnimationUpdate(ValueAnimator animation) {
							        int animatedValue = (int) animation.getAnimatedValue();
							        _fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(animatedValue));
							    }
					});
					animator.start();
					autosave_block.setVisibility(View.VISIBLE);
					_fab.setVisibility(View.VISIBLE);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		autosave_sweetch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					data.edit().putString("Save", "T").commit();
				}else {
					data.edit().putString("Save", "F").commit();
				}
			}
		});
		
		autosave_text.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				data.edit().putString("Wifi", inputwifi.getText().toString()).commit();
				data.edit().putString("Info", inputinfo.getText().toString()).commit();
				var1.setClass(getApplicationContext(), Var1Activity.class);
				startActivity(var1);
			}
		});
	}
	
	private void initializeLogic() {
		_fab.setVisibility(View.GONE); 
		edittexts.setVisibility(View.GONE);
		photosinput.setVisibility(View.GONE);
		if (data.getString("Save", "").equals("T") && (!data.getString("Info", "").equals("") && !data.getString("Wifi", "").equals(""))) {
			inputwifi.setText(data.getString("Wifi", ""));
			inputinfo.setText(data.getString("Info", ""));
			_fab.setVisibility(View.VISIBLE); 
		}
		var1.setClass(getApplicationContext(), AthorActivity.class);
		startActivity(var1);
		if (data.getString("Sph", "").equals("1")) {
			checkbox1.setChecked(true);
		}
		else {
			checkbox1.setChecked(false);
		}
		_RadiusGradient4(linear2, "#ffcc80", "#ffcc80", 20, 20, 0, 0, 0, "#ffcc80");
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FILESPICK:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				_pict(pic, _filePath);
			}else {
				
			}
			break;
			default:
			break;
		}
	}
	
	public void _pict (final double _nom, final ArrayList<String> _files) {
		data.edit().putString("Pic".concat(String.valueOf((long)(_nom))), _files.get((int)(0))).commit();
		nomberpic = "Pic".concat(String.valueOf((long)(_nom)));
		if (nomberpic.equals("Pic1")) {
			photoinput1.setImageResource(R.drawable.ic_check_circle_white);
		}
		if (nomberpic.equals("Pic2")) {
			photoinput2.setImageResource(R.drawable.ic_check_circle_white);
		}
		if (nomberpic.equals("Pic3")) {
			photoinput3.setImageResource(R.drawable.ic_check_circle_white);
			var1.setClass(getApplicationContext(), Var2Activity.class);
			startActivity(var1);
			photoinput1.setImageResource(R.drawable.ic_add_circle_outline_white);
			photoinput2.setImageResource(R.drawable.ic_add_circle_outline_white);
			photoinput3.setImageResource(R.drawable.ic_add_circle_outline_white);
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
