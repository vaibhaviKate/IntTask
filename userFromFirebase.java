package com.example.vaibhavi.forinternshala;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class userFromFirebase extends AppCompatActivity {

    public ArrayList<Users> userlist;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_user_from_firebase );


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("/Users");
        databaseReference.addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Users user2 = ds.getValue(Users.class);
                    Log.d("userFromFirebase", user2.toString());
                    assert user2 != null;
                    int age = user2.getAge();
                    String name = user2.getName();
                    int uid = user2.getUid();
                    userlist.add(new Users(age, name, uid));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        } );


        recyclerView = findViewById(R.id.recyclerlistFirebase);

        recyclerView.setHasFixedSize(true); //every item in the recycler view will have fixed size
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FirebaseItemAdapter(userlist,this);

        recyclerView.setAdapter(adapter); //sets adapter to recycler view

    }
}
