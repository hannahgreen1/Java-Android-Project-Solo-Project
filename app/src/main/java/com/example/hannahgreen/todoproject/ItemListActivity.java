package com.example.hannahgreen.todoproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        Log.d("Item Title: ", item.getTitle());

        Intent intent = new Intent(this, ItemDetailsActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);

    }
}
