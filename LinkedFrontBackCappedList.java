public class LinkedFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {

	private Node head, tail;
	
	//Ben's code. Starting Here.
	private int maxSize;
	private int numberOfElements;

	public LinkedFrontBackCappedList(int capacity){
		this.maxSize = capacity;
		numberOfElements = 0;
	}

	public boolean addFront(T element) {
		if (isFull()) {
			return false;
		}
		else {
			Node newNode = new Node(element);
			newNode.next = head;
			head = newNode;
			numberOfElements++;
		}
	}

	public boolean addBack(T element) {
		if (isFull()) {
			return false;
		}
		else {
			Node newNode = new Node(element);
			tail.next = newNode;
			tail = newNode;
			numberOfElements++;
		}
	}
	//Ben's Code Ending Here.
	
	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean isEmpty() {
		boolean result = true;
		if(head != null){
			result = false;
		}
		return result;
	}

	@Override
	public boolean isFull() {
		boolean result = true;
		if(isEmpty()){
			result = false;
		}
		else{
			if(list.length == numberOfElements){
				result = false;
			}
		}
		return result;
	}
	public class Node {
		public T data; 
		public Node next; 

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} 
	} 
}
