package com.example.ex123;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    //attributes
    private Context context;
    private int resource;//will contain the value of the layout file that was created

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    public ItemAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    /*
    getView() method. This view is called when a listItem needs to be created and populated with the data.
    In this method first the View is inflated using the LayoutInflator.inflate() method.
    It is important that you check that if the view you are trying to inflate is new or reused
     */


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
            convertView = LayoutInflater.from(this.context).inflate(this.resource,parent,false);
        Item item = getItem(position);

        if(item != null){
            TextView tvName = convertView.findViewById(R.id.textViewName);
            tvName.setText(item.getName());


            ImageView imageView = convertView.findViewById(R.id.image);
            imageView.setImageResource(R.drawable.ic_launcher_background);

        }
        return convertView;
    }
}
