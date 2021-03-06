package com.project.plantmtytree.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.plantmtytree.LocationOwner.PlanterDashboard;
import com.project.plantmtytree.R;

public class ForgetPasswordSuccessMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_success_message);
    }

    public void backToDashboard(View view) {
        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
        finish();
    }
}