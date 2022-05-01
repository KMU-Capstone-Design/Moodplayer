package org.techtown.realproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.io.File;

public class Banner_page extends AppCompatActivity {
    Button btn_tv1, btn_tv2, btn_tv3;
    ImageButton btn_tv4;
    String keyword1, keyword2, keyword3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        btn_tv1 = findViewById(R.id.btn_tv1);
        btn_tv2 = findViewById(R.id.btn_tv2);
        btn_tv3 = findViewById(R.id.btn_tv3);
        ImageButton btn_tv4 = findViewById(R.id.btn_tv4);
        /*
        keyword1 =
        keyword2 =
        keyword3 =
*/
        btn_tv1.setEnabled(false);
        btn_tv2.setEnabled(false);
        btn_tv3.setEnabled(false);
        btn_tv4.setEnabled(false);

        btn_tv1.setVisibility(View.INVISIBLE);
        btn_tv2.setVisibility(View.INVISIBLE);
        btn_tv3.setVisibility(View.INVISIBLE);
        btn_tv4.setVisibility(View.INVISIBLE);
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
    public void btn_tv1Clicked(View v){
       /* if(){
            btn_tv1.setVisibility(View.VISIBLE);
            btn_tv1.setEnabled(true);
        }*/
    }
    public void btn_tv2Clicked(View v){
        /*if(){
            btn_tv2.setVisibility(View.VISIBLE);
            btn_tv2.setEnabled(true);
        }*/
    }
    public void btn_tv3Clicked(View v){
        /*if(){
            btn_tv3.setVisibility(View.VISIBLE);
            btn_tv3.setEnabled(true);
        }*/
    }
    public void btn_tv4Clicked(View v){
        if(btn_tv1.isEnabled() == true) {
            btn_tv4.setVisibility(View.VISIBLE);
            btn_tv4.setEnabled(true);
        }
            Intent intent = new Intent(getApplicationContext(), List_page.class);
            startActivity(intent);
            finish();
    }
}
