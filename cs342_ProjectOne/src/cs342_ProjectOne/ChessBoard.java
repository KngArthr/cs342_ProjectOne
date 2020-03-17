package cs342_ProjectOne;
//
//Class: ChessBoard
//
//Description:
//Chessboard class which include most algorithms to check Queen conflicts
//and the size of the grid.

public class ChessBoard {
	
	final private int MAX_ROW;

	final private int MAX_COLUMN;
	
///////////////////////////////////////////////////////////////////
/// ChessBoard(///
/// Input : maximum column and row for chessboard///
/// Output: None ///
/// Constructor for chessboard. Allows a chessboard object to be created
/// Initializes row and column.
/// ///
///////////////////////////////////////////////////////////////////

	public ChessBoard(int max_row, int max_column) {
		this.MAX_ROW = max_row;
		this.MAX_COLUMN = max_column;
	}

///////////////////////////////////////////////////////////////////
/// isConflictStack///
/// Input : stack///
/// Output: true or false ///
/// returns true or false based on if any queens in the stack conflict
/// with each other.
/// ///
///////////////////////////////////////////////////////////////////
	public boolean isConflictStack(LinkedStack queenStack) {
		
		Queen queen1;//two variables to compare 1 queen with all other queens in the stack
		Queen queen2;//for the first iteration, queen 1 will stay the same while queen 2 will cycle through the stack
		//next iteration will move to next queen in stack, and queen 2 will cycke through stack
		for(int i = 0; i < queenStack.size(); i++) {//queen1 will be what the other queens are compared against
			queen1 = queenStack.readStack(i);//i is the queen that is compared against
			
			for(int j = 0; j < queenStack.size(); j++) {//queen 2 will be the rest of the queens in the stack
				queen2 = queenStack.readStack(j);//j will be the rest of the queens
				if(i == j) {//if i == j then it is the same slot in the stack and does not need to do anything
					
					//do nothing
				}else if(isConflictHorVer(queen1, queen2)||isConflictDiagonal(queen1, queen2)) {
					return true;//if there is a horizontal, vertical, or diagonal conflict then return true for conflict.
				}
				
				
			}
		}
		
		return false ;//return false if there are no conflicts
	}
	

///////////////////////////////////////////////////////////////////
/// isConflictHorVer///
/// Input : two queens///
/// Output: true or false ///
/// returns true or false based on if queen 1 conflicts with queen2
/// horizontally or vertically
/// ///
///////////////////////////////////////////////////////////////////
	public boolean isConflictHorVer(Queen queen1, Queen queen2) {
		if((queen1.getRow()==queen2.getRow())||(queen1.getColumn()==queen2.getColumn())) {//if rows or columns of the two queens are equivalent, they conflict.
			return true;
		}
		
		return false;
	}
///////////////////////////////////////////////////////////////////
/// isConflictDiagonal///
/// Input : two queens///
/// Output: true or false ///
/// returns true or false based on if queen 1 conflicts with queen2
/// diagonally. Method scans through diagonals of board to find conflict
/// ///
///////////////////////////////////////////////////////////////////
	public boolean isConflictDiagonal(Queen queen1, Queen queen2) {
		
		int modifier = 0;
		
		while(modifier < 8) {
			modifier++;
			
			
			//
			//As we move through the loop, the diagonals will be scanned based on the coordinates
			//of the queens on the stack. The modifier attribute will be used to move through the diagonals in relation to the queen.
			//
			//
			//
			//
			//Scanning down and right
			// increment row, increment column
			if(queen1.getRow() + modifier > -1 && queen1.getRow() + modifier < getMAX_ROW() && queen1.getColumn() + modifier > -1 && queen1.getColumn() + modifier < getMAX_COLUMN()) {//if the queen +/- modifier is within the limits of the chessboard
				if(queen1.getRow() + modifier == queen2.getRow() && queen1.getColumn() + modifier == queen2.getColumn()){//and if the queen's diagonals conflict with the second queen's coordinates, return true for conflict
					return true;
				}

			}
			//Scanning up and left
			// decrement row, decrement colummn
			if(queen1.getRow() - modifier > -1 && queen1.getRow() - modifier < getMAX_ROW() && queen1.getColumn() - modifier > -1 && queen1.getColumn() - modifier < getMAX_COLUMN()) {//if the queen +/- modifier is within the limits of the chessboard
				if(queen1.getRow() - modifier == queen2.getRow() && queen1.getColumn() - modifier == queen2.getColumn()){//and if the queen's diagonals conflict with the second queen's coordinates, return true for conflict
					return true;
				}

			}
			//Scanning down and left
			// increment row, decrement column
			if(queen1.getRow() + modifier > -1 && queen1.getRow() + modifier < getMAX_ROW() && queen1.getColumn() - modifier > -1 && queen1.getColumn() - modifier < getMAX_COLUMN()) {//if the queen +/- modifier is within the limits of the chessboard
				if(queen1.getRow() + modifier == queen2.getRow() && queen1.getColumn() - modifier == queen2.getColumn()){//and if the queen's diagonals conflict with the second queen's coordinates, return true for conflict
					return true;
				}

			}
			//Scanning up and right
			// decrement row, increment column
			if(queen1.getRow() - modifier > -1 && queen1.getRow() - modifier < getMAX_ROW() && queen1.getColumn() + modifier > -1 && queen1.getColumn() + modifier < getMAX_COLUMN()) {//if the queen +/- modifier is within the limits of the chessboard
				if(queen1.getRow() - modifier == queen2.getRow() && queen1.getColumn() + modifier == queen2.getColumn()){//and if the queen's diagonals conflict with the second queen's coordinates, return true for conflict
					return true;
				}

			}
			
			
		}
		
		
		return false;//if no conflicts are found then return false
	}

///////////////////////////////////////////////////////////////////
/// printChessBoard///
/// Input : stack///
/// Output: printed chessboard with queens from stack ///
/// Prints a chessboard to the console with Queens from stack.
/// ///
///////////////////////////////////////////////////////////////////
	
