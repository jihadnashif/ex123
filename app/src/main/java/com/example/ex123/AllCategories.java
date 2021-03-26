package com.example.ex123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AllCategories extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout Songbirds,waterBird,accipitriformes,galliformes;
    private TextView activity_all_categories_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);
        Songbirds = findViewById(R.id.activity_all_categories_Songbirds);
        waterBird=findViewById(R.id.activity_all_categories_waterbirds);
        accipitriformes=findViewById(R.id.activity_all_categories_accipitriformes);
        galliformes=findViewById(R.id.activity_all_categories_galliformes);
        Songbirds.setOnClickListener(this);
        waterBird.setOnClickListener(this);
        accipitriformes.setOnClickListener(this);
        galliformes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (Songbirds == view) {
            Intent intent = new Intent(this, BirdsCategoryActivity.class);
            intent.putExtra("type","songbirds");
            startActivity(intent);
        }
        else if (waterBird == view) {
            Intent intent = new Intent(this, BirdsCategoryActivity.class);
            intent.putExtra("type","waterbirds");
            startActivity(intent);
        }

        else if (accipitriformes == view) {
            Intent intent = new Intent(this, BirdsCategoryActivity.class);
            intent.putExtra("type","accipitriformes");
            startActivity(intent);
        }
        else if (galliformes == view) {
            Intent intent = new Intent(this, BirdsCategoryActivity.class);
            intent.putExtra("type","galliformes");
            startActivity(intent);
        }
    }
}