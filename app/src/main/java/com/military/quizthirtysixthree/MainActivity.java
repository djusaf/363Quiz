/*
 * Copyright (C) 2013 The Android Open Source Project 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package com.military.quizthirtysixthree;

import java.util.List;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

/**
 * Creates UI and contains all information for each iteration of the exam
 */

public class MainActivity extends Activity {

    private List<Question> quesList;
    private List<Question> Chapter1List;
    private List<Question> Chapter2List;
    private List<Question> Chapter3List;
    private List<Question> Chapter4List;
    private List<Question> Chapter5List;
    private List<Question> Chapter6List;
    private List<Question> Chapter7List;
    private List<Question> Chapter8List;
    private List<Question> Chapter9List;
    private List<Question> Chapter10List;
    private List<Question> Chapter11List;
    private List<Question> Chapter12List;

	public int score=0;
    private int qid=0;
	private Question currentQ;
    private TextView txtQNumber;
	private TextView txtQuestion;
    private TextView txtReference;
    private RadioButton rda;
    private RadioButton rdb;
    private RadioButton rdc;
    private RadioButton rdd;
    public static boolean bolRandom = false;
    public static boolean Chapter1 = false;
    public static boolean Chapter2 = false;
    public static boolean Chapter3 = false;
    public static boolean Chapter4 = false;
    public static boolean Chapter5 = false;
    public static boolean Chapter6 = false;
    public static boolean Chapter7 = false;
    public static boolean Chapter8 = false;
    public static boolean Chapter9 = false;
    public static boolean Chapter10 = false;
    public static boolean Chapter11 = false;
    public static boolean Chapter12 = false;
    public static boolean Chapter13 = false;
    public static boolean Chapter14 = false;
    public static boolean Chapter15 = false;
    public static boolean Chapter16 = false;
    public static boolean Chapter17 = false;
    public static int numberOfQuestions;
    private final SplashScreen test = new SplashScreen();
    /**
     *
     */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
        DbHelper db=new DbHelper(this);

        if (bolRandom) {
            quesList=db.getAllQuestions();
            currentQ = quesList.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Random Test");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter1){
            Chapter1List=db.getChapterOneQuestions();
            currentQ = Chapter1List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter1");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter2){
            Chapter2List=db.getChapterTwoQuestions();
            currentQ = Chapter2List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter2");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter3){
            Chapter3List=db.getChapterThreeQuestions();
            currentQ = Chapter3List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter3");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter4) {
            Chapter4List = db.getChapterFourQuestions();
            currentQ = Chapter4List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter4");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter5) {
            Chapter5List = db.getChapterFiveQuestions();
            currentQ = Chapter5List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter5");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter6) {
            Chapter6List = db.getChapterSixQuestions();
            currentQ = Chapter6List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter6");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter7) {
            Chapter7List = db.getChapterSevenQuestions();
            currentQ = Chapter7List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter7");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter8) {
            Chapter8List = db.getChapterEightQuestions();
            currentQ = Chapter8List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter8");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter9) {
            Chapter9List = db.getChapterNineQuestions();
            currentQ = Chapter9List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter9");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter10) {
            Chapter10List = db.getChapterTenQuestions();
            currentQ = Chapter10List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter10");
            t.send(new HitBuilders.AppViewBuilder().build());
        }else if (Chapter11) {
            Chapter11List = db.getChapterElevenQuestions();
            currentQ = Chapter11List.get(qid);
            Tracker t = test.getTracker();
            t.setScreenName("Chapter11");
            t.send(new HitBuilders.AppViewBuilder().build());
        }

		//currentQ=quesList.get(qid);
        txtQNumber=(TextView)findViewById(R.id.txtQNumber);
		txtQuestion=(TextView)findViewById(R.id.textView1);
		txtReference=(TextView)findViewById(R.id.textViewReference);
		rda=(RadioButton)findViewById(R.id.radio0);
		rdb=(RadioButton)findViewById(R.id.radio1);
		rdc=(RadioButton)findViewById(R.id.radio2);
		rdd=(RadioButton)findViewById(R.id.radio3);

