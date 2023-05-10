/**
 * Implementation of a stack using a DoublyLinkedList.
 * @param <T> the type of elements in the stack
 */
public class MyStack<T> implements MyStackInterface<T> {

    /**
     * The underlying DoublyLinkedList that stores the elements in the stack.
     */
    public DoublyLinkedList<T> stack;

    /**
     * Constructs a new, empty stack.
     */
    public MyStack() {
        stack = new DoublyLinkedList<>();
    }

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack
     */
    public int size() {
        return stack.size();
    }

    /**
     * Checks if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Pushes an element onto the top of the stack.
     * @param data the element to be pushed onto the stack
     * @throws IllegalArgumentException if the given element is null
     */
    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        stack.add(data);
    }

    /**
     * Removes and returns the element at the top of the stack.
     * @return the element at the top of the stack, or null if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T removedData = stack.get(stack.size() - 1);
        stack.remove(removedData);
        return removedData;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * @return the element at the top of the stack, or null if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }
}
