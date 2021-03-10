package com.example.ex123;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AllPostAdapter extends ArrayAdapter<Post> {

private Context context;
private List<Post> objects;


    public AllPostAdapter(@NonNull Context context, int resource, @NonNull List<Post> objects ) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
      LayoutInflater layoutInflater= ((Activity)context).getLayoutInflater();
      View view= layoutInflater.inflate(R.layout.custom_post,parent,false);


      TextView tvTitle = view.findViewById(R.id.tvTitle);
      Post temp = objects.get(position);
      tvTitle.setText(temp.title);
      return view;
    }
}
