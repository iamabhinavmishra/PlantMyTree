package com.project.plantmtytree.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.plantmtytree.R;

public class EventConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_confirm);
    }

    public void callHome(View view) {
        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
        finish();
    }
}