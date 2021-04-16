package com.project.plantmtytree.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.plantmtytree.Common.LoginSignup.ForgetPasswordSuccessMessage;
import com.project.plantmtytree.Databases.EventHandlerClass;
import com.project.plantmtytree.Databases.LocationHelperClass;
import com.project.plantmtytree.Databases.PlanterHelperClass;
import com.project.plantmtytree.R;

public class UpdateLocation extends AppCompatActivity {
    TextInputLayout regOrderId, regPlantId, regAddress1, regAddress2, regAddress3, regPinCode, regUpdatedBy;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_location);

        //data hooks
        regOrderId = findViewById(R.id.loc_ordr_id);
        regPlantId = findViewById(R.id.loc_plantid);
        regAddress1 = findViewById(R.id.loc_add1);
        regAddress2 = findViewById(R.id.loc_add2);
        regAddress3 = findViewById(R.id.loc_add3);
        regPinCode = findViewById(R.id.loc_pin_code);
        regUpdatedBy = findViewById(R.id.loc_updated_by);
    }

    public void callDashboard(View view) {
        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
        finish();
    }

    public void updateLocation(View view) {

        storeUpdatedData();
    }

    private void storeUpdatedData() {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Locations");


        String OrderId = regOrderId.getEditText().getText().toString();
        String PlantId = regPlantId.getEditText().getText().toString();
        String Address1 = regAddress1.getEditText().getText().toString();
        String Address2 = regAddress2.getEditText().getText().toString();
        String Address3 = regAddress3.getEditText().getText().toString();
        String PinCode = regPinCode.getEditText().getText().toString();
        String UpdatedBy = regUpdatedBy.getEditText().getText().toString();

        LocationHelperClass addLocation = new LocationHelperClass(OrderId,PlantId,Address1,Address2,Address3,PinCode,UpdatedBy);
        reference.child(OrderId).setValue(addLocation);

        startActivity(new Intent(getApplicationContext(), ForgetPasswordSuccessMessage.class));
        finish();


    }

    public void cancelLocation(View view) {
        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
        finish();
    }
}