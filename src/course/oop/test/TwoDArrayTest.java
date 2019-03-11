package course.oop.test;

import course.oop.other.TwoDArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoDArrayTest {
    TwoDArray twoD = new TwoDArray(3,3,0);

    @Test
    public void initArray() {
        System.out.println(twoD.getArrayDetails());
        twoD.getArrayDisplay();
    }

    @Test
    public void insertInt() {
        assertEquals(0, twoD.insertInt(0, 1,1 ));
        assertEquals(-1, twoD.insertInt(0,1,1));
        assertEquals(-2, twoD.insertInt(0,0,0));
    }

    @Test
    public void getInt() {
        twoD.insertInt(0, 1,1 );
        assertEquals(0, twoD.getInt(0,0));
        assertEquals(1, twoD.getInt(0,1));
    }
}