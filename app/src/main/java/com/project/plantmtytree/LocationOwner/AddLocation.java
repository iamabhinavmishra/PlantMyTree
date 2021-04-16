package com.project.plantmtytree.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.plantmtytree.R;
import com.project.plantmtytree.User.PlantTree;
import com.project.plantmtytree.User.RecyclerItemClickListener;
import com.project.plantmtytree.User.events;
import com.project.plantmtytree.User.eventsAdapter;

public class AddLocation extends AppCompatActivity {
    private RecyclerView recyclerView;
    ordersAdapter adapter;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Orders");
        recyclerView = findViewById(R.id.order_recycler);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        callAddLocation();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<orders> options
                = new FirebaseRecyclerOptions.Builder<orders>()
                .setQuery(reference, orders.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new ordersAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);

        adapter = new ordersAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
    }

    private void callAddLocation() {
        startActivity(new Intent(getApplicationContext(), UpdateLocation.class));
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
}