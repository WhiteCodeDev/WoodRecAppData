package com.example.owner.woodrecognitionapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Processing extends AppCompatActivity {


    Button btnCapture2,btnProcess;
    ImageView imgGet2;
    private static final int CAMERA_REQUEST = 123;

    public static SQLiteHelper sqLiteHelper;

    ArrayList<TreeClass> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing);

        btnCapture2 = (Button) findViewById(R.id.btnCapture2);

        imgGet2 = (ImageView) findViewById(R.id.imgGet2);


        btnCapture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(v);
            }
        });


        btnProcess = (Button) findViewById(R.id.btnProcess);
        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Cursor cursor = sqLiteHelper.getData("SELECT * FROM Tree");

                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(0);
                        String name = cursor.getString(1);
                        String familyname = cursor.getString(2);
                        byte[] image = cursor.getBlob(3);
                        Toast.makeText(Processing.this, name, Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(Processing.this, e.toString(), Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    public void btnClick(View v) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, CAMERA_REQUEST);

    }

    public void onActivityResult(int requestcode, int resultcode, Intent data) {
        if (requestcode == CAMERA_REQUEST && resultcode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgGet2.setImageBitmap(photo);


        }

    }
}