        Button butNext = (Button) findViewById(R.id.button1);
		setQuestionView();
		butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
                if (currentQ.getANSWER().equals(answer.getText())) {
                    openRightAnswer(v);
                    score++;
                } else {
                    openWrongAnswer(v);

                }

            }
        });
	}

    /**
     * Checks is question id is equal to max number of questions and loads information
     * for review
     */
    private void checkFinish() {
        if (qid < numberOfQuestions) {
            if (bolRandom) {
                currentQ = quesList.get(qid);
            }else if (Chapter1) {
                currentQ = Chapter1List.get(qid);
            }else if (Chapter2) {
                currentQ = Chapter2List.get(qid);
            }else if (Chapter3) {
                currentQ = Chapter3List.get(qid);
            }else if (Chapter4){
                currentQ = Chapter4List.get(qid);
            }else if (Chapter5){
                currentQ = Chapter5List.get(qid);
            }else if (Chapter6){
                currentQ = Chapter6List.get(qid);
            }else if (Chapter7){
                currentQ = Chapter7List.get(qid);
            }else if (Chapter8){
                currentQ = Chapter8List.get(qid);
            }else if (Chapter9){
                currentQ = Chapter9List.get(qid);
            }else if (Chapter10){
                currentQ = Chapter10List.get(qid);
            }else if (Chapter11){
                currentQ = Chapter11List.get(qid);
            }
            setQuestionView();
        } else {
            Intent intent = new Intent(MainActivity.this, GradeActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }

    }

    /**
     * Displays user message for correct answers
     */
    @SuppressWarnings("UnusedParameters")
    private void openRightAnswer(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Answer");
        alertDialogBuilder.setMessage("Correct!");
        // set negative button: No message
        alertDialogBuilder.setNegativeButton("Continue",new DialogInterface.OnClickListener() {
        	                public void onClick(DialogInterface dialog,int id) {
                                checkFinish();
        // cancel the alert box
        dialog.cancel();
        }
                   });

        AlertDialog alertDialog = alertDialogBuilder.create();
        // show alert
        alertDialog.show();
        alertDialog.getWindow().getAttributes();
        TextView msgTxt = (TextView) alertDialog.findViewById(android.R.id.message);
        msgTxt.setTextSize(30);
        msgTxt.setGravity(Gravity.CENTER_HORIZONTAL);
            }

    /**
     * Displays user message for correct answers
     */
    @SuppressWarnings("UnusedParameters")
    private void openWrongAnswer(@SuppressWarnings("UnusedParameters") View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("INCORRECT ANSWER");
        alertDialogBuilder.setMessage("The correct answer is: \n" + currentQ.getANSWER() + "\n Ref: " + currentQ.getREFERENCE());
        // set negative button: No message
        alertDialogBuilder.setNegativeButton("Continue" ,new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                checkFinish();
                // cancel the alert box and put a Toast to the user
                dialog.cancel();
            }
        });
        alertDialogBuilder.setPositiveButton("Challenge Answer" ,new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                submitBug();
                // Add information to Review List for display after completion of test


                // cancel the alert box and put a Toast to the user
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        // show alert
        alertDialog.show();
        alertDialog.getWindow().getAttributes();
        TextView msgTxt = (TextView) alertDialog.findViewById(android.R.id.message);
        msgTxt.setTextSize(20);
        msgTxt.setGravity(Gravity.CENTER_HORIZONTAL);
    }

    /**
     *
     */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quiz, menu);

		return true;
	}

    /**
     * Displays menu to change settings and report issues
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_bug_report:
                submitBug();
                return true;
            case R.id.menu_settings:
                //showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Sets information from list to the UI
     */
	private void setQuestionView()
	{
        txtQNumber.setText(qid + 1 + "/" + numberOfQuestions);
		txtQuestion.setText(currentQ.getQUESTION());
		txtReference.setText(currentQ.getREFERENCE());
		rda.setText(currentQ.getOPTA());
		rdb.setText(currentQ.getOPTB());
		rdc.setText(currentQ.getOPTC());
		rdd.setText(currentQ.getOPTD());
		qid++;
	}

    /**
     * Opens email program to report bug to developers
     */
    void submitBug() {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "bryan.walsh.mti@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "36-3 Bug Report");
        intent.putExtra(Intent.EXTRA_TEXT, "The following question is incorrect: \n\n" + "Question Number: " + currentQ.getID() + "\n\n" + currentQ.getQUESTION() + "\n\n" + "Choice A:  "+ currentQ.getOPTA() + "\n\n" + "Choice B:  "+ currentQ.getOPTB() + "\n\n" + "Choice C:  " + currentQ.getOPTC() + "\n\n" + "Choice D:  " + currentQ.getOPTD() + "\n\n Additional Information: \n");
        startActivity(Intent.createChooser(intent, ""));


    }


}
