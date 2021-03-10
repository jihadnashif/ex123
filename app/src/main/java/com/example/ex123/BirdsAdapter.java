package com.example.ex123;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;



import java.util.ArrayList;
import java.util.List;

public class BirdsAdapter extends ArrayAdapter<Bird> {
    Context context;
    ArrayList<Bird> objects;

    public BirdsAdapter(Context context, int resource, ArrayList objects) {
        super(context, resource, objects);

        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.birdlist_layout, parent, false);

        TextView title = (TextView) view.findViewById(R.id.birdlist_layout_nametv);
        ImageView imageView=(ImageView) view.findViewById(R.id.birdlist_layout_imageview);
        Bird temp = objects.get(position);
        Bitmap bitmap=null;
        if(!temp.getImage().equals(""))
            bitmap=StringToBitMap(temp.getImage());


        title.setText(temp.getName());
        if(bitmap!=null)
        imageView.setImageBitmap(bitmap);
        // subtitle.setText(temp.getSubtitle());
        //imageView.setImageBitmap( StringToBitMap(temp.getImage()));
        return view;
    }
    public static Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;

        }
}}
