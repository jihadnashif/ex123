package com.example.ex123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity_ListForPost extends AppCompatActivity {
private ListView lv;
private ArrayList<Post> posts;
private AllPostAdapter allPostAdapter;
private DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__list_for_post);
        database = FirebaseDatabase.getInstance().getReference("Posts");
        lv=findViewById(R.id.lv);
        getAllPosts();
    }

    private void getAllPosts() {
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                posts= new ArrayList<Post>();
          //      String uid= FirebaseAuth.getInstance().getCurrentUser().getUid();
                for (DataSnapshot data: snapshot.getChildren()){
                    Post p=data.getValue(Post.class);
             //       if (p.uid.equals(uid))
                    posts.add(p);
                }
                allPostAdapter = new AllPostAdapter(MainActivity_ListForPost.this,0,posts);
                lv.setAdapter(allPostAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}