package com.project.plantmtytree.User;

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

public class ViewLocation extends AppCompatActivity {
    private RecyclerView recyclerView;
    locationsAdapter  adapter;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_location);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Locations");
        recyclerView = findViewById(R.id.location_recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<locations> options
                = new FirebaseRecyclerOptions.Builder<locations>()
                .setQuery(reference, locations.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new locationsAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);

        adapter = new locationsAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
    }

    public void callBackScreen(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
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