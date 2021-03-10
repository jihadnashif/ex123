package com.example.ex123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class BirdProfileActivity extends AppCompatActivity {

    private TextView nametv,scientificNametv,typetv,imagetv,lengthtv, foodtv, localFrequencyLocationtv, descriptiontv, localSeasontv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_profile);
        nametv=findViewById(R.id.songbirdsactivity_add_dialog_nametv);
        scientificNametv=findViewById(R.id.songbirdsactivity_add_dialog_scientificNametv);
        typetv=findViewById(R.id.songbirdsactivity_add_dialog_typetv);
        lengthtv=findViewById(R.id.songbirdsactivity_add_dialog_lengthtv);
        foodtv=findViewById(R.id.songbirdsactivity_add_dialog_foodtv);
        localFrequencyLocationtv=findViewById(R.id.songbirdsactivity_add_dialog_localFrequencyLocationtv);
        descriptiontv=findViewById(R.id.songbirdsactivity_add_dialog_descriptiontv);
        localSeasontv=findViewById(R.id.songbirdsactivity_add_dialog_localSeasontv);

        Intent intent=getIntent();
        Bird bird=(Bird)intent.getSerializableExtra("bird");
        nametv.setText(bird.getName());
        scientificNametv.setText(bird.getScientificName());
        typetv.setText(bird.getType());
        lengthtv.setText(bird.getLength());
        foodtv.setText(bird.getFood());
        localFrequencyLocationtv.setText(bird.getLocalFrequencyLocation());
        descriptiontv.setText(bird.getDescription());
        localSeasontv.setText(bird.getLocalSeason());

    }
}