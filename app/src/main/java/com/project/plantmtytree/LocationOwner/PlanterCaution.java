package com.project.plantmtytree.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.plantmtytree.R;

public class PlanterCaution extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planter_caution);
    }

    public void callBackScreenFromMakeSelection(View view) {
        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
    }

    public void callProceed(View view) {
        startActivity(new Intent(getApplicationContext(), AddEvent.class));
    }
}