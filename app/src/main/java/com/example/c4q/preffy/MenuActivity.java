package com.example.c4q.preffy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = "MenuActivity"; //MenuActivity.class.getSimpleName() ;
    private SharedPreferences prefs;
    TextView loremTV;

    private final static String TEXT_SIZE_KEY = "pref_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loremTV = (TextView) findViewById(R.id.lorem_textview);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        float defaultSize = prefs.getFloat(TEXT_SIZE_KEY, getResources().getDimension(R.dimen.eight_dp));
        loremTV.setTextSize(defaultSize);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        float size = 0;
        switch (item.getItemId()) {
            case R.id.smallest_text_action:
                Log.d(TAG, "Smallest text selected");
                 size = getResources().getDimension(R.dimen.smallest_dp);
                break;

            case R.id.really_big:
                Log.d(TAG, "Largest text size selected");
                size = getResources().getDimension(R.dimen.sixfo);
                break;
        }
        loremTV.setTextSize(size);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putFloat(TEXT_SIZE_KEY,size);
        editor.apply();

        return super.onOptionsItemSelected(item);
    }
}
