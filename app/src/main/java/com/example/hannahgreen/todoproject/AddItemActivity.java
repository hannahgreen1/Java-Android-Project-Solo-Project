package com.example.hannahgreen.todoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    EditText titleEditText;
    EditText notesEditText;
    Button saveButton;
    Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        this.titleEditText = findViewById(R.id.titleEditText);
        this.notesEditText = findViewById(R.id.notesEditText);
        this.saveButton = findViewById(R.id.saveButton);
//        this.cancelButton = findViewById(R.id.);
    }


    public void onSaveButtonClick(View listItem) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String title = titleEditText.getText().toString();
                String notes = notesEditText.getText().toString();
                Item newItem = new Item(title, notes);
                Log.d(this.getClass().toString(), "Adding new item: " + newItem.getTitle());
                App.get().getDB().itemDao().insert(newItem);
                goBackToList();
            }
        }).start();
    }

    private void goBackToList() {
        Intent intent = new Intent(AddItemActivity.this, ItemListActivity.class);
        startActivity(intent);
    }

    public void onCancelButtonClick(View view) {
        this.goBackToList();
    }
}
