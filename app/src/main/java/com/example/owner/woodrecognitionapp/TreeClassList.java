package com.example.owner.woodrecognitionapp;

import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.Nullable;

//import androidx.annotation.Nullable;

public class TreeClassList extends AppCompatActivity {

    GridView gridView;
    ArrayList<TreeClass>list;
    TreeListAdapter adapter = null;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tree_list);

        gridView = findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new TreeListAdapter(this, R.layout.tree_items, list);
        gridView.setAdapter(adapter);



        //get all data from sqlite
        Cursor cursor = MainForm.sqLiteHelper.getData("SELECT * FROM Tree");
        list.clear();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String familyname = cursor.getString(2);
            byte [] image = cursor.getBlob(3);

            list.add(new TreeClass(id,name,familyname,image));
        }
        adapter.notifyDataSetChanged();

    }

}