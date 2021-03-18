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
import android.widget.LinearLayout;
import android.widget.ImageView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.*;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener;
import android.widget.TextView;
import android.widget.EditText;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class Var2Activity extends  AppCompatActivity  { 
	
	
	private String str = "";
	private boolean pixc1 = false;
	
	private LinearLayout sketet;
	private LinearLayout videos_block;
	private LinearLayout linear2;
	private LinearLayout picture;
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView imageview4;
	private LinearLayout linear1;
	private ImageView live_logo;
	private YouTubePlayerView youtube5;
	private LinearLayout wifi_vlock;
	private LinearLayout dev_block;
	private ImageView pic1;
	private ImageView pic2;
	private ImageView pic3;
	private LinearLayout socinfa_preblock;
	private ImageView wifi_ico;
	private TextView wifi_text;
	private EditText dev_url;
	private ImageView dev_ya;
	private ImageView imageview5;
	private ImageView logo;
	private LinearLayout socinfa_block;
	private TextView textview1;
	private TextView textview2;
	
	private SharedPreferences data;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.var2);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
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
		
		sketet = (LinearLayout) findViewById(R.id.sketet);
		videos_block = (LinearLayout) findViewById(R.id.videos_block);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		picture = (LinearLayout) findViewById(R.id.picture);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		live_logo = (ImageView) findViewById(R.id.live_logo);
		youtube5 = (YouTubePlayerView) findViewById(R.id.youtube5);
		wifi_vlock = (LinearLayout) findViewById(R.id.wifi_vlock);
		dev_block = (LinearLayout) findViewById(R.id.dev_block);
		pic1 = (ImageView) findViewById(R.id.pic1);
		pic2 = (ImageView) findViewById(R.id.pic2);
		pic3 = (ImageView) findViewById(R.id.pic3);
		socinfa_preblock = (LinearLayout) findViewById(R.id.socinfa_preblock);
		wifi_ico = (ImageView) findViewById(R.id.wifi_ico);
		wifi_text = (TextView) findViewById(R.id.wifi_text);
		dev_url = (EditText) findViewById(R.id.dev_url);
		dev_ya = (ImageView) findViewById(R.id.dev_ya);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		logo = (ImageView) findViewById(R.id.logo);
		socinfa_block = (LinearLayout) findViewById(R.id.socinfa_block);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		data = getSharedPreferences("datas", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				youtube5.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
					  @Override
					  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
						    String videoId = "DSGyEsJ17cI";
						    youTubePlayer.cueVideo(videoId, 0);
						    getLifecycle().addObserver(youtube5);
						  }
				});
				if (false) {
					_url2("https://youtu.be/DSGyEsJ17cI");
				}
				_toatCustom("Jass load");
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				youtube5.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
					  @Override
					  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
						    String videoId = "hHW1oY26kxQ";
						    youTubePlayer.cueVideo(videoId, 0);
						    getLifecycle().addObserver(youtube5);
						  }
				});
				if (false) {
					_url2("https://youtu.be/hHW1oY26kxQ");
				}
				_toatCustom("music load");
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				youtube5.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
					  @Override
					  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
						    String videoId = "x3NjeoGeckQ";
						    youTubePlayer.cueVideo(videoId, 0);
						    getLifecycle().addObserver(youtube5);
						  }
				});
				if (false) {
					_url2("https://youtu.be/x3NjeoGeckQ");
				}
				_toatCustom("video load");
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				youtube5.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
					  @Override
					  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
						    String videoId = "2apI2qioFv0";
						    youTubePlayer.cueVideo(videoId, 0);
						    getLifecycle().addObserver(youtube5);
						  }
				});
				if (false) {
					_url2("https://youtu.be/2apI2qioFv0");
				}
				_toatCustom("cat load");
			}
		});
		
		youtube5.setOnLongClickListener(new View.OnLongClickListener() {
			 @Override
				public boolean onLongClick(View _view) {
				
				return true;
				}
			 });
		
		pic1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		wifi_ico.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				videos_block.setVisibility(View.VISIBLE);
			}
		});
		
		dev_ya.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				videos_block.setVisibility(View.GONE);
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				videos_block.setVisibility(View.GONE);
				
			}
		});
	}
	
	private void initializeLogic() {
		pic1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(data.getString("Pic1", ""), 1024, 1024));
		pic2.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(data.getString("Pic2", ""), 1024, 1024));
		pic3.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(data.getString("Pic3", ""), 1024, 1024));
		wifi_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/text3.ttf"), 0);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/text3.ttf"), 0);
		wifi_text.setText(data.getString("Wifi", ""));
		if (data.getString("Dev", "").equals("1")) {
			dev_block.setVisibility(View.VISIBLE);
		}
		else {
			dev_block.setVisibility(View.GONE);
		}
		youtube5.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
			  @Override
			  public void onReady(@NonNull YouTubePlayer youTubePlayer) {
				    String videoId = "DSGyEsJ17cI";
				    youTubePlayer.cueVideo(videoId, 0);
				    getLifecycle().addObserver(youtube5);
				  }
		});
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _url2 (final String _url) {
		videos_block.setVisibility(View.GONE);
		
	}
	
	
	public void _toatCustom (final String _text) {
		LayoutInflater toastPLT = getLayoutInflater(); 
		View toastPVT = toastPLT.inflate(R.layout.toast_view, null);
		final TextView text = (TextView)
		toastPVT.findViewById(R.id.text);
		text.setText(_text);
		Toast toastPT = Toast.makeText(getApplicationContext(),"",100);
		toastPT.setView(toastPVT);
		toastPT.show();
		videos_block.setVisibility(View.GONE);
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