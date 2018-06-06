package com.example.hannahgreen.todoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

public class CompltedActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complted);

        listView = (ListView) findViewById(R.id.completedList);
        Log.d("onCreate: ", "itemList activity");

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Item> items = App.get().getDB().itemDao().getByCompleted();
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
}
