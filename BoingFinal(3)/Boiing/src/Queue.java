
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */

import java.util.NoSuchElementException;

public class Queue<T> {

	//TODO:  You need some data to store the queue.  Put the attributes here.
	private QueueElement<T> head;
	private QueueElement<T> tail;



	
	/**
	 * Constructs an empty Queue.
	 * <br>
	 * Sets head and tail to null to show that there is nothing in the queue.
	 */
	public Queue () { //This creates an empty queue, size is automatically set by java.
		head = null;
		tail = null;
	    //TODO: Write the Queue constructor
	}
	
	/**
	 * Returns true if the queue is empty and false if the queue has elements in it.
	 */
	public boolean isEmpty () {
		if((head == null) && (tail == null)){
			return true;
		}else {
			return false;
		}
	    //TODO:  Needs to return true when empty and false otherwise
	}
	
	
	/**
	 * Returns the element at the head of the queue as long as it is not empty.
	 * <br>
	 * If it is empty then a NoSuchElementException will be thrown.
	 */
	public T peek () throws NoSuchElementException {

		if(!isEmpty()){
			return head.getElement();
		}else {
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Removes the front element of the queue as long as it is not empty.
	 * <br>
	 * If it is empty then a NoSuchElementException will be thrown.
	 */
	public void dequeue () throws NoSuchElementException {

		if(!isEmpty()){
			head = head.getNext();
			if(head == null){
				tail = null;
			}
		}else {
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Puts an element on the back of the queue.
	 * and then makes sure that the tail is pointing to the new end of the queue.
	 */
	public void enqueue (T element) {

		if(isEmpty()){
			QueueElement newElement = new QueueElement(element,null);

			head = newElement;
			tail = newElement;
		}else {
			QueueElement newElement = new QueueElement(element,null);

			tail.setNext(newElement);

			tail = newElement;
		}
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () { //Needs to be made.
		QueueElement<T> curItem = head;

		if(!isEmpty()) {
			while (curItem != null) {
				System.out.println(curItem.getElement());
				curItem = curItem.getNext();
			}
		}
	}
}
