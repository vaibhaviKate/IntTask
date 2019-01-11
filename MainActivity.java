package com.example.vaibhavi.forinternshala;

;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        ArrayList<Users> users = new ArrayList<Users>();

        users.add(new Users("Amogh", 19));
        users.add(new Users("Prachiti", 20));
        users.add(new Users("Sohan", 21));
        users.add(new Users("Aditya", 21));
        users.add(new Users("Ruchit", 20));
        users.add(new Users("Parth", 22));
        users.add(new Users("Hardik", 25));
        users.add(new Users("Kunal", 20));
        users.add(new Users("Komal", 20));
        users.add(new Users("Rashmi", 21));


        Log.d("MainActivity",String.valueOf( users ) );

        recyclerView = findViewById(R.id.recyclerlist);

        recyclerView.setHasFixedSize(true); //every item in the recycler view will have fixed size
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ItemListAdapter(users,this);

        recyclerView.setAdapter(adapter); //sets adapter to recycler view

        Button button = findViewById(R.id.buttonfirebase);
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, userFromFirebase.class);
                startActivity(intent);
            }
        } );

    }
}
