package com.example.hannahgreen.todoproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }


    public void onSaveButtonClick(View listItem) {
        Item item = (Item) listItem.getTag();

        Intent intent = new Intent(this, ItemListActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);

    }
}
