package linkedlist;

public class LinkedlistDemo {
	
	private NodeDemo head;
	private NodeDemo end;
	private Integer i_end;
	
	public NodeDemo get(int index) {
		if(index < 0 || index >= this.size()) throw new RuntimeException("is out of range");
		NodeDemo temp = this.head;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	public Integer getValue(int index) {
		if(index < 0 || index >= this.size()) throw new RuntimeException("is out of range");
		NodeDemo temp = this.get(index);
		return temp.val;
	}
	
	public void add(int n) {
		NodeDemo node = new NodeDemo(n);
		//list為空
		if(this.end == null) {
			this.head = node;
			this.end = head;
			i_end = 0;
			return;
		}
		this.end.next = node;
		this.end = node;
		this.i_end++;
	}
	
	public void insert(int index, int n) {
		//插入當前index後
		NodeDemo node = new NodeDemo(n);
		if(index < 0 || index >= this.size()) throw new RuntimeException("is out of range");
		//插入最後一個
		if(index == i_end) {
			this.add(n);
			return;
		}
		NodeDemo temp = this.get(index);
		node.next = temp.next;
		temp.next = node;
		i_end++;
	}
	
	public void remove(int index) {
		if(index < 0 || index >= this.size()) throw new RuntimeException("is out of range");
		//list只有一個
		if(this.size() == 1) {
			this.head = null;
			this.end = null;
			this.i_end = null;
			return;
		}
		//刪除第一個
		if(index == 0) {
			this.head = this.head.next;
			i_end--;
			return;
		}
		NodeDemo temp = this.get(index - 1);
		temp.next = temp.next.next;
		//刪除最後一個
		if(index == i_end) this.end = temp;
		i_end--;
		
	}
	
	public Integer size() {
		return this.end == null ? 0 : this.i_end + 1;
	}
	
	public void print() {
		if(this.head == null) return;;
		NodeDemo temp = this.head;
		while (true) {
			System.out.println(temp);
			if(temp.next == null) return;
			temp = temp.next;
		}
	}
}
