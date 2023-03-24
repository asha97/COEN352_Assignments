package com.coen352.assignment1;

public class AList<E> implements com.coen352.assignment1.ADTList<E> {
    private static final int defaultSize = 10;
    private final int maxSize;        // Maximum size of list
    private final E[] listArray;      // Array holding list elements/**Constructors*//**Create a list with the default capacity.*/
    private int listSize;       // Current # of list items
    private int currentElemPos;           // Position of current element

    AList() {
        this(defaultSize);
    }

    /**
     * Create a new list object.@param size Max # of elements list can contain.
     */

    @SuppressWarnings("unchecked")
    // Generic array allocation
    AList(int size) {
        maxSize = size;
        listSize = currentElemPos = 0;
        listArray = (E[]) new Object[size];  //initialization of list array
    }

    public void clear()
    {
        listSize = currentElemPos = 0;
    } //this resets the list

    public void insert(E it) {
        assert listSize < maxSize : "List capacity exceeds size";
        // Shift elements up
        //   to make room
        if (listSize - currentElemPos >= 0) System.arraycopy(listArray, currentElemPos, listArray, currentElemPos + 1, listSize - currentElemPos);
        listArray[currentElemPos] = it;
        listSize++;               // Increment list size
    }

    public void append(E it) {
        assert listSize < maxSize : "List capacity exceeded";
        listArray[listSize++] = it;
    }


    public E remove() {
        if ((currentElemPos < 0) || (currentElemPos >= listSize))  // No current element
            return null;
        E it = listArray[currentElemPos];   // Copy the element
        // Shift them down
        if (listSize - 1 - currentElemPos >= 0) System.arraycopy(listArray, currentElemPos + 1, listArray, currentElemPos, listSize - 1 - currentElemPos);
        listSize--;               // Decrement size
        return it;
    }

    // Set to beginning of list
    public void moveToStart() {
        currentElemPos = 0;
    }

    // Set yo end of list
    public void moveToEnd() {
        currentElemPos = listSize;
    }

    // Go to previous element
    public void prev() {
        if (currentElemPos != 0) currentElemPos--;
    }

    //GO to next element
    public void next() {
        if (currentElemPos < listSize) currentElemPos++;
    }

    //return size of list
    public int length() {
        return listSize;
    }


   //evaluates current position
    public int currPos() {
        return currentElemPos;
    }

    //updates position of element
    public void moveToPos(int pos) {
        assert (pos >= 0) && (pos <= listSize) : "Pos out of range";
        currentElemPos = pos;
    }

    // returns which element is focussed
    public E getValue() {
        assert (currentElemPos >= 0) && (currentElemPos < listSize) : "No current element";
        return listArray[currentElemPos];
    }
}