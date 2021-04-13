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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;
import com.project.plantmtytree.Databases.PlanterHelperClass;
import com.project.plantmtytree.Databases.UserHelperClass;
import com.project.plantmtytree.LocationOwner.PlanterDashboard;
import com.project.plantmtytree.R;

public class UserSignup extends AppCompatActivity {

    TextInputLayout regUserfullName, regUserEmail, regUserPhoneNo, regUserPassword;
    CountryCodePicker UsercountryCodePicker;
    FirebaseDatabase rootNode;
    DatabaseReference reference;




    private static final String TAG = "EmailPassword";
    // [START declare_auth]
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
        //hooks
        mAuth = FirebaseAuth.getInstance();
        //Hooks For data
        regUserfullName = findViewById(R.id.user_signup_fullname);
        regUserEmail = findViewById(R.id.user_signup_email);
        regUserPassword = findViewById(R.id.user_signup_password);
        UsercountryCodePicker = findViewById(R.id.user_country_code_picker);
        regUserPhoneNo= findViewById(R.id.user_signup_phone_number);

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

    public void callUserDashboard(View view) {
        if (!validateFullName()  | !validateEmail() | !validatePassword() | !validatePhoneNumber()) {
            return;
        }


        createUserAccount();
    }

    private void createUserAccount() {
        String xemail = regUserEmail.getEditText().getText().toString();
        String xpassword = regUserPassword.getEditText().getText().toString();

        mAuth.createUserWithEmailAndPassword(xemail, xpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(), "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                            storeNewUserData();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    private void storeNewUserData() {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Users");

        String fullName = regUserfullName.getEditText().getText().toString();
        String email = regUserEmail.getEditText().getText().toString();
        String phoneNo = regUserPhoneNo.getEditText().getText().toString();
        String password = regUserPassword.getEditText().getText().toString();

        //Create helperclass reference and store data using firebase
        UserHelperClass addNewUser = new UserHelperClass(fullName, email, phoneNo, password);
        reference.child(phoneNo).setValue(addNewUser);



        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }


    public void callLoginFromSignUp(View view) {
        startActivity(new Intent(getApplicationContext(), UserLogin.class));
        finish();
    }

    public void callDashboard(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }

    private boolean validateFullName() {
        String val = regUserfullName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            regUserfullName.setError("Field can not be empty");
            return false;
        } else {
            regUserfullName.setError(null);
            regUserfullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = regUserEmail.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            regUserEmail.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            regUserEmail.setError("Invalid Email!");
            return false;
        } else {
            regUserEmail.setError(null);
            regUserEmail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = regUserPassword.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            regUserPassword.setError("Field can not be empty");
            return false;

        } else {
            regUserPassword.setError(null);
            regUserPassword.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String val = regUserPhoneNo.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            regUserPhoneNo.setError("Enter valid phone number");
            return false;

        } else {
            regUserPhoneNo.setError(null);
            regUserPhoneNo.setErrorEnabled(false);
            return true;
        }
    }

    private void reload() {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();

    }
}