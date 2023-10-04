package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testing.Sql.DatabaseHelper;

public class AddMaterials extends AppCompatActivity {

    EditText MatCode,MatDesc,MatQuantity;

    DatabaseHelper dbHelper1;
    Button btnStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materials);

        dbHelper1 = new DatabaseHelper(this);

        MatCode = (EditText) findViewById(R.id.mat_code);
        MatDesc = (EditText) findViewById(R.id.mat_des);
        MatQuantity = (EditText) findViewById(R.id.mat_quan);

        btnStore = (Button) findViewById(R.id.Store);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper1.addDetail(MatCode.getText().toString(), MatDesc.getText().toString(),MatQuantity.getText().toString());
                MatCode.setText("");
                MatDesc.setText("");
                MatQuantity.setText("");
                Toast.makeText(AddMaterials.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(AddMaterials.this,Dashboard.class);
                startActivity(i);
            }
        });
    }
}