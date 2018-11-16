package com.example.owner.woodrecognitionapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class MainForm extends AppCompatActivity {
    Button btnCapture;
    ImageView imgGet;
    EditText edtName, edtFamily;
    Button   btnadd,btnview,btnbrowse;
    ImageView imageView;
    public static SQLiteHelper sqLiteHelper;


    private static final int CAMERA_REQUEST = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);
        init();
        sqLiteHelper = new SQLiteHelper(this, "TreeDBData", null, 1);
        sqLiteHelper.query("CREATE TABLE IF NOT EXISTS Tree (ID INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, family VARCHAR, image BLOG)");

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    sqLiteHelper.insertData(edtName.getText().toString().trim(),
                            edtFamily.getText().toString().trim(),
                            imageViewToByte(imageView)
                    );
                    Toast.makeText(getApplicationContext(),"Added Successfully!",LENGTH_SHORT).show();
                    edtName.setText("");
                    edtFamily.setText("");
                    imageView.setImageResource(R.drawable.lovetree);

                }
                catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainForm.this, "Failed to insert data", Toast.LENGTH_SHORT).show();

                }

            }


        });

        btnCapture = (Button) findViewById(R.id.btnCapture);

        imgGet = (ImageView) findViewById(R.id.imgGet);

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick(v);
            }
        });




        btnview = (Button) findViewById(R.id.btnView);
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainForm.this, TreeClassList.class);
                    startActivity(intent);

                    // Toast.makeText(this, f.getName(), Toast.LENGTH_SHORT).show();

                }
                catch(Exception e){

                    Toast.makeText(MainForm.this, e.toString(), Toast.LENGTH_SHORT).show();


                }
            }
        });

        }



    private byte[] imageViewToByte (final ImageView image) {

        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
        }
        public void btnClick(View v){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,CAMERA_REQUEST);

        }

        public void onActivityResult(int requestcode, int resultcode, Intent data){
        if(requestcode==CAMERA_REQUEST&&resultcode==Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgGet.setImageBitmap(photo);

        }




        }
        private void init() {

        edtName = (EditText) findViewById(R.id.editname);
        edtFamily = (EditText) findViewById(R.id.editfamilyname);
        btnadd = (Button) findViewById(R.id.btnSave);
        btnview = (Button) findViewById(R.id.btnView);


        imageView = (ImageView) findViewById(R.id.imgGet);
        }
}
