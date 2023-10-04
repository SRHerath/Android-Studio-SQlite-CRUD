package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.testing.Sql.DatabaseHelper;
import com.example.testing.Sql.ItemModel;

import java.util.ArrayList;

public class GetAllItemsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ItemModel> userModelArrayList;
    private CustomAdapter customAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_items);

        listView = (ListView) findViewById(R.id.lv);

        databaseHelper = new DatabaseHelper(this);

        userModelArrayList = databaseHelper.getAllData();

        customAdapter = new CustomAdapter(this,userModelArrayList);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(GetAllItemsActivity.this,UpdateDeleteActivity.class);
                intent.putExtra("user",userModelArrayList.get(i));
                startActivity(intent);
            }

        });
    }
}