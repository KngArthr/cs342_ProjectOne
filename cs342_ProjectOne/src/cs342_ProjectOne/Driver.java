//---------------------------------------------------------------------------
//
//8 Queens Problem
//Solves the 8 Queens Problem
//
//Author: Mujahid Kazi
//Date: 03/11/2020
//Class: MET CS342
//Issues: None known
//
//Description:
//This program will place 8 queens on a chess board
//with no possibility of capturing each other.
//
//Assumptions:
//The board will be empty and exactly 8 queens will be required
//to fit on the board at once without being able to attack each other.
//
//Notes:
//The doStuff method in the Driver class is for reference only.
//I have scrapped that algorithm for a better one in 
//placeQueens and solveIt.

package cs342_ProjectOne;

//
//Class: Driver
//
//Description:
//Main Class where other classes and methods are used to put the program together.
//The class that drives this program.

public class Driver {
	
///////////////////////////////////////////////////////////////////
/// main ///
/// Input : String[] args ///
/// Output: None///
/// Runs the program. Key methods are placed in to the main method to run the program.
/// Will print results into the console.
/// ///
///////////////////////////////////////////////////////////////////


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();

		driver.solveIt();


	}
///////////////////////////////////////////////////////////////////
/// solveIt ///
/// Input : None///
/// Output: None///
/// Runs the program. Key methods are placed in to the main method to run the program. ///
/// ///
///////////////////////////////////////////////////////////////////
	
	public void solveIt() {
		
		LinkedStack queenStack = new LinkedStack();
		
		//create chessboard with 8 rows and 8 columns
		//program is created with the assumption that the chessboard is 8x8
		ChessBoard chessBoard = new ChessBoard(8, 8);
				
		
		//System.out.println(queenStack);
		//chessboard.printChessBoard(queenStack);
		
		if((placeQueens(queenStack, chessBoard, 0)) == false) {
			//if queens are not able to placed on board, return the following statement.
			System.out.println("Not Possible");
			
		}else {
			//if all queens are non-conflicting then display the data
			//as both a stack and on a chessboard.
			System.out.println("Final Solution:");
			chessBoard.printChessBoard(queenStack);
			System.out.println(queenStack);

			
		}
		
	}
///////////////////////////////////////////////////////////////////
/// placeQueens ///
/// Input : LinkedStack, ChessBoard, column ///
/// Output: true or false///
/// Uses recursion and backtracking to solve the queens problem.
///	Adds queens on a column by column bases and adjusts row if there are conflicts
/// 
/// ///
///////////////////////////////////////////////////////////////////
	
	boolean placeQueens(LinkedStack queenStack, ChessBoard chessBoard, int column) {
		///**ChessBoard included for testing purposes
		
		//base case, so it does not run infinitely. When does it need to stop?
		if(column >= chessBoard.getMAX_COLUMN()) {//when 8 queens are placed on the 8 column board.
			return true;
		}
		
		//cycle through rows
		for(int i = 0; i < chessBoard.getMAX_ROW(); i++) {
			
			Queen queen = new Queen(i, column);//create the queen for that column
			
			queenStack.push(queen);//push it to the stack
			
			
			///**Testing purposes
			//System.out.println(queenStack);
			//chessBoard.printChessBoard(queenStack);

			
			if(!chessBoard.isConflictStack(queenStack)) {
				//If there is no conflict with the queens in the stack, keep the queen
				
				if(placeQueens(queenStack, chessBoard, column + 1)) {
					//function will recur for next column. If it is able to place a queen
					//in the next column then it will return true.
					return true;
				}
				
			
			}
			
			//if queen is not able to be placed, then queen is removed.
			queenStack.pop();

				
		}
			
		//if queens cannot be placed, return false.
		return false;
	}
	

	
	

	
///////////////////////////////////////////////////////////////////
	
///*****THIS METHOD IS FOR REFERENCE ONLY.******	
///******THIS METHOD WILL NOT BE USED IN THE PROGRAM.******	
	
/// doStuff ///
/// Input : None///
/// Output: None///
/// I attempted an algorithm where I check the squares 1 by 1 but failed. It got too complicated for me///
/// which is why I resorted to recursion which is simpler, and cleaner.
///
/// ///
///////////////////////////////////////////////////////////////////
	
	
	public void doStuff() {
		
		LinkedStack queenStack = new LinkedStack();
		
		ChessBoard chessBoard = new ChessBoard(8, 8);
		
		boolean isSuccess = false;
		
		
		int incrementorJ = 0;
		int incrementorI = 0;
		
		while((!isSuccess || !queenStack.isEmpty())) {
			
			int counter = 0;
			while(counter < 9) {
				
				counter++;

				for(int i = 0; i < chessBoard.getMAX_ROW(); i++) {
					
					for(int j = 0; j < chessBoard.getMAX_COLUMN(); j++) {
						Queen queen;
						
						if(counter == 1) {

							queen = new Queen(i + incrementorI, j + incrementorJ);

						}else {
							queen = new Queen(i , j);
						}
						
						
						queenStack.push(queen);
						
						isSuccess = !chessBoard.isConflictStack(queenStack);//success if there are no conflicts in the stack
						
						System.out.println("Incrementor J: " + incrementorJ);
						System.out.println("Incrementor I: " + incrementorJ);

						System.out.println("isSuccess?: " + isSuccess);
						System.out.println("Counter: " + counter);
						System.out.println("I is: " + i + " and J is: " + j);

						System.out.println(queenStack);
						System.out.println(counter);

						chessBoard.printChessBoard(queenStack);


						if(isSuccess == false) {
							queenStack.pop();// if there is no success then pop the last added queen to remove the conflict
						}else {
							break;
						}

					}
					if(isSuccess == true) {
						break;
					}
					

				}
				
			}
			if(isSuccess == false) {
				queenStack.clear();

			}
			incrementorJ += 1;
			if(incrementorJ > 7) {
				incrementorI += 1;
				incrementorJ = 0;
			}
			
			if(incrementorI > 7) {
				break;
			}

			
			
			
		}

		
		//Queen queen1 = new Queen(1, 2);
		//Queen queen2 = new Queen(5, 6);

		
		//queenStack.push(queen1);
		//queenStack.push(queen2);
		
		//System.out.println(queenStack.peek());

		
		//queenStack.pop();


		//System.out.println(queenStack.readStack(0));

		System.out.println(queenStack);
		chessBoard.printChessBoard(queenStack);
		
		//System.out.println(chessBoard.isConflictStack(queenStack));
		
		
		
		
		
	}
	


}
