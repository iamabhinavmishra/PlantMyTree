package com.project.plantmtytree.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.plantmtytree.R;

public class PlantTree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_tree);
    }

    public void callBackScreenFromMakeSelection(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }

    public void callMango(View view) {
        startActivity(new Intent(getApplicationContext(), PlantMango.class));
        finish();
    }

    public void callNeem(View view) {
        startActivity(new Intent(getApplicationContext(), PlantNeem.class));
        finish();
    }


    public void callPeepal(View view) {
        startActivity(new Intent(getApplicationContext(), PlantPeepal.class));
        finish();
    }

    public void callArjuna(View view) {
        startActivity(new Intent(getApplicationContext(), PlantArjuna.class));
        finish();
    }



    public void callSal(View view) {
        startActivity(new Intent(getApplicationContext(), PlantSal.class));
        finish();
    }

    public void callHome(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }
}