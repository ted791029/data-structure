package queue;

public class ArrayQueueDemo {
	/**
	 * ���:
	 * 1.frot���VQueue���A�Ĥ@�Ӥ�����[�e�@��]��m�A��l��-1
	 * 2.rear���VQeueu���A�̫�@�Ӥ�������m(�ݯd�@�ӪŦ�A�קK�u���@�Ӥ����ɡAfront == rear�A�P�ŭȽĬ�)�A��l��-1
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
