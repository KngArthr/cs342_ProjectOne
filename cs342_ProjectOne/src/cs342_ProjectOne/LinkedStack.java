package cs342_ProjectOne;
//
//Class: LinkedStack
//
//Description:
//Contains methods to manipulate linked list stack
//

public class LinkedStack implements MyStack {
	
	private Node top;//reference to the top of the stack
	private int size;//size of the stack
	
///////////////////////////////////////////////////////////////////
/// LinkedStack ///
/// Input : None///
/// Output: None///
/// Constructor for LinkedStack object containing top reference and size///
/// ///
///////////////////////////////////////////////////////////////////
	
	
	public LinkedStack() {
		top = null;//initialize empty LinkedList stack
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
		
		Node newNode = new Node();//creates new node
		
		newNode.setData(data);//new node is given data that we want to add to the stack
		newNode.setNext(top);//new node next reference points to the top node of the stack
		
		top = newNode;//top node gets new data.
		size++;//size attribute is incremented
		
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
		
		if(isEmpty()) {//if the stack is empty then return null
			return null;
		}
		
		Node rtn = top;//new node gets top node
		
		top = top.getNext();//top node gets the next node. The node one down from the top
		
		size--;//subtract from size attribute as the top-most node has been removed
		
		return rtn.getData();//return what has been removed
	}

///////////////////////////////////////////////////////////////////
/// clear ///
/// Input : None///
/// Output: none///
/// Will clear the whole stack
/// ///
///////////////////////////////////////////////////////////////////
	public void clear() {
		size = 0;//reset size attribute
		top = null;//reset top reference to null. This will completely clear the whole stack
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
		
		Queen queen = null;//new empty queen object is created
		
		if(isEmpty()) {
			System.out.println("Empty Stack");//if the stack is empty then return null along with empty stack message
			return null;
		}
		
		
		Node node = top;//node gets the top object
		
		int counter = -1;//the counter starts at -1
		
		
		while(counter < slot) {//while the slot has not yet been reached
			if(node == null) {//if the end of the stack is hit, then return null and display message
				System.out.println("Stack out of bounds");
				return null;
			}
			queen = node.getData();//queen gets the data in the current node
			node = node.getNext();//node gets data from next node
			counter++;//increment counter
		}
		
		return queen;//return a queen object
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
		return (size == 0);//if the size is 0 return true else return false.
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
		if (isEmpty()) {//if stack is empty, return null
			return null;
		}
		
		return top.getData();//else return the top node in the stack
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
		return size;//return the size of the stack
	}
///////////////////////////////////////////////////////////////////
/// toString ///
/// Input : None///
/// Output: String///
/// Tailors string output to my liking
/// ///
///////////////////////////////////////////////////////////////////
	
	public String toString() {
		String rtn ="";
		
		if(isEmpty()) {//if the stack is empty return an empty message
			return "<Empty>";
		}
		
		Node node = top;//node gets the top node
		
		int counter = 0;
		
		while(node != null) {//while we don't hit the end of the stack
			if(node == top) {//if the node is the top node, add the following String
				rtn += "top -> ";
			}else {
				rtn += "       ";//otherwise ad space to line it up
			}

			rtn += ("Stack Slot " + counter + ": " + node.getData().getRow()+ ", " + node.getData().getColumn() + "\n");//adds slot number of stack plus the row and column of queen

				
			//rtn += n.getData();
			node = node.getNext();//move on to the next node
			counter++;//increment counter
		}
		
		return rtn;//return the string

		
	}




}
