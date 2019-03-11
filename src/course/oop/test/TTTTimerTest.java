package course.oop.test;

import course.oop.other.TTTTimer;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TTTTimerTest {

    public static void main(String [] args){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //Scanner in = new Scanner(System.in);
        TTTTimer timer = new TTTTimer(5);
        try{
            String num = null;
            System.out.println("Enter a number:");
            timer.start();
            //long startTime = System.currentTimeMillis();
            while(!timer.isTimeOut() && !in.ready()){
                //Do sth
            }

            if (in.ready()) {
                System.out.println("You entered: " + in.readLine());
            } else {
                System.out.println("You did not enter data");
            }

        }catch (IOException e){}catch (InterruptedException e){}
    }
}