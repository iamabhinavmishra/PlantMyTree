package com.project.plantmtytree.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.project.plantmtytree.LocationOwner.PlanterDashboard;
import com.project.plantmtytree.R;
import com.project.plantmtytree.User.UserDashboard;

public class Signup<mAuth> extends AppCompatActivity {

    //Variables
    ImageView backBtn;
    Button next, login;
    TextView titleText;
    TextInputLayout regfullName, regEmail, regPhoneNo, regPassword;
    CountryCodePicker countryCodePicker;
    FirebaseDatabase rootNode;
    DatabaseReference reference;




    private static final String TAG = "EmailPassword";
    // [START declare_auth]
    private FirebaseAuth mAuth;

    // [END declare_auth]


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planter_signup);
        mAuth = FirebaseAuth.getInstance();


        //Hooks for animation
        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);


        //Hooks For data
        regfullName = findViewById(R.id.signup_fullname);
        regEmail = findViewById(R.id.signup_email);
        regPassword = findViewById(R.id.signup_password);
        countryCodePicker = findViewById(R.id.country_code_picker);
        regPhoneNo= findViewById(R.id.signup_phone_number);







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

    public void callPlanterDashboard(View view) {
        if (!validateFullName()  | !validateEmail() | !validatePassword() | !validatePhoneNumber()) {
            return;
        }


       createAccount();






    }

    private void createAccount() {
        String xemail = regEmail.getEditText().getText().toString();
        String xpassword = regPassword.getEditText().getText().toString();

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
                            storeNewUsersData();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }



    private void storeNewUsersData() {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Planters");

        String fullName = regfullName.getEditText().getText().toString();
        String email = regEmail.getEditText().getText().toString();
        String phoneNo = regPhoneNo.getEditText().getText().toString();
        String password = regPassword.getEditText().getText().toString();

        //Create helperclass reference and store data using firebase
        PlanterHelperClass addNewUser = new PlanterHelperClass(fullName, email, phoneNo, password);
        reference.child(phoneNo).setValue(addNewUser);



        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
        finish();

    }

    private boolean validateFullName() {
        String val = regfullName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            regfullName.setError("Field can not be empty");
            return false;
        } else {
            regfullName.setError(null);
            regfullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            regEmail.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            regEmail.setError("Invalid Email!");
            return false;
        } else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = regPassword.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            regPassword.setError("Field can not be empty");
            return false;

        } else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }


    public void callLoginFromSignUp(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    private boolean validatePhoneNumber() {
        String val = regPhoneNo.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            regPhoneNo.setError("Enter valid phone number");
            return false;

        } else {
            regPhoneNo.setError(null);
            regPhoneNo.setErrorEnabled(false);
            return true;
        }
    }


    public void callDashboard(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }

    private void reload() {
        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
        finish();

    }


}