package com.harshitagg.AndroidTutorial.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import com.harshitagg.AndroidTutorial.R;

public class IntentExampleActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
	AlertDialog.Builder alertBox;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void sendMessage(View view) {
    	EditText editText = (EditText) findViewById(R.id.edit_message);
        final String message = editText.getText().toString();
    	alertBox=new AlertDialog.Builder(this);
    	alertBox.setMessage("You typed "+message);
    	alertBox.setNeutralButton("OK", new OnClickListener() {
			
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
		        intent.putExtra("MESSAGE", message);
		        startActivity(intent);
			}
		});
    	alertBox.show();
        }
}
