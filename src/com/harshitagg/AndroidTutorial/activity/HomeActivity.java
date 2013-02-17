package com.harshitagg.AndroidTutorial.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.harshitagg.AndroidTutorial.R;

public class HomeActivity extends Activity {
    private static final String[] OPTIONS = new String[]{"Intent example","AutoComplete Example"};
    AlertDialog.Builder alertBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); 
        initializeView();
    }
    
    private void initializeView() {
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textView, OPTIONS);
        alertBox= new AlertDialog.Builder(this);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	final int pos=position;
            	alertBox.setMessage("Do you want to go to another page");
            	alertBox.setPositiveButton("YES",new OnClickListener() {	
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						Intent intent = new Intent(getApplicationContext(), IntentExampleActivity.class);
						intent.putExtra("Position",pos);
		                startActivity(intent);		
					}
				});
            	alertBox.setNegativeButton("No", new OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();	
					}
				});
                alertBox.show();
            }
        });
    }
}
