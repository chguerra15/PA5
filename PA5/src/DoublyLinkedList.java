/*
 * NAME: Christian Guerra
 * PID: A17660168
 */

import java.util.AbstractList;

/**
 * Doubly Linked list class replicates Linked List
 * @author Christian Guerra
 * @since May 4th, 2023
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            this.data = element;
            this.next = null;
            this.prev = null;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            this.data = element;
            this.next = nextNode;
            this.prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            this.data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            return data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            if (prev == null) {
                head = next;
            } else {
                prev.next = next;
            }
            if (next == null) {
                tail = prev;
            } else {
                next.prev = prev;
            }
            nelems--;
        }
    }

        /**
         * Creates a new, empty doubly-linked list.
         */
        public DoublyLinkedList() {
            this.head = new Node(null);
            this.tail = new Node(null);
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.nelems = 0;
        }



        /**
         * Add an element to the end of the list
         *
         * @param element data to be added
         * @return whether the element was added
         * @throws NullPointerException if data received is null
         */
        @Override
        public boolean add(T element) throws NullPointerException {
            if (element == null) {
                throw new NullPointerException("Cannot add null element");
            }
            Node newNode = new Node(element);
            Node prevNode = tail.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = tail;
            tail.prev = newNode;
            nelems++;
            return true;
        }


        /**
         *
         *   Inserts a node containing the specified data at the desired location.
         *
         *  * @param index the index at which the specified element is to be inserted
         *  * @param element the data to be inserted into the list
         *  * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size())
         *  * @throws NullPointerException if the specified element is null
         *  */
        @Override
        public void add(int index, T element)
                throws IndexOutOfBoundsException, NullPointerException {
            if (element == null) {
                throw new NullPointerException();
            }
            if (index < 0 || index > nelems) {
                throw new IndexOutOfBoundsException();
            }
            Node newNode = new Node(element);
            Node currNode = getNth(index);
            Node prevNode = currNode.prev;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = currNode;
            currNode.prev = newNode;
            nelems++;
        }

        /**
         * Clear the linked list
         */
        @Override
        public void clear() {
            head.next = tail;
            tail.prev = head;
            nelems = 0;
        }

        /**
         * Determines if the list contains the specified element anywhere in the list.
         * @param element the element to search for in the list
         * @return true if the list contains the element at least once, false otherwise
         * */
        @Override
        public boolean contains(Object element) {
            if (element == null) {
                return false;
            }
            Node curr = head.next;
            while (curr != tail) {
                if (element.equals(curr.data)) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        /**
         * Retrieves the element stored at the given index in the list.
         * @param index the index of the element to be retrieved, must be in the range
         *             [0, size - 1]
         * @return the element at the specified index
         * @throws IndexOutOfBoundsException if the index is out of range
         */
        @Override
        public T get(int index) throws IndexOutOfBoundsException {
            if (index < 0 || index >= nelems) {
                throw new IndexOutOfBoundsException();
            }
            Node current = getNth(index);
            return current.data;
        }

        /**
         * Helper method to retrieve the Nth node in the list.
         * @param index the index of the node to retrieve.
         * @return the Nth node in the list.
         * @throws IndexOutOfBoundsException if the index is less than 0 or greater
         * than or equal to the size of the list.
         */
        private Node getNth(int index) {
            if (index < 0 || index >= nelems) {
                throw new IndexOutOfBoundsException("Index is out of range.");
            }
            Node current = head.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }

        /**
         * Returns true if the list contains no elements, false otherwise.
         * @return true if the list is empty, false otherwise
         */
        @Override
        public boolean isEmpty() {
            return nelems == 0;
        }



        /**
         * Removes the element at the specified position in this list.
         * <p>
         * @param index the index of the element to be removed
         * @return the element that was removed from the list
         * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
         */
        @Override
        public T remove(int index) throws IndexOutOfBoundsException {
            if (index < 0 || index >= nelems) {
                throw new IndexOutOfBoundsException("Index is out of range.");
            }

            Node nodeToRemove = getNth(index);
            T dataToRemove = nodeToRemove.data;

            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
            nodeToRemove.prev = null;
            nodeToRemove.next = null;

            nelems--;
            return dataToRemove;
        }

        /**
         * Set the value of an element at a certain index in the list.
         * <p>
         * TODO: javadoc comments
         */
        @Override
        public T set(int index, T element)
                throws IndexOutOfBoundsException, NullPointerException {
            if (element == null) {
                throw new NullPointerException();
            }
            if (index < 0 || index >= nelems) {
                throw new IndexOutOfBoundsException();
            }
            Node current = head.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            T oldData = current.data;
            current.data = element;
            return oldData;
        }

        /**
         * Retrieves the amount of elements that are currently on the list.
         * <p>
         * @return number of elements
         */
        @Override
        public int size() {
            return nelems;
        }

        /**
         * Returns a string representation of this list in the form of:
         * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]".
         * The returned string includes the head and tail sentinel nodes, but not their stored data.
         * @return a string representation of this list
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[(head) -> ");
            Node curr = head.next;
            while (curr != tail) {
                if (curr.data == null) {
                    sb.append("null");
                } else {
                    sb.append(curr.data.toString());
                }
                sb.append(" -> ");
                curr = curr.next;
            }
            sb.append("(tail)]");
            return sb.toString();
        }

        /* ==================== EXTRA CREDIT ==================== */

        /**
         * Remove nodes whose index is a multiple of base
         * <p>
         * TODO: javadoc comments
         */
        public void removeMultipleOf(int base) {
            // TODO: complete implementation
        }

        /**
         * Swap the nodes between index [0, splitIndex] of two lists
         * <p>
         * TODO: javadoc comments
         */
        public void swapSegment(DoublyLinkedList other, int splitIndex) {
            // TODO: complete implementation
        }

    }