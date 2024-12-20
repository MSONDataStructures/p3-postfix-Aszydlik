package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using
 * a Linked List structure to allow for unbounded size.
 * <p></p>
 * The {@code isEmpty} and {@code size} methods are provided,
 * on the house.
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

    Node<T> head;
    int size;

    /**
     * {@inheritDoc}.
     */
    @Override
    public T pop() throws StackUnderflowException {
        if (head == null) throw new StackUnderflowException();

        T element = head.getElement();
        head =head.getNext();
        size--;
        return element;

        // TODO: Implement the pop method, which will be
        //   similar to a removeFirst method for a LinkedList
        //   (a special case of our remove method).
        //   If the list is empty you should throw an exception.

    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public T top() throws StackUnderflowException {
        // TODO: Implement the top method, which will be
        //   similar to a getFirst method for a LinkedList
        //   (a special case of our get method).
        //   If the list is empty you should throw an exception.
        if (head == null) throw new StackUnderflowException();

        return head.getElement();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void push(T elem) throws NullPointerException {
        // TODO: Implement the push method, which will be
        //   similar to the addFirst method for a LinkedList.
        //   If elem is null you should throw an exception.
        if (elem == null) {
            throw new NullPointerException() ;
        }

        Node<T> newNode = new Node<>(elem);
        newNode.setNext(head);
        head = newNode;
        size++;


    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int size() {
        return size;
    }
}
