package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button Add,View;
    Toolbar toolbar;
    @Override
    public void onBackPressed() {
        Dashboard.this.finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        toolbar = (Toolbar) findViewById(R.id.tool_main);

        Add =(Button) findViewById(R.id.btnAdd);
        Add.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,AddMaterials.class);
                startActivity(intent);
            }
        });
        View = findViewById(R.id.btnget);
        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this,GetAllItemsActivity.class);
                startActivity(intent);
            }
        });


    }
}