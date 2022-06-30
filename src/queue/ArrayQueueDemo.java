package queue;

public class ArrayQueueDemo {
	/**
	 * 思路:
	 * 1.frot指向Queue中，第一個元素的[前一個]位置，初始為-1
	 * 2.rear指向Qeueu中，最後一個元素的位置(需留一個空位，避免只有一個元素時，front == rear，與空值衝突)，初始為-1
	 * 3.isFull rear == maxSize
	 * 3.isEmpty frot == rear
	 */
	private int maxSize;
	private int[] arr;
	private int front;
	private int rear;
	
	public ArrayQueueDemo(int size) {
		this.maxSize = size;
		this.arr = new int[maxSize];
		this.front = -1;
		this.rear = -1;
	}
	
	public boolean isEmpty() {
		return this.front == this.rear;
	}
	
	public boolean isFull() {
		return this.rear + 1 == this.maxSize;
	}
	
	public void push(int n) {
		if(isFull()) throw new RuntimeException("queue is full");
		this.arr[++this.rear] = n;
	}
	
	public int pop() {
		if(isEmpty()) throw new RuntimeException("queue is empty");
		return this.arr[++this.front];
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("queue is empty");
		return this.arr[this.front + 1];
	}
	
	public void show() {
		for(int i = this.front + 1; i <= this.rear; i++) {			
			System.out.println(this.arr[i]);
		}
	}

}
