package com.harshitagg.AndroidTutorial.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.harshitagg.AndroidTutorial.R;

public class DisplayMessageActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_message_activity);

        TextView viewMessageTextView = (TextView) findViewById(R.id.viewMessageTextView);

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");

        viewMessageTextView.setText(message);
    }
}
