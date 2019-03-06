package course.oop.test;

import course.oop.TTTboard;
import org.junit.Test;

import static org.junit.Assert.*;

public class TTTboardTest {

    TTTboard twoD = new TTTboard("M", "F");

    @Test
    public void getAvaliable(){
        for(int i = 0; i < twoD.size(); i++){
            twoD.insertInt(i,i,1);
            assertEquals(9-i-1, twoD.getAvaliable().size());
        }
    }

    @Test
    public void checkWin(){
        //check a row
        for(int i = 0; i < twoD.size(); i++){
            assertEquals(0, twoD.checkWin(1, 0, i));
            twoD.insertInt(0, i, 1);
        }
        assertEquals(1, twoD.checkWin(1, 0, twoD.size()-1));

        twoD.clearBoard();

        //check a column
        for(int i = 0; i < twoD.size(); i++){
            assertEquals(0, twoD.checkWin(2, i, 0));
            twoD.insertInt(i, 0, 2);
        }
        assertEquals(2, twoD.checkWin(2,twoD.size()-1, 0));

        twoD.clearBoard();

        //check a diagonal
        for(int i = 0; i < twoD.size(); i++){
            assertEquals(0, twoD.checkWin(3, i, i));
            twoD.insertInt(i, i, 3);
        }
        assertEquals(3, twoD.checkWin(3,twoD.size()-1, twoD.size()-1));

        twoD.clearBoard();

        //check anti-diagonal
        for(int i =0; i < twoD.size(); i++){
            assertEquals(0, twoD.checkWin(4, i, twoD.size()-1-i));
            twoD.insertInt(i,twoD.size()-i-1, 4);
        }
        assertEquals(4, twoD.checkWin(4,twoD.size()-1, 0));

    }
}