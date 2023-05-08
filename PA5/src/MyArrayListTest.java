import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void size() {
        MyArrayList<Integer> list = new MyArrayList<>(5);
        assertEquals(0, list.size());
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());
    }

    @Test
    void add() {
        MyArrayList<Integer> list = new MyArrayList<>(4);
        list.add(0, 5);
        assertEquals("[5]", list.toString());
        list.add(0, 3);
        assertEquals("[3 -> 5]", list.toString());
        list.add(2, 7);
        assertEquals("[3 -> 5 -> 7]", list.toString());
        list.add(2, 4);
        assertEquals("[3 -> 5 -> 4 -> 7]", list.toString());
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(18, 3));
        assertThrows(NullPointerException.class, () -> list.add(0, null));


    }

    @Test
    void get() {
        MyArrayList<Integer> list = new MyArrayList<>(20);
        list.add(0, 2);
        list.add(1, 45);
        list.add(2, 15);
        assertEquals(2, list.get(0));
        assertEquals(45, list.get(1));
        assertEquals(15, list.get(2));

        MyArrayList<Integer> list2 = new MyArrayList<>(3);
        list2.add(0, 2);
        list2.add(1, 45);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list2.get(2);
        });
    }

    @Test
    void contains() {
        MyArrayList<Integer> list = new MyArrayList<>(3);
        list.add(2);
        list.add(3);
        list.add(4);
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(3));
        assertFalse(list.contains(1));
    }

    @Test
    void testToString() {
        MyArrayList<Integer> list1 = new MyArrayList<>(3);
        assertEquals("[ ]", list1.toString());

        MyArrayList<String> list2 = new MyArrayList<>(2);
        list2.add("Hello");
        list2.add("World");
        assertEquals("[Hello -> World]", list2.toString());

        MyArrayList<Double> list3 = new MyArrayList<>(1);
        list3.add(3.1415);
        assertEquals("[3.1415]", list3.toString());
        assertEquals("[ ]", list1.toString());
    }
}