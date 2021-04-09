package com.project.plantmtytree.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.plantmtytree.R;

public class AddEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
    }



    public void callEventConfirm(View view) {
    }

    public void callCancelEvent(View view) {
        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
        finish();
    }


    public void callDashboard(View view) {
        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
        finish();
    }



}