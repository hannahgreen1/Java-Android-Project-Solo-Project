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
        itemList.addToList(new Item(1,"meet friend", "meet at 3", false));
       assertEquals(3, itemList.listSize());
    }

    @Test
    public void canRemoveFromList(){
        ItemList itemList = new ItemList();
        itemList.addToList(new Item(1, "go shopping", "need food", false));
        itemList.removeItem();
        assertEquals(2, itemList.listSize());
    }

//    @Test
//    public void canEditItemInList(){
//        ItemList itemList = new ItemList();
//        Item item = new Item("help", "help");
//        itemList.editItem(item);
//        assertEquals();
//    }



}

