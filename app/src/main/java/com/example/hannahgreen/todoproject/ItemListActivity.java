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
import java.util.List;

public class ItemListActivity extends AppCompatActivity {
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        listView = (ListView) findViewById(R.id.list);
        Log.d("onCreate: ", "itemList activity");

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Item> items = App.get().getDB().itemDao().getAll();
                populateListView(items);
            }
        }).start();
    }

    private void populateListView(final List<Item> items){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ItemListAdapter itemAdapter = new ItemListAdapter(getBaseContext(), items);
                listView.setAdapter(itemAdapter);
            }
        });
    }

    public void onListItemClick(View listItem) {
        Item item = (Item) listItem.getTag();

        Intent intent = new Intent(this, AddItemActivity.class);
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
