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
	public void clear() {
		head = null;
		numberOfElements = 0;
	}
	
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
		int count=0;
		Node current = head;
		if(isEmpty()){
			result = false;
		}
		else{
			while(current!=null){
				count++;
				current = current.next;
			}
			if(count<maxSize){
				result = false;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		T[] temp = (T[]) new Object[numberOfElements];
		Node current = head;
		int i = 0;
		if (!isEmpty()) {
			while (current != null) {
				temp[i] = current.data;
				i++;
				current = current.next;
			}
			if(temp.length == numberOfElements){
				return Arrays.toString(temp) +
					" size=" + numberOfElements +
					" capacity=" + maxSize +
					" head= " + temp[0].toString()+
					" tail= " + temp[0].toString();
			}
			else{
				return Arrays.toString(temp) +
						" size=" + numberOfElements +
						" capacity=" + maxSize +
						" head= " + temp[0].toString()+
						" tail= " + temp[numberOfElements].toString();
			}
		} else {

			return Arrays.toString(temp) +
					", size=" + numberOfElements +
					", capacity=" + maxSize
					;

		}
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
