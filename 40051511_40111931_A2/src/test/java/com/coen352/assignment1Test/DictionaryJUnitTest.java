package com.coen352.assignment1Test;

import com.coen352.assignment1.ADTDictionary;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class DictionaryJUnitTest {

    private static ADTDictionary<Integer, String> dict;

    @BeforeAll
    public static void setUp() {
        //dict = new DLLDictionary<Integer, String>();
        //dict = new SLLDictionary<Integer, String>();
        //dict = new ALDictionary<Integer, String>(10);

    }

    @Test
    void testClear() {
        dict.clear();
        assertEquals(0, dict.size(), "clear failed, size is non zero");
    }

    @Test
    void testInsert() {
        dict.clear();
        dict.insert(0, "red");
        dict.insert(1, "blue");
        dict.insert(2, "yellow");
        dict.insert(3, "grey");
        assertEquals(4, dict.size(), "insert failed, size is not as expected");
    }

    @Test
    void testRemove() {

        dict.clear();
        dict.insert(0, "red");
        dict.insert(1, "blue");
        dict.insert(2, "yellow");
        dict.insert(3, "grey");

        dict.remove(3);
        assertNotEquals("grey", dict.find(3), "remove failed");

    }

    @Test
    void testRemoveAny() {
        dict.clear();
        dict.insert(0, "red");
        dict.insert(1, "blue");
        dict.insert(2, "yellow");
        dict.insert(3, "grey");
        assertEquals("grey", dict.removeAny(), "removeAny failed");
    }

    @Test
    void testFind() {
        dict.clear();
        dict.insert(0, "red");
        dict.insert(1, "blue");
        dict.insert(2, "yellow");
        dict.insert(3, "grey");

        assertEquals("grey", dict.find(3), "find failed");
    }

    @Test
    void testSize() {
        dict.clear();
        dict.insert(0, "red");

        assertEquals(1, dict.size(), "size failed, size is not as expected");
    }

}
