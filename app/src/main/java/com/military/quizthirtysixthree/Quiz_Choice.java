package com.military.quizthirtysixthree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Quiz_Choice extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__choice);

        Button buttonR = (Button) findViewById(R.id.btn_random_exam);
        Button button1 = (Button) findViewById(R.id.btn_chapter_one_exam);
        Button button2 = (Button) findViewById(R.id.btn_chapter_two_exam);
        Button button3 = (Button) findViewById(R.id.btn_chapter_three_exam);
        Button button4 = (Button) findViewById(R.id.btn_chapter_four_exam);
        Button button5 = (Button) findViewById(R.id.btn_chapter_five_exam);
        Button button6 = (Button) findViewById(R.id.btn_chapter_six_exam);
        Button button7 = (Button) findViewById(R.id.btn_chapter_seven_exam);
        Button button8 = (Button) findViewById(R.id.btn_chapter_eight_exam);
        Button button9 = (Button) findViewById(R.id.btn_chapter_nine_exam);
        Button button10 = (Button) findViewById(R.id.btn_chapter_ten_exam);
        Button button11 = (Button) findViewById(R.id.btn_chapter_eleven_exam);


        buttonR.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_random_exam:
                MainActivity.bolRandom = true;
                MainActivity.numberOfQuestions = 20;
                break;
            case R.id.btn_chapter_one_exam:
                MainActivity.Chapter1 = true;
                MainActivity.numberOfQuestions = 4;
                break;
            case R.id.btn_chapter_two_exam:
                MainActivity.Chapter2 = true;
                MainActivity.numberOfQuestions = 20;
                break;
            case R.id.btn_chapter_three_exam:
                MainActivity.Chapter3 = true;
                MainActivity.numberOfQuestions = 20;
                break;
            case R.id.btn_chapter_four_exam:
                MainActivity.Chapter4 = true;
                MainActivity.numberOfQuestions = 20;
                break;
            case R.id.btn_chapter_five_exam:
                MainActivity.Chapter5 = true;
                MainActivity.numberOfQuestions = 20;
                break;
            case R.id.btn_chapter_six_exam:
                MainActivity.Chapter6 = true;
                MainActivity.numberOfQuestions = 8;
                break;
            case R.id.btn_chapter_seven_exam:
                MainActivity.Chapter7 = true;
                MainActivity.numberOfQuestions = 15;
                break;
            case R.id.btn_chapter_eight_exam:
                MainActivity.Chapter8 = true;
                MainActivity.numberOfQuestions = 12;
                break;
            case R.id.btn_chapter_nine_exam:
                MainActivity.Chapter9 = true;
                MainActivity.numberOfQuestions = 11;
                break;
            case R.id.btn_chapter_ten_exam:
                MainActivity.Chapter10 = true;
                MainActivity.numberOfQuestions = 4;
                break;
            case R.id.btn_chapter_eleven_exam:
                MainActivity.Chapter11 = true;
                MainActivity.numberOfQuestions = 4;
                break;

        }
        Intent mainIntent = new Intent(Quiz_Choice.this, MainActivity.class);
        Quiz_Choice.this.startActivity(mainIntent);
        Quiz_Choice.this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz__choice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(Quiz_Choice.this, ChoiceActivity.class));
        finish();

    }
}
