package com.harshitagg.AndroidTutorial.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.harshitagg.AndroidTutorial.R;

public class AutoCompleteExampleActivity extends Activity {
    private static final String[] MONTHS = new String[]{"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete_example_layout);

        initializeAutoComplete();
    }

    private void initializeAutoComplete() {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, MONTHS);
        autoCompleteTextView.setAdapter(monthAdapter);
        autoCompleteTextView.setThreshold(1);
    }
}
