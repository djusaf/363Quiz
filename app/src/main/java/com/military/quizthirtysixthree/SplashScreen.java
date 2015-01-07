package com.military.quizthirtysixthree;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import java.util.HashMap;


public class SplashScreen extends Activity {

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.splash_screen);
        Button btnStart = (Button) findViewById(R.id.button);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
	}
    // The following line should be changed to include the correct property id.
    private static final String PROPERTY_ID = "UA-58183323-1";

    public enum TrackerName {
        APP_TRACKER, // Tracker used only in this app.
    }

    private final HashMap<TrackerName, Tracker> mTrackers = new HashMap<TrackerName, Tracker>();

    synchronized Tracker getTracker() {
        if (!mTrackers.containsKey(TrackerName.APP_TRACKER)) {

            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            Tracker t = analytics.newTracker(R.xml.app_tracker);
            mTrackers.put(TrackerName.APP_TRACKER, t);

        }
        return mTrackers.get(TrackerName.APP_TRACKER);
    }

    public void onStart() {
        super.onStart();
        //Get an Analytics tracker to report app starts and uncaught exceptions etc.
        //GoogleAnalytics.getInstance(this).reportActivityStart(this);
        GoogleAnalytics.getInstance(this).newTracker(PROPERTY_ID).setScreenName("EXAM");

    }

    public void onStop(){
        //Get an Analytics tracker to report app starts and uncaught exceptions etc.
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
        super.onStop();

    }
    void startQuiz(){

        //Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
        Intent mainIntent = new Intent(SplashScreen.this, Quiz_Choice.class);
        SplashScreen.this.startActivity(mainIntent);
        SplashScreen.this.finish();
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

}
