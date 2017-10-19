package com.example.garionsblade.siaappchallenge;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MainActivity currentScreen = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    EditText myEditText = (EditText) findViewById(R.id.editText);
    Button myButton = (Button) findViewById(R.id.button);



}
