package com.military.quizthirtysixthree;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ChoiceActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);


        Button button1 = (Button) findViewById(R.id.btn363);
        Button button2 = (Button) findViewById(R.id.btn3603);
        Button button3 = (Button) findViewById(R.id.btn2905);
        Button button4 = (Button) findViewById(R.id.btn48150);
        Button button5 = (Button) findViewById(R.id.btnWAC);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Context context = getApplicationContext();
        switch(v.getId()) {
            case R.id.btn363:
                Intent mainIntent = new Intent(ChoiceActivity.this, Quiz_Choice.class);
                ChoiceActivity.this.startActivity(mainIntent);
                ChoiceActivity.this.finish();
                break;
            case R.id.btn3603:
                // do stuff;
                Toast.makeText(context, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2905:
                // do stuff;
                Toast.makeText(context, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn48150:
                // do stuff;
                Toast.makeText(context, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnWAC:
                // do stuff;
                Toast.makeText(context, "Coming Soon", Toast.LENGTH_SHORT).show();
                break;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choice, menu);
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
