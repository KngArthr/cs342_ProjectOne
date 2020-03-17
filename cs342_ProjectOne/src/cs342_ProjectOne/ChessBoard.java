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
		if((queen1.getRow()==queen2.getRow())||(queen1.getColumn()==queen2.getColumn())) {
			return true;
		}
		
		return false;
	}
///////////////////////////////////////////////////////////////////
/// isConflictDiagonal///
/// Input : two queens///
/// Output: true or false ///
/// returns true or false based on if queen 1 conflicts with queen2
/// diagonally
/// ///
///////////////////////////////////////////////////////////////////
	public boolean isConflictDiagonal(Queen queen1, Queen queen2) {
		
		int counter = 0;
		
		while(counter < 8) {
			counter++;
			
			if(queen1.getRow() + counter > -1 && queen1.getRow() + counter < getMAX_ROW() && queen1.getColumn() + counter > -1 && queen1.getColumn() + counter < getMAX_COLUMN()) {
				if(queen1.getRow() + counter == queen2.getRow() && queen1.getColumn() + counter == queen2.getColumn()){
					return true;
				}

			}
			if(queen1.getRow() - counter > -1 && queen1.getRow() - counter < getMAX_ROW() && queen1.getColumn() - counter > -1 && queen1.getColumn() - counter < getMAX_COLUMN()) {
				if(queen1.getRow() - counter == queen2.getRow() && queen1.getColumn() - counter == queen2.getColumn()){
					return true;
				}

			}
			if(queen1.getRow() + counter > -1 && queen1.getRow() + counter < getMAX_ROW() && queen1.getColumn() - counter > -1 && queen1.getColumn() - counter < getMAX_COLUMN()) {
				if(queen1.getRow() + counter == queen2.getRow() && queen1.getColumn() - counter == queen2.getColumn()){
					return true;
				}

			}
			if(queen1.getRow() - counter > -1 && queen1.getRow() - counter < getMAX_ROW() && queen1.getColumn() + counter > -1 && queen1.getColumn() + counter < getMAX_COLUMN()) {
				if(queen1.getRow() - counter == queen2.getRow() && queen1.getColumn() + counter == queen2.getColumn()){
					return true;
				}

			}
			
			
		}
		
		
		return false;
	}

///////////////////////////////////////////////////////////////////
/// printChessBoard///
/// Input : stack///
/// Output: printed chessboard with queens from stack ///
/// peints a chessboard to the console with Queens from stack
/// ///
///////////////////////////////////////////////////////////////////
	
	public void printChessBoard(LinkedStack queenStack) {
		System.out.print("+---+---+---+---+---+---+---+---+\n");
		
		for(int i = 0; i < getMAX_ROW(); i++) {
			System.out.print("|");
			for(int j = 0; j < getMAX_COLUMN(); j++) {
				System.out.print(" ");
				for(int k = 0; k < queenStack.size(); k++) {
					if((queenStack.readStack(k).getRow()==i) && queenStack.readStack(k).getColumn() == j) {
						System.out.print("Q");
						break;
					}else if(k == queenStack.size()-1) {
						System.out.print(" ");
					}
				}
				if(queenStack.isEmpty()) {
					System.out.print(" ");

				}
				System.out.print(" ");
				System.out.print("|");
				if(j == getMAX_COLUMN()-1) {
					System.out.print("\n");

				}


			}
			System.out.print("+---+---+---+---+---+---+---+---+\n");
			
			
		}
		
	}

}
