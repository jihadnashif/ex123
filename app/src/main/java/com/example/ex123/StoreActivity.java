package com.example.ex123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView listView;//display
    private ArrayList<Item> store;//DATA
    private ArrayAdapter<Item> arrayAdapter;//Adapter


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        listView = findViewById(R.id.itemlistview);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

        store = new ArrayList<>();
        store.add(new Item("aaa", "B","A@b.c","12346",true));
        store.add(new Item("aaa", "B","A@b.c","12346",true));


        arrayAdapter = new ItemAdapter(this,R.layout.custom_row, store);
        listView.setAdapter(arrayAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Item person = store.get(i);
        Intent intent = new Intent(this, ItemProfile.class);

        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        store.remove(i);
        return false;
    }


}
