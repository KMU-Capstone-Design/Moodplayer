package org.techtown.realproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import java.io.File;

public class Banner_page extends AppCompatActivity {
    ImageView imgVwSelected;
    Button send_image, load_image;
    File tempSelectFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        send_image = findViewById(R.id.send_image);
        send_image.setEnabled(false);
        send_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestHttpURLConnection.send2Server(tempSelectFile);
            }
        });

        load_image = findViewById(R.id.load_image);
        load_image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });

        imgVwSelected = findViewById(R.id.imgVwSelected);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1 || resultCode != RESULT_OK) {
            return;
        }

        Uri dataUri = data.getData();
        imgVwSelected.setImageURI(dataUri);

        try {
            InputStream in = getContentResolver().openInputStream(dataUri);
            Bitmap image = BitmapFactory.decodeStream(in);
            imgVwSelected.setImageBitmap(image);
            in.close();

            String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
            //tempSelectFile.createNewFile();
            String StoragePath = Environment.getExternalStorageDirectory().getCanonicalPath();
            String savePath = StoragePath + "/Pictures/Test";
            File f = new File(savePath);
            if (!f.isDirectory())
                f.mkdirs();
            tempSelectFile = new File(savePath + "/temp_" + date + ".jpeg");
            FileOutputStream out = new FileOutputStream(tempSelectFile);
            image.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        send_image.setEnabled(true);
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
