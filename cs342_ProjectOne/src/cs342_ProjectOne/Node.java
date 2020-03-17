package cs342_ProjectOne;
//
//Class: Driver
//
//Description:
//Node contains data and next reference for linked list
//

public class Node {
	
	private Queen data;//stores data as a Queen object
	private Node next;//reference to next data object
	
///////////////////////////////////////////////////////////////////
/// General getters and setters ///
///
/// General Getters and setters for data and next attributes///
/// ///
///////////////////////////////////////////////////////////////////
	public Queen getData() {
		return data;
	}
	public void setData(Queen data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
	

}
