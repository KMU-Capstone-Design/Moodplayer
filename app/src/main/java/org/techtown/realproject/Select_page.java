package org.techtown.realproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;

public class Select_page extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }

    }


    public void imageClicked1(View v){ // 사진찍기
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
        //finish();
    }
    public void imageClicked2(View v){ // 갤러리
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivity(intent);
        //finish();
    }
    public void imageClicked3(View v){ // 리스트
        Intent intent = new Intent(getApplicationContext(), List_page.class);
        startActivity(intent);
        finish();
    }
    public void imageClicked4(View v){ // 검색
        Intent intent = new Intent(getApplicationContext(), Search_page.class );
        startActivity(intent);
        finish();
    }
    public void buttonClicked1(View v){
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText("1. 사진찍기      2. 갤러리\n3. 무드리스트      4.검색 ");
    }
}
