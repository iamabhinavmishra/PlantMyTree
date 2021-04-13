package com.project.plantmtytree.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.project.plantmtytree.LocationOwner.PlanterDashboard;
import com.project.plantmtytree.R;

public class UserLogin extends AppCompatActivity {


    TextInputLayout Email, Password;
    private static final String TAG = "EmailPassword";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        mAuth = FirebaseAuth.getInstance();

        Email = findViewById(R.id.user_login_email);
        Password = findViewById(R.id.user_login_password);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    public void letTheUserLoggedIn(View view) {
        String xemail = Email.getEditText().getText().toString();
        String xpassword = Password.getEditText().getText().toString();

        mAuth.signInWithEmailAndPassword(xemail, xpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), UserDashboard.class));

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    public void callSignUpFromLogin(View view) {
        startActivity(new Intent(getApplicationContext(), UserSignup.class));
        finish();
    }

    private void reload() {
        Toast.makeText(getApplicationContext(), "User Already Logged IN",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();

    }

    public void callDashboard(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }
}