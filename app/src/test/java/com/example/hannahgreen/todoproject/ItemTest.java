package com.example.hannahgreen.todoproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    Item item;

    @Before
    public void before(){
        item = new Item(1, "Go Shopping", "Buy milk, bread, chicken.", false);
    }

    @Test
    public void canGetTitle(){
        assertEquals("Go Shopping", item.getTitle());
    }

    @Test
    public void canGetNotes(){
        assertEquals("Buy milk, bread, chicken.", item.getNotes());
    }

    @Test
    public void canSetTitle(){
        assertEquals("Pay bills", item.setTitle("Pay bills"));
    }

    @Test
    public void canSetNotes(){
        assertEquals("pay the window cleaner, and pay tax", item.setNotes("pay the window cleaner, and pay tax"));
    }

    @Test
    public void canGetCompleted(){
        item.itemCompleted();
        assertEquals(true, item.itemCompleted());
    }

    @Test
    public void canGetId(){
        assertEquals(1, item.getId());
    }

}
