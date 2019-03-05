package course.oop.controller;

import course.oop.*;

import java.util.ArrayList;

public class TTTControllerImpl implements TTTControllerInterface {

    /*
    * For this to work, first create users using the create user function,
    * then use startNewGame to set current game round with the game board,
    * once these are done, other functions would work.
    * TODO: Implement tests for this interface, following the guidelines
    * TODO: Implement unit tests for other functions, the code is quite dependent
    * TODO: Implement main function to get logistics inplace after controller works
    */
    TTTgameRound thisRound; //placeholder for the game round
    ArrayList<TTTplayer> players = new ArrayList<TTTplayer>(); //Auxiliary array for player creation

    public void startNewGame(int numPlayers, int timeoutInSecs){
        if(numPlayers > 2 || numPlayers <= 0){
         System.out.println("Invalid amount of players");
         return;
        }

        TTTboard board = new TTTboard(1,2);
        if(numPlayers == 1){
            TTTcomputerPlayer computer = new TTTcomputerPlayer("Steve", 2, "X");
            thisRound = new TTTgameRound(players.get(0), computer, board);
            return;
        }

        if(numPlayers == 2)
            thisRound = new TTTgameRound(players.get(0), players.get(1), board);

        return;

    }

    public void createPlayer(String username, String marker, int playerNum){
        players.add(new TTThumanPlayer(username, playerNum, marker));
    }

    //Check if player is valid, row, col within bounds and space is available and set the value
    public boolean setSelection(int row, int col, int currentPlayer){
        return thisRound.board().checkValidPlayer(currentPlayer) && (thisRound.board().insertInt(row, col, currentPlayer) >= 0);
    }

    /*
    * If found winner for 1, return 1
    * If found winner for 2, return 2
    * If found grid lock (no moves available) return 3
    * If game not over, (no winners, still moves), return 0
    * */
    public int determineWinner(){
        if(thisRound.board().ultimateCheckWin(1) == 1)
            return 1;
        if(thisRound.board().ultimateCheckWin(2) == 2)
            return 2;
        if(thisRound.board().getAvaliable().size() == 0)
            return 3;
        return 0;
    }

    public String getGameDisplay(){
        return thisRound.board().getArrayDisplay();
    }

}
