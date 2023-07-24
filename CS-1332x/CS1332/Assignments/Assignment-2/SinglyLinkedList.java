// 8.24 / 10
import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if(data == null){
        throw new IllegalArgumentException("The data is Null.");
      }
      
      else if (head == null){
        head = new SinglyLinkedListNode<T>(data);
        tail = head;
        size += 1;
      }
      
      else{
        SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data);
        temp.setNext(head);
        head = temp;
        size += 1;
      }
      
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if (data == null) {
        throw new IllegalArgumentException("The data is Null.");
      }
      else if(size == 1){
        SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data);
        head.setNext(temp);
        size ++;
        tail = temp;
      }
      else{
        SinglyLinkedListNode<T> temp = new SinglyLinkedListNode<T>(data);
        for (int i = 1; i < size; i++){
          head = head.getNext();
        }
        head.setNext(temp);
        tail = temp;
        size += 1;
      }
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if (head == null || head.getData() == null){
        throw new NoSuchElementException("Empty List.");
      }
        
      else if(size == 1){
        T data = head.getData();
        head = null;
        tail = null;
        size--;
        return data;
      }
      
      else{
        T data = head.getData();
        SinglyLinkedListNode<T> temp = head.getNext();
        head = temp;
        size--;
        return data;
      }
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if (head == null){
        throw new NoSuchElementException("Empty List.");
      }
      
      else if (size == 1){
        T data = head.getData();
        head = null;
        tail = null;
        size--;
        return data;
      }
      
      else{
        SinglyLinkedListNode<T> temp = head;
        for (int i = 1; i < size - 1; i++){
          temp = temp.getNext();
        }
        T data = temp.getNext().getData();
        temp.setNext(null);
        tail = temp;
        size--;
        return data;
      }
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}