package linkedlist;

public class NodeDemo {
	Integer val;
	NodeDemo next;
	NodeDemo pre;
	
	public NodeDemo(Integer val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "NodeDemo [val=" + val + "]";
	}
}
