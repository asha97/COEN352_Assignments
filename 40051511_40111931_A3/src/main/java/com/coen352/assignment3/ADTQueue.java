package com.coen352.assignment3;


public interface ADTQueue<E> {

  public void clear();
  public void enqueue(E it);
  public E dequeue();
  public E frontValue();
  public int length();
}