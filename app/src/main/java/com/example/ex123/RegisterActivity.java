package com.example.ex123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button registerbtn;
    private EditText nameet, email2et, passworrd2et;
  //  private SharedPreferences sp;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nameet = findViewById(R.id.nameet);
        nameet.setOnClickListener(this);
        email2et = findViewById(R.id.email2et);
        email2et.setOnClickListener(this);
        passworrd2et = findViewById(R.id.passworrd2et);
        passworrd2et.setOnClickListener(this);
        registerbtn = findViewById(R.id.reistebtn);
        registerbtn.setOnClickListener(this);
        //sp = getSharedPreferences("details", 0);
        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View view) {
        if (registerbtn == view) {

           if (nameet.getText().toString().equals("") || email2et.getText().toString().equals("") || passworrd2et.getText().toString().equals("")) {
                Toast.makeText(this, ("fill the empty fields"), Toast.LENGTH_LONG).show();
            } /*else {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("Email", email2et.getText().toString());
                editor.putString("Password", passworrd2et.getText().toString());
                editor.commit();
                */
                Intent intent = new Intent(this, LogInActivity.class);
                startActivity(intent);



            createUser(email2et, passworrd2et);
        }






    }

    private void createUser(EditText email2et, EditText passworrd2et) {
        mAuth.createUserWithEmailAndPassword(email2et.getText().toString(), passworrd2et.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(RegisterActivity.this, "success",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
}