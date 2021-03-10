package com.example.ex123;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    private Button camerabtn123;
    ImageView imagecamera;
    private Dialog d;
    private Button camerabtn,gallerybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imagecamera=findViewById(R.id.imagecamera);
        camerabtn123=findViewById(R.id.camera123btn);
        camerabtn123.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (camerabtn123==view){
            d= new Dialog(this);
            d.setContentView(R.layout.photo);
            camerabtn=d.findViewById(R.id.camerabtn);
            camerabtn.setOnClickListener(this);
            gallerybtn=d.findViewById(R.id.gallerybtn);
            gallerybtn.setOnClickListener(this);
            d.show();
        }
        if (camerabtn==view){
            Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,1);
            d.dismiss();
        }
        if (gallerybtn==view){
            Intent intent= new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,2);
            d.dismiss();

        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1){

            if (resultCode==RESULT_OK)
            {
                Bitmap bitmap= (Bitmap)data.getExtras().get("data");
                imagecamera.setImageBitmap(bitmap);
            }

        }
        else if (requestCode==2)
        {
            if (resultCode==RESULT_OK)
            {
                Uri selectedimage= data.getData();
                imagecamera.setImageURI(selectedimage);
            }
        }
    }



}