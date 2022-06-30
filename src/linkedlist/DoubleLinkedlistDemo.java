package linkedlist;

public class DoubleLinkedlistDemo {
	
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
		node.pre = this.end;
		this.end = node;
		this.i_end++;
	}
	
	public void insert(int index, int n) {
		//插入當前index後
		NodeDemo node = new NodeDemo(n);
		if(index < 0 || index >= this.size()) throw new RuntimeException("is out of range");
		if(index == i_end) {
			this.add(n);
			return;
		}
		NodeDemo current = this.get(index);
		NodeDemo next = current.next;
		//處理node
		node.next = current.next;
		node.pre = current;
		//處理next
		next.pre = node;
		//處理current
		current.next = node;
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
			this.head.pre = null;
			i_end--;
			return;
		}
		if(index == i_end) {
			this.end = this.end.pre;
			this.end.next = null;
			i_end--;
			return;
		}
		NodeDemo current = this.get(index);
		NodeDemo pre = current.pre;
		NodeDemo next = current.next;
		pre.next = next;
		next.pre = pre;
		i_end--;		
	}
	
	public Integer size() {
		return this.end == null ? 0 : this.i_end + 1;
	}
	
	public void print() {
		if(this.head == null) return;
		NodeDemo temp = this.head;
		while (true) {
			System.out.println(temp);
			if(temp.next == null) return;
			temp = temp.next;
		}
	}
	
	public void reversePrint() {
		if(this.end == null) return;
		NodeDemo temp = this.end;
		while (true) {
			System.out.println(temp);
			if(temp.pre == null) return;
			temp = temp.pre;
		}
	}
}
