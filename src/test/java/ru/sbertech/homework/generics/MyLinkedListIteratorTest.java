package ru.sbertech.homework.generics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MyLinkedListIteratorTest {

    private Iterator<String> iterator;
    private MyLinkedList<String> myLinkedList;

    @Before
    public void init() {
        myLinkedList = new MyLinkedList<String>();
        iterator = null;
    }

    @Test
    public void hashNextTest(){
        assertEquals(false, myLinkedList.iterator().hasNext());
    }

    @Test
    public void hashNextOneElementTest(){
        myLinkedList.add("first element");
        iterator = myLinkedList.iterator();
        assertEquals(true, iterator.hasNext());
        assertNotNull(iterator.next());
        assertEquals(false, iterator.hasNext());
    }

    @Test (expected = NoSuchElementException.class)
    public void nextTest() {
        myLinkedList.iterator().next();
    }

    @Test
    public void removeTest(){
        myLinkedList.add("first element");
        myLinkedList.remove(0);
        assertEquals(false, myLinkedList.iterator().hasNext());
    }

    @Test
    public void elementsTest() {
        myLinkedList.add("first element");
        myLinkedList.add("second element");
        myLinkedList.add("third element");
        iterator = myLinkedList.iterator();
        int j=0;
        String s;
        while (j < myLinkedList.size()) {
            s = iterator.next();
            assertEquals(myLinkedList.get(j), s);
            j++;
        }
    }
}

