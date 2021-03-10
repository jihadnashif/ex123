package com.example.ex123;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPost extends AppCompatActivity implements View.OnClickListener {
private EditText ettitle,etbody;
private Button btnsave;
FirebaseDatabase firebaseDatabase;
DatabaseReference PostRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        firebaseDatabase=FirebaseDatabase.getInstance();
        ettitle=findViewById(R.id.ettitle);
        etbody=findViewById(R.id.etbody);
        btnsave=findViewById(R.id.btnsave);
        btnsave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String uid= FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
        Post p=new Post(uid,ettitle.getText().toString(),etbody.getText().toString(),"");
        PostRef=firebaseDatabase.getReference("Posts").push();
        p.key=PostRef.getKey();
        PostRef.setValue(p);
        Toast.makeText(this,"saved",Toast.LENGTH_LONG).show();



    }
}