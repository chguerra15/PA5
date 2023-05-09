public class MyStack<T> implements MyStackInterface<T> {
    public DoublyLinkedList<T> stack;

    public MyStack() {
        stack = new DoublyLinkedList<>();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        stack.add(data);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T removedData = stack.get(stack.size() - 1);
        stack.remove(removedData);
        return removedData;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return stack.get(stack.size() - 1);
    }
}

