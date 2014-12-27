package com.military.quizthirtysixthree;
import com.military.quizthirtysixthree.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class GradeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
		TextView t1=(TextView)findViewById(R.id.textView1);
		
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        Intent intent = new Intent(GradeActivity.this, MainActivity.class);
		        startActivity(intent);
		    }
		});
		//get score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		int score2 = score * 5;
		//display score
		t.setText("You answered " +(score) +" of 20 questions correctly and scored:");
		t1.setText(String.valueOf(score2) + "%");
			    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}
}
