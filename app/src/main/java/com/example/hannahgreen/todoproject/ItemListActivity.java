package com.example.hannahgreen.todoproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        ItemList itemList = new ItemList();
        ArrayList<Item> list = itemList.getList();

        ItemListAdapter itemAdapter = new ItemListAdapter(this, list);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemAdapter);
    }

    public void onListItemClick(View listItem) {
        Item item = (Item) listItem.getTag();

        Intent intent = new Intent(this, ItemDetailsActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);

    }

    public void onCompletedButtonClick(View listItem) {
        Item item = (Item) listItem.getTag();

        Intent intent = new Intent(this, CompltedActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);

    }

    public void onAddButtonClick(View listItem) {
        Item item = (Item) listItem.getTag();

        Intent intent = new Intent(this, AddItemActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);

    }

}
