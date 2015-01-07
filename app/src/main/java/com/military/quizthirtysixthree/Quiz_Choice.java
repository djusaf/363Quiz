package com.military.quizthirtysixthree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Quiz_Choice extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__choice);

        Button butRandom = (Button) findViewById(R.id.btn_random_exam);
        butRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.bolRandom = true;
                MainActivity.numberOfQuestions = 20;
                startActivity(intent);
            }
        });

        Button butChapter1 = (Button) findViewById(R.id.btn_chapter_one_exam);
        butChapter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter1 = true;
                MainActivity.numberOfQuestions = 4;
                startActivity(intent);
            }
        });

        Button butChapter2 = (Button) findViewById(R.id.btn_chapter_two_exam);
        butChapter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter2 = true;
                MainActivity.numberOfQuestions = 20;
                startActivity(intent);
            }
        });

        Button butChapter3 = (Button) findViewById(R.id.btn_chapter_three_exam);
        butChapter3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter3 = true;
                MainActivity.numberOfQuestions = 20;
                startActivity(intent);
            }
        });

        Button butChapter4 = (Button) findViewById(R.id.btn_chapter_four_exam);
        butChapter4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter4 = true;
                MainActivity.numberOfQuestions = 20;
                startActivity(intent);
            }
        });

        Button butChapter5 = (Button) findViewById(R.id.btn_chapter_five_exam);
        butChapter5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter5 = true;
                MainActivity.numberOfQuestions = 20;
                startActivity(intent);
            }
        });

        Button butChapter6 = (Button) findViewById(R.id.btn_chapter_six_exam);
        butChapter6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter6 = true;
                MainActivity.numberOfQuestions = 8;
                startActivity(intent);
            }
        });

        Button butChapter7 = (Button) findViewById(R.id.btn_chapter_seven_exam);
        butChapter7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter7 = true;
                MainActivity.numberOfQuestions = 15;
                startActivity(intent);
            }
        });

        Button butChapter8 = (Button) findViewById(R.id.btn_chapter_eight_exam);
        butChapter8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter8 = true;
                MainActivity.numberOfQuestions = 12;
                startActivity(intent);
            }
        });

        Button butChapter9 = (Button) findViewById(R.id.btn_chapter_nine_exam);
        butChapter9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter9 = true;
                MainActivity.numberOfQuestions = 11;
                startActivity(intent);
            }
        });

        Button butChapter10 = (Button) findViewById(R.id.btn_chapter_ten_exam);
        butChapter10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter10 = true;
                MainActivity.numberOfQuestions = 4;
                startActivity(intent);
            }
        });

        Button butChapter11 = (Button) findViewById(R.id.btn_chapter_eleven_exam);
        butChapter11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz_Choice.this, MainActivity.class);
                MainActivity.Chapter11 = true;
                MainActivity.numberOfQuestions = 4;
                startActivity(intent);
            }
        });
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
}
