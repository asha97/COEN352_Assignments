package com.coen352.assignment3;



public class AStack<E> implements ADTStack<E> {

  private static final int defaultSize = 10;

  private int maxSize;
  private int top;
  private E [] listArray;

  /** Constructors */
  public AStack() { this(defaultSize); }
  @SuppressWarnings("unchecked")

  public
  AStack(int size) {
    maxSize = size;
    top = 0; 
    listArray = (E[])new Object[size];
  }

  /** Reinitialize stack */
  public void clear() { top = 0; }

  /** Push "it" onto stack */
  public void push(E it) {
    assert top != maxSize : "Stack is full";
    for(int i = 0; i < this.length(); i++)
    {
      if(it.equals(listArray[i]))
        return;
    }
    listArray[top] = it;
    ++top;
  }

  public E pop() {
    assert top != 0 : "Stack is empty";
    E value = listArray[--top];
    
    return value;
  }

  public E topValue() {
    assert top != 0 : "Stack is empty";
    return listArray[top-1];
  }

  public int length() { return top; }

  public String toString()
  {
    StringBuffer out = new StringBuffer((length() + 1) * 4);
    out.append("< ");
    for (int i = top-1; i >= 0; i--) {
      out.append(listArray[i]);
      out.append(" ");
    }
    out.append(">");
    return out.toString();
  }
}