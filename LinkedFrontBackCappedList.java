package ProjectC;


public class LinkedFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {

	private Node head, tail;
	private int maxSize;
	private int numberOfElements;

	public LinkedFrontBackCappedList(int capacity){
		this.maxSize = capacity;
		numberOfElements = 0;
	}

	public int compareTo(LinkedFrontBackCappedList<T> listB) {
		return 0;
	}

	// YOUR CLASS HERE!

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


	@Override
	public boolean addFront(T element) {

		Node newNode = new Node(element);

		if(isFull()){
			return false;
		}
		else{
			if(isEmpty()){
				head = newNode;
			}
			else{
				newNode.next = head;
			}
			head = newNode;
			numberOfElements++;
			return true;
		}
	}
	
	@Override
	public boolean addBack(T element) {
		Node newNode = new Node(element);
		if (isFull()) {
			return false;
		}
		else {
			numberOfElements++;
			if(isEmpty()){
				head = newNode;
			}
			else{
				Node current = head;
				while(current.next!=null){
					current = current.next;
				}
				current.next = newNode;
			}
			tail = newNode;
		}
		return true;
	}

	//replace methods
	@Override
	public T removeFront() {
		T removeItem = null;
		if(!isEmpty()){
			Node current = head;
			removeItem = head.data;
			head = head.next;
			while(current.next!=null){
				current = current.next;
			}
			tail = current;
			numberOfElements --;
		}

		return removeItem;
	}

	@Override
	public T removeBack() {
		T removeItem = null;
		if(!isEmpty()){
			if(head.next == null){
				removeItem = head.data;
				clear();
			}
			else{
				Node current = head;
				removeItem = tail.data;
				while(current.next!=tail){
					current = current.next;
				}
				current.next = null;
				tail = current;
				numberOfElements--;
			}
		}
		return removeItem;
	}
	
// 	@Override
// 	public T removeFront() {
// 		if (head == null) {
// 			return null;
// 		} 
// 		else if (head.equals(tail)) {
// 			numberOfElements--;
// 			head = null;
// 			tail = null;
// 		} 
// 		else {
// 			numberOfElements --;
// 			Node temp = head;
// 			head = head.next;
// 			return temp.getData();
// 		}
// 	}

// 	@Override
// 	public T removeBack() {
// 		if (tail == null) {
// 			return null;
// 		} 
// 		else if (head.equals(tail)) {
// 			numberOfElements--;
// 			head = null;
// 			tail = null;
// 			return head.getData();
// 		} 
// 		else {
// 			return removeBack(head);
// 		}
// 	}
	
// 	public T removeBack(Node current) {
// 		if (current.next.equals(tail)) {
// 			numberOfElements --;
// 			Node temp = tail;
// 			tail = current;
// 			return temp.getData();
// 		} 
// 		else {
// 			return removeBack(current.next);
// 		}
// 	}

	@Override
	public void clear() {
		head = null;
		numberOfElements = 0;
	}

	@Override
	public T getEntry(int givenPosition) {
		T[] temp = (T[]) new Object[numberOfElements];
		T item = null;
		Node current = head;
		int i = 0;
		if (!isEmpty() && givenPosition< temp.length && givenPosition>=0) {
			while (current != null) {
				temp[i] = current.data;
				i++;
				current = current.next;
			}
			item = temp[givenPosition];
		}
		return item;
	}

	@Override
	public int indexOf(T anEntry) {
		int index = 0;
		Node current = head;
		if(contains(anEntry)){
			while (current != null) {
				if(current.data.equals(anEntry)){
					return index;
				}
				index++;
				current = current.next;
			}
		}
		else{
			index = -1;
		}
		return index;
	}

	@Override
	public int lastIndexOf(T anEntry) {
		int index = 0;
		int temp = 0;
		Node current = head;
		T[] tempArray = (T[]) new Object[numberOfElements];
		while(current!=null){
			tempArray[index] = current.data;
			index++;
			current = current.next;
		}
		if(contains(anEntry)){
			for(index = 0; index < numberOfElements ; index++){
				if(tempArray[index].equals(anEntry)){
					temp = index;
				}
			}
			index = temp;
		}
		else{
			index = -1;
		}
		return index;
	}

	@Override
	public boolean contains(T anEntry) {
		boolean result = false;
		Node current = head;
		while(current!=null){
			if(current.data.equals(anEntry)){
				result = true;
			}
			current = current.next;
		}
		return result;
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
		String s = new String();
		int i = 0;
		if (!isEmpty()) {
			while (current != null) {
				temp[i] = current.data;
				s += temp[i] + " ";
				i++;
				current = current.next;
			}
			return 	"[ " + s + "]" +
					" size=" + numberOfElements +
					" capacity=" + maxSize
						+
						" head= " + temp[0].toString() +
						" tail= " + temp[numberOfElements-1]
					;
		}
		else {
			return "[]" +
					", size=" + numberOfElements +
					", capacity=" + maxSize
					;

		}
	}

}

