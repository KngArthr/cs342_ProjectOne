package cs342_ProjectOne;
//
//Class: LinkedStack
//
//Description:
//Contains methods to manipulate linked list stack
//

public class LinkedStack implements MyStack {
	
	private Node top;
	private int size;
	
///////////////////////////////////////////////////////////////////
/// LinkedStack ///
/// Input : None///
/// Output: None///
/// Constructor for LinkedStack object containing top reference and size///
/// ///
///////////////////////////////////////////////////////////////////
	
	
	public LinkedStack() {
		top = null;
		size = 0;
	}
	
///////////////////////////////////////////////////////////////////
/// push ///
/// Input : data as Queen///
/// Output: true or false///
/// Will place data at the top of the stack and return true or false///
/// ///
///////////////////////////////////////////////////////////////////

	@Override
	public boolean push(Queen data) {
		// TODO Auto-generated method stub
		
		Node newNode = new Node();
		
		newNode.setData(data);
		newNode.setNext(top);
		
		top = newNode;
		size++;
		
		return true;
	}
///////////////////////////////////////////////////////////////////
/// pop ///
/// Input : None///
/// Output: Queen///
/// Will delete data at the top of the stack and move the top
/// reference down
/// ///
///////////////////////////////////////////////////////////////////

	@Override
	public Queen pop() {
		// TODO Auto-generated method stub
		
		if(isEmpty()) {
			return null;
		}
		
		Node rtn = top;
		
		top = top.getNext();
		
		size--;
		
		return rtn.getData();
	}

///////////////////////////////////////////////////////////////////
/// clear ///
/// Input : None///
/// Output: none///
/// Will clear the whole stack
/// ///
///////////////////////////////////////////////////////////////////
	public void clear() {
		size = 0;
		top = null;
	}
	
///////////////////////////////////////////////////////////////////
/// readStack ///
/// Input : int///
/// Output: Queen///
/// Will return a queen based on the slot number from top-down
/// ///
///////////////////////////////////////////////////////////////////
	
	@Override
	public Queen readStack(int slot) {
		// TODO Auto-generated method stub
		
		Queen rtn = null;
		
		if(isEmpty()) {
			System.out.println("Empty Stack");
			return null;
		}
		
		Node n = top;
		
		int counter = -1;
		
		while(counter < slot) {
			if(n == null) {
				System.out.println("Stack out of bounds");
				return null;
			}
			rtn = n.getData();
			n = n.getNext();
			counter++;
		}
		
		return rtn;
	}

	
	
///////////////////////////////////////////////////////////////////
/// isEmpty ///
/// Input : None///
/// Output: True or false///
/// Will return true or false depending on if the stack is 
/// empty
/// ///
///////////////////////////////////////////////////////////////////

	@Override
	public Boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}
	
///////////////////////////////////////////////////////////////////
/// peek ///
/// Input : None///
/// Output: Queen///
/// Will return The top most Queen of the stack
/// ///
///////////////////////////////////////////////////////////////////

	@Override
	public Queen peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		
		return top.getData();
	}
///////////////////////////////////////////////////////////////////
/// size ///
/// Input : None///
/// Output: integer///
/// Will return the size of the stack as an int
/// ///
///////////////////////////////////////////////////////////////////


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
///////////////////////////////////////////////////////////////////
/// toString ///
/// Input : None///
/// Output: String///
/// Tailors output to my liking
/// ///
///////////////////////////////////////////////////////////////////
	
	public String toString() {
		String rtn ="";
		
		if(isEmpty()) {
			return "<Empty>";
		}
		
		Node n = top;
		int counter = 0;
		while(n != null) {
			if(n == top) {
				rtn += "top -> ";
			}else {
				rtn += "       ";
			}

			rtn += ("Stack Slot " + counter + ": " + n.getData().getRow()+ ", " + n.getData().getColumn() + "\n");

				
			//rtn += n.getData();
			n = n.getNext();
			counter++;
		}
		
		return rtn;

		
	}




}
