package com.harshitagg.AndroidTutorial.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import com.harshitagg.AndroidTutorial.R;

public class IntentExampleActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
	AlertDialog.Builder alertBox;
	String message;
	AutoCompleteTextView auto;
	private static final String[] MONTHS = new String[]{"January","February","March","April","May","June","July","Auguts","September","October","November","December"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	alertBox=new AlertDialog.Builder(this);
        Intent i=getIntent();
        
        int position=i.getExtras().getInt("Position");
        showActivity(position);
    }

    public void showActivity(int position) {
    	alertBox=new AlertDialog.Builder(this);
    	switch(position)
    	{
    	case 0:
            setContentView(R.layout.main);
            break;
    	case 1:
            setContentView(R.layout.autocomplete);
    		auto=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
    		ArrayAdapter<String> monthAdapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, MONTHS);
    		auto.setAdapter(monthAdapter);
    		auto.setThreshold(1);
    		break;
    	default:
    		alertBox.setMessage("Invalid Selection");
    		alertBox.show();
    	}
 }
    public void sendMessage(View view) {
    	EditText editText = (EditText) findViewById(R.id.edit_message);
        final String message = editText.getText().toString();
    	alertBox.setMessage("You typed "+message);
    	alertBox.setNeutralButton("OK", new OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
				Intent intent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
		        intent.putExtra("MESSAGE", message);
		        startActivity(intent);
			}
		});
    	alertBox.show();
        }
    }
