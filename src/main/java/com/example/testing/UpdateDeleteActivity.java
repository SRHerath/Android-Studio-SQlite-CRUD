package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testing.Sql.DatabaseHelper;
import com.example.testing.Sql.ItemModel;

public class UpdateDeleteActivity extends AppCompatActivity {

    private ItemModel userModel;
    private EditText etcode, etdes, etqua;
    private Button btnupdate, btndelete;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        Intent intent = getIntent();
        userModel = (ItemModel) intent.getSerializableExtra("user");

        databaseHelper = new DatabaseHelper(this);

        etcode = (EditText) findViewById(R.id.etcode);
        etdes = (EditText) findViewById(R.id.etdes);
        etqua = (EditText) findViewById(R.id.etqua);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);

        etcode.setText(userModel.getItemCode());
        etdes.setText(userModel.getItemDes());
        etqua.setText(userModel.getItemQuan());

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateDetails(userModel.getId(),etcode.getText().toString(),etdes.getText().toString(),etqua.getText().toString());
                Toast.makeText(UpdateDeleteActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDeleteActivity.this,Dashboard.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteDetails(userModel.getId());
                Toast.makeText(UpdateDeleteActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDeleteActivity.this,Dashboard.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}