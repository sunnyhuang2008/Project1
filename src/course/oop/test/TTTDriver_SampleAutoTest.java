package course.oop.test;

import course.oop.controller.TTTControllerImpl;

public class TTTDriver_SampleAutoTest {

	private static void checkForInvalidLocation(boolean isSelectionValid) {
		if(!isSelectionValid) {
			System.out.println("Invalid location selected by player");
		}
	}
	
	public static void sampleTestCase() {
		TTTControllerImpl ticTacToe = new TTTControllerImpl();
		String player_1 = "Ashley";
		String player_2 = "James";
		ticTacToe.createPlayer(player_1, "O", 1);
		ticTacToe.createPlayer(player_2, "X", 2);
		boolean isSelectionValid = true;
		
		// initialize
		ticTacToe.startNewGame(2, 0);
		System.out.println(ticTacToe.getGameDisplay());
		
		//play game
		isSelectionValid = ticTacToe.setSelection(0, 0, 1);
		checkForInvalidLocation(isSelectionValid);
		System.out.println(ticTacToe.getGameDisplay());
		isSelectionValid = ticTacToe.setSelection(0, 2, 2);
		checkForInvalidLocation(isSelectionValid);
		System.out.println(ticTacToe.getGameDisplay());
		isSelectionValid = ticTacToe.setSelection(1, 0, 1);
		checkForInvalidLocation(isSelectionValid);
		System.out.println(ticTacToe.getGameDisplay());
		isSelectionValid = ticTacToe.setSelection(1, 2, 2);
		checkForInvalidLocation(isSelectionValid);
		System.out.println(ticTacToe.getGameDisplay());
		isSelectionValid = ticTacToe.setSelection(2, 0, 1);
		checkForInvalidLocation(isSelectionValid);
		System.out.println(ticTacToe.getGameDisplay());
		
		//determine winner
		int winner = ticTacToe.determineWinner();
		if(winner==1) {
			System.out.println(player_1 + " won the game!!");
		}else {
			System.out.println("Failed Test Case");
		}
	}
	
	public static void main(String[] args) {
		sampleTestCase();
	}
	
}
