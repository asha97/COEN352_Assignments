package com.coen352.assignment3;


public class AQueue<E> implements ADTQueue<E> {

	private static final int defaultSize = 10;
	private int maxSize;
	private int front;
	private int rear;
	private E[] listArray;

	AQueue() { this(defaultSize); }
	@SuppressWarnings("unchecked")  // For generic array purposes
	public AQueue(int size) {
	  maxSize = size+1;          // incrementing memory allocation of size
	  rear = 0; front = 1;
	  listArray = (E[])new Object[maxSize];
	}
	
	//used for reset purposes
	public void clear()
	{ rear = 0; front = 1; }
	
	//Adding to the queue
	public void enqueue(E it) {
	  assert ((rear+2) % maxSize) != front : "Queue is full";
	  rear = (rear+1) % maxSize; // Circular increment
	  listArray[rear] = it;
	}
	
	//Getting from the queue
	public E dequeue() {
	  assert length() != 0 : "Queue is empty";
	  E it = listArray[front];
	  front = (front+1) % maxSize; // Circular increment
	  return it;
	}

	public E frontValue() {
	  assert length() != 0 : "Queue is empty";
	  return listArray[front];
	}

	public int length()
	{ return ((rear+maxSize) - front + 1) % maxSize; }

	  public String toString()
	  {
	    StringBuffer out = new StringBuffer((length() + 1) * 4);
	    out.append("< ");
	    for (int i = front; i != (rear+1)%maxSize; i++) {
	      out.append(listArray[i]);
	      out.append(" ");
	    }
	    out.append(">");
	    return out.toString();
	  }
	 



}