	public void printChessBoard(LinkedStack queenStack) {
		
		for(int i = 0; i < getMAX_COLUMN(); i++ ) {//top line generated based on number of columns
			System.out.print("+---");

		}
		System.out.print("+\n");

		//System.out.print("+---+---+---+---+---+---+---+---+\n");
		
		for(int i = 0; i < getMAX_ROW(); i++) {//for the amount of rows in the chessboard, do the following...
			
			System.out.print("|");
			
			for(int j = 0; j < getMAX_COLUMN(); j++) {//for the specific row (i) and amount of columns in the chessboard, do the following...
				
				System.out.print(" ");
				
				for(int k = 0; k < queenStack.size(); k++) {//for the specific i,j coordinates, and amount of queens in the stack, cycle through the stack and see if i,j matches with any queen's coordinates
					
					if((queenStack.readStack(k).getRow()==i) && queenStack.readStack(k).getColumn() == j) {//if i and j are at the queen's coordinates print a "Q" to mark the queen
						
						System.out.print("Q");
						break;
						//break the loop if a queen is placed for the coordinate because no other queen should be in the same coordinates
						
					}else if(k == queenStack.size()-1) {//if no matching coordinates are found, just print a space
						System.out.print(" ");
					}
				}
				
				if(queenStack.isEmpty()) {//if the queenstack is empty, print out a space
					System.out.print(" ");

				}
				
				System.out.print(" ");
				System.out.print("|");
				
				if(j == getMAX_COLUMN()-1) {//if the max column is reached, start a new line/row
					System.out.print("\n");

				}


			}
			for(int l = 0; l < getMAX_COLUMN(); l++ ) {
				System.out.print("+---");//bottom line generated based on number of columns

			}
			System.out.print("+\n");//start new line

			//System.out.print("+---+---+---+---+---+---+---+---+\n");
			
			
		}
		
	}
	///////////////////////////////////////////////////////////////////
	/// General getters and setters ///
	///
	/// General Getters and setters for max row and max column attributes///
	/// ///
	///////////////////////////////////////////////////////////////////
	public int getMAX_ROW() {
	return MAX_ROW;
	}
	
	public int getMAX_COLUMN() {
	return MAX_COLUMN;
	}

}
