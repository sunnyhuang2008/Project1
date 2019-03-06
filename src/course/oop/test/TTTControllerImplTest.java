package course.oop.test;

import course.oop.controller.TTTControllerImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class TTTControllerImplTest {

    TTTControllerImpl TTTController = new TTTControllerImpl();

    @Test
    public void startNewGame() {
        TTTController.createPlayer("Sam", "S", 1);
        TTTController.createPlayer("May", "M", 2);
        TTTController.startNewGame(3,10);
        assertEquals(null, TTTController.thisRound);
        TTTController.startNewGame(0,10);
        assertEquals(null, TTTController.thisRound);
        TTTController.startNewGame(-2,10);
        assertEquals(null, TTTController.thisRound);
    }

    @Test
    public void createPlayer() {
        TTTController.createPlayer("Sam", "MM", 1);
        assertEquals(0, TTTController.players.size());
        TTTController.createPlayer("Sam", "M", -1);
        assertEquals(0, TTTController.players.size());
        TTTController.createPlayer("Sam", "M", 3);
        assertEquals(0, TTTController.players.size());
        TTTController.createPlayer("Sam", "M", 0);
        assertEquals(0, TTTController.players.size());
        TTTController.createPlayer("Sam", "M", 1);
        assertEquals(1, TTTController.players.size());
    }

    @Test
    public void setSelection() {
        TTTController.createPlayer("Sam", "S", 1);
        TTTController.createPlayer("May", "M", 2);
        TTTController.startNewGame(2, 10);
        //Invalid inputs
        assertEquals(false, TTTController.setSelection(100,1,1));
        assertEquals(false, TTTController.setSelection(100,100,1));
        assertEquals(false, TTTController.setSelection(1,1,100));
        assertEquals(false, TTTController.setSelection(1,1,0));
        assertEquals(false, TTTController.setSelection(1,1,-100));
        assertEquals(false, TTTController.setSelection(1,1,0));
        assertEquals(false, TTTController.setSelection(-1,1,1));

        //Valid inputs
        assertEquals(true, TTTController.setSelection(1,1,1));
        assertEquals(true, TTTController.setSelection(1,0,2));

        //Valid Inputs, invalid positions (position taken)
        assertEquals(false, TTTController.setSelection(1,1,1));
        assertEquals(false, TTTController.setSelection(1,1,2));
        assertEquals(false, TTTController.setSelection(1,0,1));
        assertEquals(false, TTTController.setSelection(1,0,2));
    }

    @Test
    public void determineWinner() {
        TTTController.createPlayer("Sam", "S", 1);
        TTTController.createPlayer("May", "M", 2);
        TTTController.startNewGame(2, 10);
        for(int i = 0; i < TTTController.thisRound.board().size(); i ++){
            assertEquals(0, TTTController.determineWinner());
            TTTController.setSelection(i,i,1);
        }
        assertEquals(1, TTTController.determineWinner());
        TTTController.thisRound.board().clearBoard();

        for(int i = 0; i < TTTController.thisRound.board().size(); i++){
            assertEquals(0, TTTController.determineWinner());
            TTTController.setSelection(0, i, 2);
        }
        assertEquals(2, TTTController.determineWinner());
        TTTController.thisRound.board().clearBoard();
    }

    @Test
    public void getGameDisplay() {
        TTTController.createPlayer("Sam", "S", 1);
        TTTController.createPlayer("May", "M", 2);
        TTTController.startNewGame(2, 10);
        for(int i = 0; i < TTTController.thisRound.board().size(); i ++){
            TTTController.setSelection(i,i,1);
            TTTController.setSelection(2,i,2);
        }
        TTTController.getGameDisplay();
    }
}