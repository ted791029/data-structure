package queue;

public class CircleArrayQueueDemo {
	/**
	 * ���
	 * 1.frot���VQueue���A�Ĥ@�Ӥ�����[�e�@��]��m�A��l�� maxSize - 1
	 * 2.rear���VQeueu���A�̫�@�Ӥ�������m(�ݯd�@�ӪŦ�A�קK�u���@�Ӥ����ɡAfront == rear�A�P�ŭȽĬ�)�A��l�� maxSize - 1
	 * 3.isFull (rear + 1) % maxSize == front
	 * 4.isEmpty front == rear
	 * 5.Queue����ڼƶq (rear + maxSize - front) % maxSize
	 */
	private int maxSize;
	private int[] arr;
	private int front;
	private int rear;
	
	public CircleArrayQueueDemo(int size) {
		this.maxSize = size;
		this.arr = new int[maxSize];
		this.front = maxSize - 1;
		this.rear = maxSize - 1;
	}
	
	public boolean isEmpty() {
		return this.front == this.rear;
	}
	
	public boolean isFull() {
		return (this.rear + 1) % this.maxSize == this.front;
	}
	
	public void push(int n) {
		if(isFull()) throw new RuntimeException("queue is full");
		this.rear = (this.rear + 1) % maxSize;
		this.arr[this.rear] = n;
	}
	
	public int pop() {
		if(isEmpty()) throw new RuntimeException("queue is empty");
		this.front = (this.front + 1) % maxSize;
		return this.arr[this.front];
	}
	
	public int peek() {
		if(isEmpty()) throw new RuntimeException("queue is empty");
		return this.arr[(this.front + 1) % maxSize];
	}
	
	public int size() {
		return (this.rear + this.maxSize  - this.front) % this.maxSize;
	}
	
	public void show() {
		for(int i = this.front + 1; i <= this.front + size(); i++) {			
			System.out.println(this.arr[i % this.maxSize]);
		}
		System.out.println("=========================================");
	}
	
}
