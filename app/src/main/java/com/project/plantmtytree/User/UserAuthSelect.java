package com.project.plantmtytree.User;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.project.plantmtytree.Common.LoginSignup.Login;
import com.project.plantmtytree.Common.LoginSignup.Signup;
import com.project.plantmtytree.Common.LoginSignup.startup_screen_main;
import com.project.plantmtytree.R;

public class UserAuthSelect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_auth_select);
    }

    public void callLoginScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), UserLogin.class);


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.login_btn), "transition_login");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(UserAuthSelect.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    public void callSignUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(), UserSignup.class);


        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(findViewById(R.id.signup_btn), "transition_signup");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(UserAuthSelect.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }

    }

    public void callDashboard(View view) {

        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
    }
}