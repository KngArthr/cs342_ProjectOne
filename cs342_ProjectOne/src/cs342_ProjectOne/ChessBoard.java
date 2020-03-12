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
				
			}
			
			
		}
		
		
		return false;
	}
	
	

}
