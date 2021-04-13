package com.project.plantmtytree.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.plantmtytree.Databases.OrderHelperClass;
import com.project.plantmtytree.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlantMango extends AppCompatActivity {
    TextInputLayout OddName, OddPhone;
    private FirebaseAuth mAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String OddEventName, OddPlantName, OddPlantPrice, OddOrderId, OddEventId;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_mango);
        mAuth = FirebaseAuth.getInstance();


        
        OddName = findViewById(R.id.user_name);
        OddPhone = findViewById(R.id.user_phone);
        OddEventName = "Direct";
        OddEventId = "Null";
        OddPlantName = "Banayan Tree";
        OddPlantPrice = "500";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String currentDateandTime = sdf.format(new Date());
        String xphone = OddPhone.getEditText().getText().toString();

        OddOrderId = currentDateandTime+xphone;



        
    }



    public void callBackScreen(View view) {
        startActivity(new Intent(getApplicationContext(), PlantTree.class));
        finish();
    }

    public void letTheUserPlaceOrder(View view) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            saveData();
        }else{
            Toast.makeText(getApplicationContext(), "Please Login to Continue.",
                    Toast.LENGTH_SHORT).show();
            callLogin();
        }
    }

    private void saveData() {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Orders");

        String OrderId = OddOrderId;
        String EventId = OddEventId;
        String EventName = OddEventName;
        String PlantName = OddPlantName;
        String PlantPrice = OddPlantPrice;
        String Name = OddName.getEditText().getText().toString();
        String Phone = OddPhone.getEditText().getText().toString();



        OrderHelperClass addNewOrder = new OrderHelperClass(OrderId,EventId,EventName,PlantName,PlantPrice,Name,Phone);
        reference.child(OrderId).setValue(addNewOrder);


        Toast.makeText(getApplicationContext(), "Order Placed.",
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), OrderSuccess.class));
        finish();


    }

    private void callLogin() {
        startActivity(new Intent(getApplicationContext(), UserLogin.class));
        finish();
    }

    public void letTheUserCancel(View view) {
        startActivity(new Intent(getApplicationContext(), PlantTree.class));
        finish();
    }
}