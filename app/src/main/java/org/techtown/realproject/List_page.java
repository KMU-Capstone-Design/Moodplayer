package org.techtown.realproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class List_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
    public void backspaceClicked(View v){
        Intent intent = new Intent(getApplicationContext(),Select_page.class);
        startActivity(intent);
        finish();
    }
    public void homeClicked(View v){
        Intent intent = new Intent(getApplicationContext(),Select_page.class);
        startActivity(intent);
        finish();
    }
}