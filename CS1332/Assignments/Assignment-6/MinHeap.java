// 6.9/10
import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if (data == null){
        throw new IllegalArgumentException("Empty Data!");
      }

      else{

        size++;
        
        if (size == backingArray.length){
          T[] dou = (T[]) new Comparable[backingArray.length * 2];
          for (int i = 1; i < backingArray.length; i++){
            dou[i] = backingArray[i];
          }
          backingArray = dou;
        }

        backingArray[size] = data;
        addHelper(size, size/2);
      }
    }

    private void addHelper(int child, int parent){
      while (child > 1 && backingArray[child].compareTo(backingArray[parent]) < 0){
        swap(child, parent);
        child = parent;
        parent /= 2;
      }
    }


    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if (backingArray[1] == null){
        throw new NoSuchElementException("Empty Heap!");
      }
      
      backingArray[1] = backingArray[size];
      T data = backingArray[size];
      backingArray[size] = null;

      int i = 1;

      while (2 * i < size) {
            int j = 2 * i;
        if (backingArray[j + 1] != null){
            if (j < size && backingArray[j]
                    .compareTo(backingArray[j + 1]) > 0) {
                j++;
            }
            if (!(backingArray[i].compareTo(backingArray[j]) > 0)) {
              break;
            }
            swap(i, j);
            i = j;
        }
        else{
          if (!(backingArray[i].compareTo(backingArray[j]) > 0)) {
            break;
          }
          swap(i, j);
          i = j;
        }
      }

      size--;
      return data;
      
    }

    private void swap(int child, int parent){
      T temp = backingArray[child];
      backingArray[child] = backingArray[parent];
      backingArray[parent] = temp;
    }


    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}