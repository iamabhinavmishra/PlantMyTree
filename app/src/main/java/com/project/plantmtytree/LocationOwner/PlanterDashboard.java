package com.project.plantmtytree.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.project.plantmtytree.R;
import com.project.plantmtytree.User.UserDashboard;

public class PlanterDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planter_dashboard);
    }

    public void callBackScreenFromMakeSelection(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }

    public void callAddEvent(View view) {
        startActivity(new Intent(getApplicationContext(), PlanterCaution.class));

    }

    public void callAddLocation(View view) {
        startActivity(new Intent(getApplicationContext(), CautionTwo.class));

    }

    public void callLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }
}