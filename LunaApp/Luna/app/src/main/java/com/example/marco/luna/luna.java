package com.example.marco.luna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.marco.luna.Controller.Database;

public class luna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luna);
    }

    public void home(View view) {
        startActivity(new Intent(this, Tabbs.class));
    }

}
