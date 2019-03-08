package course.oop.main;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TTTDriver {

    private static Scanner in;
    private static String inputStr;
    private static int inputNum;

    public static void main(String[] args){
        in = new Scanner(System.in);
        int numOfPlayers = 0;
        String name1 = null;
        String name2 = null;
        boolean isValid = false;

        System.out.println("Welcome to two person 3X3 Tic Tac Toe. ");
        System.out.println("---------------------------------------");
        System.out.println("type 0 to quit");

        //Get number of players
        while(!isValid){
            System.out.print("Enter # of players (1 or 2): ");
            if(checkNumeric(in)){
                numOfPlayers = inputNum;
                if(!(inputNum == 1 || inputNum == 2)){
                    System.out.println("Invalid number, nust be 1 or 2");
                }else {
                    isValid = true;
                }
            }
        }

        //Get name of first player
        isValid = false;
        while(!isValid){
            System.out.print("Enter the name of the first player: ");
            if(checkString(in)){
                name1 = inputStr;
                isValid = true;
            }
        }

        //System.out.println(name1 + "   " + numOfPlayers);
    }

    public static boolean checkNumeric(Scanner userInput){
        try{
            inputNum = userInput.nextInt();
            String extraString = userInput.nextLine();
            if(extraString.trim().isEmpty()){
                if(inputNum == 0){
                    System.out.println("Game Quited ~");
                    System.exit(0);
                }
                return true;
            }else{
                System.out.println("Input invalid");
                return false;
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input.");
            userInput.next();
            return false;
        }
    }

    public static  boolean checkString(Scanner userInput){
        try{
            inputStr= userInput.nextLine();
            if(inputStr.trim().isEmpty()){
                System.out.println("Empty string ");
                return false;
            }
            return true;
        }catch(InputMismatchException e){
            int input = userInput.nextInt();
            if(input == 0){
                System.exit(0);
            }

            System.out.println("Invalid input");
            return false;

        }
    }
}
