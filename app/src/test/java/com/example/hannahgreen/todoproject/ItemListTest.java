package com.example.hannahgreen.todoproject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemListTest {

    @Test
    public void getListTest() {
        ItemList itemList = new ItemList ();
        assertEquals(2, itemList.getList().size());
    }
}
