public class MyStack<T> implements MyStackInterface<T>{
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
        stack.set(0, data);
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(0);
    }

    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.get(0);
    }
}
