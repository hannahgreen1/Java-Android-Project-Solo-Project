package com.example.hannahgreen.todoproject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemListTest {

    @Test
    public void getListTest() {
        ItemList itemList = new ItemList ();
        assertEquals(2, itemList.getList().size());
    }

    @Test
    public void canGetListSize(){
        ItemList itemList = new ItemList();
        assertEquals(2, itemList.listSize());
    }

    @Test
    public void canAddToList(){
        ItemList itemList = new ItemList();
        itemList.addToList(new Item("meet friend", "meet at 3"));
       assertEquals(3, itemList.listSize());
    }

    @Test
    public void canRemoveFromList(){
        ItemList itemList = new ItemList();
        itemList.addToList(new Item("go shopping", "need food"));
        itemList.removeItem();
        assertEquals(2, itemList.listSize());
    }

}
