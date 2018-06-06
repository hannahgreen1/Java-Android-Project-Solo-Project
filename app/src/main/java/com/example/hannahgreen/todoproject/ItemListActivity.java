package com.example.hannahgreen.todoproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
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

    public void onListItemClick(View textView) {
        View listItem = (View) textView.getParent();

        Item item = (Item) listItem.getTag();

        Intent intent = new Intent(this, AddItemActivity.class);

        intent.putExtra("item", item);
        startActivity(intent);
    }

    public void onCheckBoxClick(View checkBox){
        View listItem = (View) checkBox.getParent();
        final Item item = (Item) listItem.getTag();
        CheckBox boxClicked = (CheckBox)checkBox;
        item.setCompleted(boxClicked.isChecked());
        new Thread(new Runnable() {
            @Override
            public void run() {
                App.get().getDB().itemDao().update(item);
            }
        }).start();

    }

    public void onCompletedButtonClick(View button) {
//        Item item = (Item) listItem.getTag();

        Intent intent = new Intent(this, CompltedActivity.class);
//        intent.putExtra("item", item);
//        item.setCompleted(true);

        startActivity(intent);

    }



    public void onAddButtonClick(View listItem) {
        Item item = (Item) listItem.getTag();

        Intent intent = new Intent(this, AddItemActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);

    }

}
