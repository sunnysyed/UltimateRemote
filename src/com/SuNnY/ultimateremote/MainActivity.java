package com.SuNnY.ultimateremote;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.SuNnY.ultimateremote.obj.GridChannel;
import com.SuNnY.ultimateremote.obj.GridScheduleResult;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends Activity implements OnClickListener {

	private ProgressDialog dialog;
	GridChannel[] gcs;
	LinearLayout guidebox;
	LayoutInflater inflater;
	int count = 20;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		 guidebox = (LinearLayout) findViewById(R.id.guide_box);
		 inflater = (LayoutInflater) getApplicationContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Ir.irInit(getApplicationContext()); 
		if (JSONSharedPreferences.check(getApplicationContext(), "epg", "epg")){
			try {
				Gson gson = new Gson();
				JSONObject arg1 = JSONSharedPreferences.loadJSONObject(getApplicationContext(), "epg", "epg");
				GridScheduleResult c = gson.fromJson(arg1.getString("GridScheduleResult"), GridScheduleResult.class);
				gcs = c.getGridChannels();
				
				for (count = 20; count < 30; count++){
					GridChannel gc = gcs[count];
					add(gc);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			loadEPG(this);
		}
		Ir.irInit(getApplicationContext());
	}
	private void loadEPG(Context c) {
		RequestParams rp = new RequestParams();
		rp.put("locale", "en-US");
		rp.put("duration", "30");
		rp.put("includechannelimages", "false");
		rp.put("format", "json");
		rp.put("apikey", "");
		final TextView tv = (TextView)findViewById(R.id.tv);
		EpgConnecter.get("gridschedule/63880/info", rp, new JsonHttpResponseHandler(){

			@Override
			protected void handleFailureMessage(Throwable arg0, String arg1) {

				Log.d("LOG", "handleFailureMessage: " + arg1);
				dialog.dismiss();
			}

			@Override
			public void onSuccess(int arg0, JSONArray arg1) {
				Log.d("LOG", "onSuccess JSONArray: " + arg1.toString());
				dialog.dismiss();

			}

			@Override
			public void onSuccess(int arg0, JSONObject arg1) {
				//Log.d("LOG", "onSuccess JSONObject: " + arg1.toString());
				JSONSharedPreferences.saveJSONObject(getApplicationContext(), "epg", "epg", arg1);
				Gson gson = new Gson();
				GridScheduleResult c;
				try {
					c = gson.fromJson(arg1.getString("GridScheduleResult"), GridScheduleResult.class);
					tv.setText("BLAH");
					gcs = c.getGridChannels();
					
					for (count = 20; count < 30; count++){
						GridChannel gc = gcs[count];
						add(gc);
					}
				} catch (JsonSyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dialog.dismiss();

			}

			@Override
			public void onSuccess(JSONArray arg0) {
				Log.d("LOG", "onSuccess : " + arg0.toString());
				dialog.dismiss();

			}

			@Override
			public void onSuccess(JSONObject arg0) {
				Log.d("LOG", "onSuccess: " + arg0.toString());
				dialog.dismiss();

			}
			
		});
		dialog = ProgressDialog.show(this, "", "Loading. Please wait...",
				true);
		
	}
	public void showNext(View v){
		int max = count + 100;
		while (max != count){
			GridChannel gc = gcs[count];
			count++;
			add(gc);
		}
	}
	public void showPrevious(View v){
		int min = count - 100;
		while (min != count){
			GridChannel gc = gcs[count];
			count--;
			add(gc);
		}
	}
	public void reload(View v){
		guidebox.removeAllViews();
		loadEPG(getApplicationContext());
	}
	public void add(GridChannel gc){
		View channelrow = inflater.inflate(R.layout.channel_row, guidebox,
				false);
		TextView channelname = (TextView) channelrow
				.findViewById(R.id.channel_name);
		channelname.setText(gc.getDisplayName());
		TextView channelnumber = (TextView) channelrow
				.findViewById(R.id.channel_number);
		channelnumber.setText(gc.getChannel());
		TextView show = (TextView) channelrow
				.findViewById(R.id.show);
		show.setText(gc.getAirings()[0].getTitle());
		channelrow.setTag(gc.getChannel().toString());
		channelrow.setOnClickListener(this);
		guidebox.addView(channelrow);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onClick(View arg0) {
		Log.d("LOG", arg0.getTag().toString());
		String key = arg0.getTag().toString();
		for (char c : key.toCharArray()){
			Ir.irSend(""+c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
