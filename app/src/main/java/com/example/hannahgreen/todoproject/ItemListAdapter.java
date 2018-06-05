package com.example.hannahgreen.todoproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ItemListAdapter extends ArrayAdapter<Item> {


    public ItemListAdapter(Context context, List<Item> movies)
    {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_activity, parent, false);
        }

        Item currentItem = getItem(position);

        TextView title = (TextView) listItemView.findViewById(R.id.item_title);
        title.setText(currentItem.getTitle().toString());


        listItemView.setTag(currentItem);

        return listItemView;

    }
}
