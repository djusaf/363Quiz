package com.military.quizthirtysixthree;
import com.military.quizthirtysixthree.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GradeActivity extends Activity {
    public String TAG;
    private int numberofQuestions;
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
                MainActivity.numberOfQuestions = 0;
                MainActivity.bolRandom = false;
                MainActivity.Chapter1 = false;
                MainActivity.Chapter2 = false;
                MainActivity.Chapter3 = false;
                MainActivity.Chapter4 = false;
                MainActivity.Chapter5 = false;
                MainActivity.Chapter6 = false;
                MainActivity.Chapter7 = false;
                MainActivity.Chapter8 = false;
                MainActivity.Chapter9 = false;
                MainActivity.Chapter10 = false;
                MainActivity.Chapter11 = false;

		        Intent intent = new Intent(GradeActivity.this, Quiz_Choice.class);
		        startActivity(intent);
		    }
		});
		//get score

		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
        int score2 = ((int)score * 100)/ MainActivity.numberOfQuestions;
		//display score
		t.setText("You answered " +(score) +" of " + MainActivity.numberOfQuestions + " questions correctly and scored:");
		t1.setText(String.valueOf(score2) + "%");
			    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}
}
