package com.example.ex123;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class BirdsCategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private TextView title;
    //list
    private ListView listView;//display
    private ArrayList<Bird> birdsList;//DATA
    private BirdsAdapter birdListAdapter;//Adapter
    //firebase
    private FirebaseAuth auth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference birdsref;

    private Button addbtn;

    // dialog
    private Dialog d;
    private EditText nameet,scientificNameet,lengthet, foodet, localFrequencyLocationet, descriptionet, localSeasonet;
    private Button imagebtn,addbirdbtn;

    //camera dialog
    private Dialog d2;
    private Button camerabtn,gallerybtn;
    private String imageString;

    //intent
    private String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds_category);
        title=findViewById(R.id.activity_songbirds_titletv);
        //intent
        Intent intent=getIntent();
        type=intent.getStringExtra("type");

        title.setText(type);

        //firebase
        auth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        birdsref=firebaseDatabase.getReference().child("birds");

        listView = findViewById(R.id.activity_songbirds_Listview);
        listView.setOnItemClickListener(this);
        birdsList = new ArrayList<Bird>();
      //  birdsList.add(new Bird("a","a","a","a","a","a","a","a","a"));
       // birdsList.add(new Bird("b","b","b","b","b","b","b","b","b"));
        birdListAdapter = new BirdsAdapter(BirdsCategoryActivity.this, 0, birdsList);
        listView.setAdapter(birdListAdapter);
        addbtn=findViewById(R.id.activity_songbirds_addbtn);
        addbtn.setOnClickListener(this);

        getAllBirds();

        if (auth.getCurrentUser().getEmail().equals("admin@gmail.com")) {
            addbtn.setVisibility(View.VISIBLE);
        }
    }

    private void getAllBirds() {
        birdsref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                birdsList= new ArrayList<Bird>();
               for (DataSnapshot data: snapshot.getChildren()){
                    Bird bird=data.getValue(Bird.class);
                    if(bird.getType().equals(type   ))
                        birdsList.add(bird);
                }
                birdListAdapter = new BirdsAdapter(BirdsCategoryActivity.this,0,birdsList);
                listView.setAdapter(birdListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent(this,BirdProfileActivity.class);
        Bird bird=birdsList.get(i);
        intent.putExtra("bird",bird);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view==addbtn){
            d= new Dialog(this);
            d.setContentView(R.layout.songbirdsactivity_add_dialog);

            nameet=d.findViewById(R.id.songbirdsactivity_add_dialog_nameet);
            scientificNameet=d.findViewById(R.id.songbirdsactivity_add_dialog_scientificNameet);
            lengthet=d.findViewById(R.id.songbirdsactivity_add_dialog_lengthet);
            foodet=d.findViewById(R.id.songbirdsactivity_add_dialog_foodet);
            localFrequencyLocationet=d.findViewById(R.id.songbirdsactivity_add_dialog_localFrequencyLocationet);
            descriptionet=d.findViewById(R.id.songbirdsactivity_add_dialog_descriptionet);
            localSeasonet=d.findViewById(R.id.songbirdsactivity_add_dialog_localSeasonet);
            imagebtn=d.findViewById(R.id.songbirdsactivity_add_dialog_imagebtn);
            imagebtn.setOnClickListener(this);
            addbirdbtn=d.findViewById(R.id.songbirdsactivity_add_dialog_addbirdbtn);
            addbirdbtn.setOnClickListener(this);
            d.show();
        }
        else if (view== addbirdbtn){
            Bird bird=new Bird(nameet.getText().toString(),scientificNameet.getText().toString(),type,imageString,lengthet.getText().toString(),
                    foodet.getText().toString(),localFrequencyLocationet.getText().toString(),descriptionet.getText().toString(),localSeasonet.getText().toString());
            birdsref.child(bird.getName()).setValue(bird);
            d.dismiss();

        }

        else if(view==imagebtn){
            d2= new Dialog(this);
            d2.setContentView(R.layout.photo);
            camerabtn=d2.findViewById(R.id.camerabtn);
            camerabtn.setOnClickListener(this);
            gallerybtn=d2.findViewById(R.id.gallerybtn);
            gallerybtn.setOnClickListener(this);
            d2.show();
        }
       else if (camerabtn==view){
            Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,1);
            d2.dismiss();
        }
       else if (gallerybtn==view){
            Intent intent= new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,2);
            d2.dismiss();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){

            if (resultCode==RESULT_OK)
            {
                Bitmap bitmap= (Bitmap)data.getExtras().get("data");
                imageString=BitMapToString(bitmap);
            }

        }
        else if (requestCode==2)
        {
            if (resultCode==RESULT_OK)
            {

                try {
                    InputStream inputStream=getContentResolver().openInputStream(data.getData());
                    Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
                    imageString=BitMapToString(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }



            }
        }
    }


    public static String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }


    /**
     * @param encodedString
     * @return bitmap (from given string)
     */
    public static Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;

        }

    }

}