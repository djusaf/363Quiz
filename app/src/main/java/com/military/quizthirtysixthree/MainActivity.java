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
import android.widget.Toast;

/**
 * Creates UI and contains all information for each iteration of the exam
 */

public class MainActivity extends Activity {
	private List<Question> quesList;
	private int score=0;
	private int qid=0;
	private Question currentQ;
    private TextView txtQNumber;
	private TextView txtQuestion;
    private TextView txtReference;
	private RadioButton rda;
    private RadioButton rdb;
    private RadioButton rdc;
    private RadioButton rdd;

    /**
     *
     */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		DbHelper db=new DbHelper(this);
		quesList=db.getAllQuestions();
		currentQ=quesList.get(qid);
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
        if (qid < 20) {        //sets number of questions
            currentQ = quesList.get(qid);
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
        alertDialogBuilder.setPositiveButton("Report Bug" ,new DialogInterface.OnClickListener() {
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
        txtQNumber.setText(qid + 1 + "/20");
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
    public void submitBug() {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "bryan.walsh.mti@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "36-3 Bug Report");
        intent.putExtra(Intent.EXTRA_TEXT, "The following question is incorrect: \n\n" + "Question Number: " + currentQ.getID() + "\n\n" + currentQ.getQUESTION() + "\n\n" + "Choice A:  "+ currentQ.getOPTA() + "\n\n" + "Choice B:  "+ currentQ.getOPTB() + "\n\n" + "Choice C:  " + currentQ.getOPTC() + "\n\n" + "Choice D:  " + currentQ.getOPTD() + "\n\n Additional Information: \n");
        startActivity(Intent.createChooser(intent, ""));


    }
}
