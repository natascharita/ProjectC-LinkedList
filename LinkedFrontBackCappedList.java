package ProjectCLinkedListFiles;

import java.util.Arrays;

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
		if (isFull()) {
			return false;
		}
		else {
			if(!isEmpty()){
				Node newNode = new Node(element);
				newNode.next = head;
				head = newNode;
				numberOfElements++;
			}
			else{
				Node newNode = new Node(element);
				head = newNode;
				numberOfElements++;
			}
		}
		return true;
	}

	@Override
	public boolean addBack(T element) {
		if (isFull()) {
			return false;
		}
		else {
			if(!isEmpty()){
				numberOfElements++;
				Node newNode = new Node(element);
				tail.next = newNode;
				tail = newNode;
			}
			else{
				Node newNode = new Node(element);
				head = newNode;
				tail = head;
				numberOfElements++;
			}
		}
		return true;
	}

	@Override
	public T removeFront() {
		return null;
	}

	@Override
	public T removeBack() {
		return null;
	}

	@Override
	public void clear() {
		head = null;
		numberOfElements = 0;
	}

	@Override
	public T getEntry(int givenPosition) {
		return null;
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
		int i = 0;
		if (!isEmpty()) {
			while (current != null) {
				temp[i] = current.data;
				i++;
				current = current.next;
			}

			return Arrays.toString(temp) +
					" size=" + numberOfElements +
					" capacity=" + maxSize
						+
						" head= " + temp[0].toString()+
						" tail= " + temp[numberOfElements-1].toString()
					;
		}
		else {
			return Arrays.toString(temp) +
					", size=" + numberOfElements +
					", capacity=" + maxSize
					;

		}

	}

}

