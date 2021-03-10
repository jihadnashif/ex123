package com.example.ex123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvregister,tvlogin;
    private Button loginbtn;
    private EditText emailet, passwordet;
    private FirebaseAuth mAuth;
  //  private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth = FirebaseAuth.getInstance();
        emailet = findViewById(R.id.emailet);
        emailet.setOnClickListener(this);
        passwordet = findViewById(R.id.passwordet);
        passwordet.setOnClickListener(this);
        tvregister = findViewById(R.id.tvregister);
        tvregister.setOnClickListener(this);
        loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(this);
      //  sp = getSharedPreferences("details", 0);


    }


    @Override
    public void onClick(View view) {
        if (tvregister == view) {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        }
        if (loginbtn == view) {
            if (emailet.getText().toString().equals("") || passwordet.getText().toString().equals("")) {
                Toast.makeText(this, ("fill the empty fields"), Toast.LENGTH_LONG).show();

            }
            else{
                signIn(emailet.getText().toString(),passwordet.getText().toString());
            }

           /*else if(emailet.getText().toString().equals(sp.getString("Email",""))&&passwordet.getText().toString().equals(sp.getString("Password",""))){
                Intent intent = new Intent(this, MainPageActivity.class);
                startActivity(intent);
            }
*/


        }

    }

    public void signIn(final String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(LogInActivity.this, "success",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(LogInActivity.this,MainPageActivity.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LogInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
}




