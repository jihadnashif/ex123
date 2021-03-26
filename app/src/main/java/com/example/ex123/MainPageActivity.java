package com.example.ex123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainPageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnaddpost,btnallpost, ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        btnaddpost = findViewById(R.id.btnaddpost);
        btnaddpost.setOnClickListener(this);
        btnallpost=findViewById(R.id.btnallpost);
        btnallpost.setOnClickListener(this);
        ll = findViewById(R.id.ll);
        ll.setOnClickListener(this);

        Intent notification = new Intent(this, Receiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, notification, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), 1000*60*60*24, pendingIntent);


        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> SlideModels = new ArrayList<>();
        SlideModels.add(new SlideModel("https://upload.wikimedia.org/wikipedia/commons/9/91/Palestine_sunbird_%28Cinnyris_osea_osea%29_male.jpg", "1"));
        SlideModels.add(new SlideModel("https://api.time.com/wp-content/uploads/2019/08/better-smartphone-photos.jpg?w=941&quality=85", "2"));

        imageSlider.setImageList(SlideModels, true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.storeMenu:
                Toast.makeText(this, "buy an item", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(this, StoreActivity.class);
                startActivity(intent1);
                break;


            case R.id.smartmenu:
                Toast.makeText(this, "take a photo", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, CameraActivity.class);
                startActivity(intent);
                break;

            case R.id.emailMenu:
                Toast.makeText(this, "Email", Toast.LENGTH_LONG).show();

                String[] emails = {"abode.nashif11@gmail.com"};
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_EMAIL, emails);
                intent2.putExtra(Intent.EXTRA_SUBJECT, "شو الأخبار");
                intent2.putExtra(Intent.EXTRA_TEXT, "هل تريد التواصل معنا اتصل على الرقم");
                startActivity(Intent.createChooser(intent2, "Send Email"));


                break;


            case R.id.signOutMenu:
                Toast.makeText(this, "Sign out", Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(this, LogInActivity.class);
                startActivity(intent3);
                break;


        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if (btnaddpost == view) {
            Intent intent = new Intent(this, AddPost.class);
            startActivity(intent);
        }
        if (btnallpost==view){
            Intent intent=new Intent(this,MainActivity_ListForPost.class);
            startActivity(intent);

        }
        if (ll==view){
            Intent intent=new Intent(this,AllCategories.class);
            startActivity(intent);

        }



    }
}











