package com.project.plantmtytree.LocationOwner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.plantmtytree.Databases.EventHandlerClass;
import com.project.plantmtytree.Databases.PlanterHelperClass;
import com.project.plantmtytree.R;

public class AddEvent extends AppCompatActivity {

    TextInputLayout regEventId, regEventName, regEventDesc, regEventLoc, regEventPhone, regHandler;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        //data hooks
        regEventId = findViewById(R.id.event_id);
        regEventName = findViewById(R.id.event_name);
        regEventDesc = findViewById(R.id.event_desc);
        regEventLoc = findViewById(R.id.event_location);
        regEventPhone = findViewById(R.id.event_phoneNo);
        regHandler = findViewById(R.id.event_owner_name);
    }



    public void callEventConfirm(View view) {
        if (!validateEventName()  | !validateEventId() | !validateEventHandler() | !validatePhone() | !validateEventDesc() |!validateEventLoc()) {
            return;
        }

        storeEventData();
    }

    private void storeEventData() {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Events");



        String EventId = regEventId.getEditText().getText().toString();
        String EventName = regEventName.getEditText().getText().toString();
        String EventDesc = regEventDesc.getEditText().getText().toString();
        String EventLocation = regEventLoc.getEditText().getText().toString();
        String EventHandler = regHandler.getEditText().getText().toString();
        String EventPhone = regEventPhone.getEditText().getText().toString();

        EventHandlerClass addEvent = new EventHandlerClass(EventId,EventName,EventDesc,EventLocation,EventHandler,EventPhone);
        reference.child(EventId).setValue(addEvent);



        startActivity(new Intent(getApplicationContext(), EventConfirm.class));
        finish();


    }








    public void callCancelEvent(View view) {
        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
        finish();
    }


    public void callDashboard(View view) {
        startActivity(new Intent(getApplicationContext(), PlanterDashboard.class));
        finish();
    }

    private boolean validateEventName() {
        String val = regEventName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            regEventName.setError("Field can not be empty");
            return false;
        } else {
            regEventName.setError(null);
            regEventName.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateEventId() {
        String val = regEventId.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            regEventId.setError("Field can not be empty");
            return false;
        } else {
            regEventId.setError(null);
            regEventId.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateEventDesc() {
        String val = regEventDesc.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            regEventDesc.setError("Field can not be empty");
            return false;
        } else {
            regEventDesc.setError(null);
            regEventDesc.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateEventHandler() {
        String val = regHandler.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            regHandler.setError("Field can not be empty");
            return false;
        } else {
            regHandler.setError(null);
            regHandler.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validatePhone() {
        String val = regEventPhone.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            regEventPhone.setError("Field can not be empty");
            return false;
        } else {
            regEventPhone.setError(null);
            regEventPhone.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateEventLoc() {
        String val = regEventLoc.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            regEventLoc.setError("Field can not be empty");
            return false;
        } else {
            regEventLoc.setError(null);
            regEventLoc.setErrorEnabled(false);
            return true;
        }
    }



}