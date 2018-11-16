package com.example.owner.woodrecognitionapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {


    public SQLiteHelper(@androidx.annotation.Nullable @Nullable Context context, @androidx.annotation.Nullable @Nullable String name, @androidx.annotation.Nullable @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void query(String sql){

        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);

    }



    public void insertData(String name, String familyname, byte[] image){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "insert into Tree values (NULL , ? , ? , ?)";
        SQLiteStatement st =database.compileStatement(sql);
        st.clearBindings();
        st.bindString(1,name);
        st.bindString(2,familyname);
        st.bindBlob(3,image);
        st.executeInsert();

    }


    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
