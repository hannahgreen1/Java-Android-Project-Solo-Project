package com.example.hannahgreen.todoproject;

import java.util.ArrayList;

public class ItemList {

    private ArrayList<Item> list;

    public ItemList(){
        list = new ArrayList<Item>();
        list.add(new Item("Plan trip", "book flights, and hotel"));
        list.add(new Item("Research things to do", "look up the popular tourist attractions in the area"));
    }

    public ArrayList<Item> getList() {
        return new ArrayList<Item>(list);
    }

}
