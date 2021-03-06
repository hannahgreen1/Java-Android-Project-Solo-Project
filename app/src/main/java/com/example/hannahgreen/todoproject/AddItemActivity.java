package com.example.hannahgreen.todoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {
    EditText titleEditText;
    EditText notesEditText;
    Button saveButton;
    Button cancelButton;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Intent intent = getIntent();
        item = (Item) intent.getSerializableExtra("item");

        this.titleEditText = findViewById(R.id.titleEditText);
        this.notesEditText = findViewById(R.id.notesEditText);
        this.saveButton = findViewById(R.id.saveButton);
        this.cancelButton = findViewById(R.id.cancelButton);

        if (item != null){
            titleEditText.setText(item.getTitle());
            notesEditText.setText(item.getNotes());
            }

        }




    public void onSaveButtonClick(View listItem) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (item != null)
                {
                    Intent intent = getIntent();
                    Item item = (Item) intent.getSerializableExtra("item");
                    item.setTitle(titleEditText.getText().toString());
                    item.setNotes(notesEditText.getText().toString());

                    Log.d(this.getClass().toString(), "Updating item: " + item.getTitle());
                    App.get().getDB().itemDao().update(item);
                    goBackToList();
                }
                else{
                String title = titleEditText.getText().toString();
                String notes = notesEditText.getText().toString();
                Item newItem = new Item(title, notes);
                Log.d(this.getClass().toString(), "Adding new item: " + newItem.getTitle());
                App.get().getDB().itemDao().insert(newItem);
            }
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

    public void onDeleteButtonClick(View view) {
        Intent intent = getIntent();
        Item item = (Item) intent.getSerializableExtra("item");
        final Item itemToDelete = item;
        new Thread(new Runnable() {
            @Override
            public void run() {
                App.get().getDB().itemDao().delete(itemToDelete);
                goBackToList();
            }
        }).start();
    }

}
