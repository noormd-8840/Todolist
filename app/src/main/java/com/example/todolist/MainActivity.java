package com.example.todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText item;
    Button add;
    ListView listView;
    ArrayList<String> itemList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        item = findViewById(R.id.editText);
        add = findViewById(R.id.button);
        listView = findViewById(R.id.list);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemName = item.getText().toString();
                itemList.add(itemName);
                item.setText("");
                fileHelper.writeData(itemList, getApplicationContext());
                arrayAdapter.notifyDataSetChanged();
            }
        });

        itemList = fileHelper.readData(this);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_2, android.R.id.text1, itemList);

        listView.setAdapter(arrayAdapter);

    }

}