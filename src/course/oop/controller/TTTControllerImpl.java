package course.oop.controller;

import course.oop.TTTgameRound;
import course.oop.TTThumanPlayer;
import course.oop.TTTplayer;

import java.util.ArrayList;

public class TTTControllerImpl implements TTTControllerInterface {

    TTTgameRound thisRound; //placeholder for the game round
    ArrayList<TTTplayer> players = new ArrayList<TTTplayer>(); //Auxiliary array for player creation

    public void startNewGame(int numPlayers, int timeoutInSecs){

    }

    public void createPlayer(String username, String marker, int playerNum){
        players.add(new TTThumanPlayer(username, playerNum, marker));
    }

    public boolean setSelection(int row, int col, int currentPlayer){
        return true;
    }

    public int determineWinner(){
        return 0;
    }

    public String getGameDisplay(){
        return thisRound.board().getArrayDisplay();
    }

}
