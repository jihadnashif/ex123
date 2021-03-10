package com.example.ex123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ItemProfile extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName, tvPassword;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_profile);
        Intent intent=getIntent();
        Post post=(Post)intent.getSerializableExtra("post");
        tvName = findViewById(R.id.tvName);
        tvPassword = findViewById(R.id.tvPassword);

        String name = this.getIntent().getStringExtra("name");
        String password = this.getIntent().getStringExtra("password");

        tvPassword.setText(password);
        tvName.setText(name);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, StoreActivity.class);
        startActivity(intent);
    }

}