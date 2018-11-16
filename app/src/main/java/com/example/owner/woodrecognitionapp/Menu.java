package com.example.owner.woodrecognitionapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button btnWood;
    Button btnProcess1;



    final int req =999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnWood = (Button) findViewById(R.id.btnWood);
        btnProcess1 = (Button) findViewById(R.id.btnProcess1);


        btnWood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(Menu.this, MainForm.class);
            startActivity(i);
            }
        });

        btnProcess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Processing.class);
                startActivity(i);
            }
        });




    }
}
