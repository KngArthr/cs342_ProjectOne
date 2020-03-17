package cs342_ProjectOne;

//
//Class: Queen
//
//Description:
//Queen object to store row and column
//

public class Queen {
	
	private int row;
	
	private int column;
	
///////////////////////////////////////////////////////////////////
/// Queen ///
/// Input : row and column integers ///
/// Output: none///
/// creates queen object
/// initializes row and column of queen ///
/// ///
///////////////////////////////////////////////////////////////////
	
	public Queen(int row, int column) {
		
		this.row = row;
		this.column = column;
		
		
	}
///////////////////////////////////////////////////////////////////
/// setRowColumn ///
/// Input : row and column integers ///
/// Output: none///
/// Modifies row and column of existing queen ///
/// ///
///////////////////////////////////////////////////////////////////
	
	
	//set both row and column for queen
	public void setRowColumn(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	
///////////////////////////////////////////////////////////////////
/// General getters and setters ///
///
/// General Getters and setters for row and column attributes///
/// ///
///////////////////////////////////////////////////////////////////

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	
	
	

}
