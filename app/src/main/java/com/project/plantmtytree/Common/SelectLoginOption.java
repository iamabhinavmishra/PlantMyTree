package com.project.plantmtytree.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.plantmtytree.Common.LoginSignup.startup_screen_main;
import com.project.plantmtytree.R;
import com.project.plantmtytree.User.UserAuthSelect;
import com.project.plantmtytree.User.UserDashboard;

public class SelectLoginOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_option);
    }

    public void callStartupScreen(View view) {
        startActivity(new Intent(getApplicationContext(), startup_screen_main.class));
    }

    public void callBackScreenFromMakeSelection(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
    }

    public void callUserOptions(View view) {
        startActivity(new Intent(getApplicationContext(), UserAuthSelect.class));
    }
}