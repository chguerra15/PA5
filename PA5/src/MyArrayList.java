/*
 * NAME: TODO Christian Guerra
 * PID: TODO A17660168
 */

import java.util.AbstractList;


/**
 * ArrayList Implementation
 *
 * @author TODO
 * @since TODO
 */
public class MyArrayList<T> extends AbstractList<T> {

    private int nelems;
    private T  [ ] arrList;

    /**
     * TODO
     */
    public MyArrayList() {

        arrList = (T[]) new Object[0];

    }

    public MyArrayList(int capacity) {

        arrList = (T[]) new Object[capacity];
    }

    /**
     * Retrieves the amount of elements that are currently in the ArrayList.
     *
     * @return Number of elements currently in the ArrayList
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * Adds an element to a certain index in the list, shifting existing elements
     * to create space. Does not accept null values.
     *
     * @param index Where in the list to add the element.
     * @param data  Data to be added.
     * @throws IndexOutOfBoundsException if index received is out of bounds for
     *                                   the current list.
     * @throws NullPointerException      if data received is null.
     */
    @Override
    public void add(int index, T data)
            throws IndexOutOfBoundsException, NullPointerException {
        if (data == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (size() == arrList.length) {
            T[] temp = (T[]) new Object[2 * arrList.length];
            System.arraycopy(arrList, 0, temp, 0, arrList.length);
            arrList = temp;
        }
        for (int i = size() - 1; i >= index; i--) {
            arrList[i + 1] = arrList[i];
        }
        arrList[index] = data;
        nelems++;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * @param index The index of the desired element.
     * @return Returns the data contained at the specified index.
     * @throws IndexOutOfBoundsException if index received is out of bounds for
     *                                   the current list.
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= nelems) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        return arrList[index];
    }


    /**
     * Determine if this list contains the given data
     * @param data data to find
     * @return true if list contains given data, false otherwise
     */
    public boolean contains(Object data) {
        if (data == null) {
            return false;
        }
        for (int i = 0; i < nelems; i++) {
            if (data.equals(arrList[i])) {
                return true;
            }
        }
        return false;
    }


    /**
     * String representation of this list in the form of:
     * "[2 -> 45 -> 15 -> 9 -> 1]"
     * @return string representation
     */
    @Override
    public String toString() {
        if (size() == 0) {
            return "[ ]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size() - 1; i++) {
            sb.append(arrList[i]);
            sb.append(" -> ");
        }
        sb.append(arrList[size() - 1]);
        sb.append("]");
        return sb.toString();
    }


}



