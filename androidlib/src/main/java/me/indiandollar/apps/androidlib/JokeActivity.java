package me.indiandollar.apps.androidlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Indian Dollar on 2/16/2017.
 */

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "JOKE_KEY";
    private static final String TAG = "JokeActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);
        //LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        //View viewGroup = layoutInflater.inflate(R.layout.activity_jokes, null, false);
        TextView textView = (TextView) findViewById(R.id.jokeLabel);
        //Log.d(TAG, "onCreate: " + textView);
        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_KEY);
        //Log.d(TAG, "onCreate: " + joke);
        textView.setText(joke);


    }
}
