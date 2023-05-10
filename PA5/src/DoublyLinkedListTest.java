import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Test
    void add() {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        list.add('A');
        list.add('B');
        assertEquals('A', list.get(0));
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
        list2.add(1);
        list2.add(2);
        assertEquals(2, list2.get(1));
        assertThrows(NullPointerException.class, () -> {
            list2.add(1, null);
            list2.add(1, null);
            list2.add(1, null);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(3);
            list2.get(5);
            list2.get(-1);
        });

    }

    @Test
    void testAdd() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add(1, "grape");
        assertEquals("apple", list.get(0));
        assertEquals("grape", list.get(1));
        assertEquals("banana", list.get(2));
        assertEquals("orange", list.get(3));
        assertEquals(4, list.size());
        assertThrows(NullPointerException.class, () -> {
            list.add(1, null);
            list.add(1, null);
            list.add(1, null);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(3);
            list.get(5);
            list.get(-1);
        });
    }

    @Test
    void clear() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("apple");
        list.add("banana");
        list.clear();
        assertTrue(list.isEmpty());
        DoublyLinkedList<String> list2 = new DoublyLinkedList<>();
        list2.add("Chris");
        list2.add("Julia");
        list2.clear();
        assertTrue(list2.isEmpty());
        DoublyLinkedList<String> list3 = new DoublyLinkedList<>();
        list3.add("apple");
        list3.add("banana");
        assertFalse(list3.isEmpty());
    }

    @Test
    void contains() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("apple");
        assertTrue(list.contains("apple"));
        assertFalse(list.contains("papaya"));
        list.add("orange");
        assertEquals("orange", list.get(1));
    }


    @Test
    void get() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("papaya");
        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
        assertEquals("papaya", list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(6));
    }

    @Test
    void isEmpty() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());
        list.add("apple");
        assertFalse(list.isEmpty());
        list.remove("apple");
        assertTrue(list.isEmpty());
        DoublyLinkedList<String> list2 = new DoublyLinkedList<>();
        assertTrue(list2.isEmpty());
        list2.add("orange");
        assertFalse(list2.isEmpty());
        list2.remove("orange");
        assertTrue(list2.isEmpty());
    }

    @Test
    void remove() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.remove(1);
        assertEquals("apple", list.get(0));
        assertEquals("orange", list.get(1));
        assertEquals(2, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(6));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(7));

    }

    @Test
    void set() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("apple");
        list.add("banana");
        String oldData = list.set(1, "orange");
        assertEquals("banana", oldData);
        assertEquals("apple", list.get(0));
        assertEquals("orange", list.get(1));
        assertEquals(2, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, "hry"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(5, "jg"));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(6, "jg"));
    }

    @Test
    void size() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        assertEquals(0, list.size());
        list.add("apple");
        assertEquals(1, list.size());
        list.add("banana");
        assertEquals(2, list.size());
        list.add("papaya");
        assertEquals(3, list.size());
    }

    @Test
    void testToString() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertEquals("[(head) -> (tail)]", list.toString());
        DoublyLinkedList<String> list2 = new DoublyLinkedList<>();
        list2.add("apple");
        assertEquals("[(head) -> apple -> (tail)]", list2.toString());
        DoublyLinkedList<Character> list3 = new DoublyLinkedList<>();
        list3.add('C');
        list3.add('H');
        list3.add('R');
        list3.add('I');
        list3.add('S');
        assertEquals("[(head) -> C -> H -> R -> I -> S -> (tail)]", list3.toString());

    }

    @Test
    void testClear(){
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        list.add('C');
        list.add('H');
        list.add('R');
        list.add('I');
        list.add('S');
        assertTrue(list.size() != 0);
        list.clear();
        assertTrue(list.size() == 0);
        DoublyLinkedList<String> list2 = new DoublyLinkedList<>();
        list2.add("apple");
        assertEquals("apple", list2.get(0));
        list2.clear();
        assertEquals(0, list.size());


    }

    @Test
    public void testRemoveMultipleOf() {
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.removeMultipleOf(3);
        System.out.println(list);
        DoublyLinkedList list2 = new DoublyLinkedList();
        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        list2.removeMultipleOf(1);
        System.out.println(list2);


    }

    @Test
    public void testSwapSegment() {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        list1.swapSegment(list2, 2);
        assertEquals("[(head) -> 0 -> 1 -> 7 -> 8 -> 9 -> (tail)]", list1.toString());
        assertEquals("[(head) -> 5 -> 6 -> 2 -> 3 -> 4 -> (tail)]", list2.toString());
        list1.swapSegment(list2, 2);
        assertEquals("[(head) -> 5 -> 6 -> 2 -> 3 -> 4 -> (tail)]", list1.toString());
        assertEquals("[(head) -> 0 -> 1 -> 7 -> 8 -> 9 -> (tail)]", list2.toString());
    }


}





