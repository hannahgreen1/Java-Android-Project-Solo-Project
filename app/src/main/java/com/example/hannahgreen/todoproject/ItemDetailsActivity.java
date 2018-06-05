package com.example.hannahgreen.todoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemDetailsActivity extends AppCompatActivity {
    EditText titleEditText;
    EditText notesEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        this.titleEditText = findViewById(R.id.titleEditText);
        this.notesEditText = findViewById(R.id.notesEditText);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String title = titleEditText.getText().toString();
                String notes = notesEditText.getText().toString();
                Item newItem = new Item(title, notes);
                Log.d(this.getClass().toString(), "Adding new item: " + newItem.getTitle());
                App.get().getDB().itemDao().update(newItem);
//                Toast.makeText(AddItemActivity.this, R.string.add_item_save, Toast.LENGTH_SHORT).show();
                goBackToList();
            }
        }).start();

    }


    private void goBackToList() {
        Intent intent = new Intent(ItemDetailsActivity.this, ItemListActivity.class);
        startActivity(intent);
    }
}
