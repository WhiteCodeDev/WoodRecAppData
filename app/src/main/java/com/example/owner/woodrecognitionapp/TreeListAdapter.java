package com.example.owner.woodrecognitionapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TreeListAdapter extends BaseAdapter {


    private Context context;
    private int layout;
    private ArrayList<TreeClass>treeClasses;


    public TreeListAdapter(Context context, int layout, ArrayList<TreeClass> treeClasses) {
        this.context = context;
        this.layout = layout;
        this.treeClasses = treeClasses;
    }

    @Override
    public int getCount() {
        return treeClasses.size();
    }

    @Override
    public Object getItem(int position) {
        return treeClasses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public class viewHolder{

        ImageView imageView;
        TextView txtname, txtfamilyname;

    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {



        View row = view;
        viewHolder holder = new viewHolder();
        if(row==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);


            holder.txtname = (TextView) row.findViewById(R.id.TreeName);
            holder.txtfamilyname = (TextView) row.findViewById(R.id.TreeFamily);
            holder.imageView = (ImageView) row.findViewById(R.id.imgViewList);
            row.setTag(holder);
        }

        else{

            holder = (viewHolder) row.getTag();
        }

        TreeClass tree = treeClasses.get(position);
        //getter
        holder.txtname.setText(tree.getName());
        holder.txtfamilyname.setText(tree.getFamilyName());
        byte [] treeImage = tree.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(treeImage, 0, treeImage.length);
        holder.imageView.setImageBitmap(bitmap);


        return row;
    }
}
