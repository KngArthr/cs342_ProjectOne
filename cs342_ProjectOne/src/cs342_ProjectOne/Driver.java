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
//The board will be empty and exactly 8 queens will be required.
//to fit on the board at once.

package cs342_ProjectOne;

//
//Class: Driver
//
//Description:
//Main Class where other classes and methods are used
//

public class Driver {
	
///////////////////////////////////////////////////////////////////
/// main ///
/// Input : String[] args ///
/// Output: print results///
/// Puts program together ///
/// ///
///////////////////////////////////////////////////////////////////


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();

		
		//driver.doStuff();
		driver.doStuff2();


	}
	
	public void doStuff2() {
		
		LinkedStack queenStack = new LinkedStack();
		ChessBoard chessBoard = new ChessBoard(8, 8);
		
		boolean isSuccess = false;
		
		
		//System.out.println(queenStack);
		//chessboard.printChessBoard(queenStack);
		
		if((solveQueen(queenStack, chessBoard, 0)) == false) {
			System.out.println("Not Possible");
		}else {
			System.out.println("Final Solution:");
			chessBoard.printChessBoard(queenStack);
			
		}
		

		
		

		
	}
	
	boolean solveQueen(LinkedStack queenStack, ChessBoard chessBoard, int column) {
		
		//base case, so it does not run infinitely
		if(column >= 8) {
			return true;
		}
		
		//cycle through rows
		for(int i = 0; i < 8; i++) {
			
			Queen queen = new Queen(i, column);
			
			queenStack.push(queen);
			
			//System.out.println(queenStack);
			//chessBoard.printChessBoard(queenStack);

			
			if(!chessBoard.isConflictStack(queenStack)) {
				//keep the queen
				
				if(solveQueen(queenStack, chessBoard, column + 1)) {
					return true;
				}
				
				//queenStack.pop();

				
			
			}
				
			queenStack.pop();

				
		}
			
	
		return false;
	}
	

	
	

	
///////////////////////////////////////////////////////////////////
/// doStuff ///
/// Input : None///
/// Output: None///
/// Does all the stuff. Methods and classes will be used here///
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
