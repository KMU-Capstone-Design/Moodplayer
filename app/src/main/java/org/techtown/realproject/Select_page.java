package org.techtown.realproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;

public class Select_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
    }
    public void imageClicked1(View v){

    }
    public void imageClicked2(View v){

    }
    public void imageClicked3(View v){
        Intent intent = new Intent(getApplicationContext(), List_page.class);
        startActivity(intent);
        finish();
    }
    public void imageClicked4(View v){
        Intent intent = new Intent(getApplicationContext(), Search_page.class );
        startActivity(intent);
        finish();
    }
}
