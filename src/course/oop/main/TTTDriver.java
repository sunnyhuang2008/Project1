package course.oop.main;

import course.oop.controller.TTTControllerImpl;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TTTDriver {

    private static Scanner in;
    private static BufferedReader userInput;
    private static String inputStr;
    private static int inputNum;
    private static TTTControllerImpl controller = new TTTControllerImpl();
    private static int turnCounter = 1;
    private static int x_coordinate;
    private static int y_coordinate;
    //Variable key to safe guard input verification
    private static boolean isValid = false;

    public static void main(String[] args){
        in = new Scanner(System.in);
        userInput = new BufferedReader(new InputStreamReader(System.in));
        int numOfPlayers = 0;

        //User creation variables
        String name1 = null;
        String name2 = null;
        String marker1 = null;
        String marker2 = null;
        int timeoutSec = 0;



        System.out.println("Welcome to two person 3X3 Tic Tac Toe. ");
        System.out.println("---------------------------------------");
        System.out.println("type 404 to quit");

        //Get number of players
        while(!isValid){
            System.out.print("Enter # of players (1 or 2): ");
            if(checkNumeric(in)){
                numOfPlayers = inputNum;
                if(!(inputNum == 1 || inputNum == 2)){
                    System.out.println("Invalid number, must be 1 or 2");
                }else {
                    isValid = true;
                }
            }
        }

        //Get time out seconds
        isValid = false;
        while(!isValid){
            System.out.print("Enter seconds for time out: ");
            if(checkNumeric(in)){
                timeoutSec = inputNum;
                if(inputNum > 100){
                    System.out.println("Too long of a game, try less than 100 seconds");
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

        //Get Marker for the first player
        isValid = false;
        while (!isValid){
            System.out.println("Enter the marker of the first player: ");
            if(checkString(in) && inputStr.length() == 1){
                marker1 = inputStr;
                isValid = true;
            }else{
                System.out.println("Marker must be one character long");
            }
        }

        if(numOfPlayers == 2){
            //Get name of second player
            isValid = false;
            while(!isValid){
                System.out.print("Enter the name of the second player: ");
                if(checkString(in)){
                    name2 = inputStr;
                    isValid = true;
                }
            }

            //Get Marker for the first player
            isValid = false;
            while (!isValid){
                System.out.println("Enter the marker of the second player: ");
                if(checkString(in) && inputStr.length() == 1 && !inputStr.equalsIgnoreCase(marker1) && !inputStr.contentEquals("0")){
                    marker2 = inputStr;
                    isValid = true;
                }else{
                    System.out.println("Marker must be one character long and different from "+ marker1);
                }
            }

            //create two human players
            controller.createPlayer(name1,marker1,1);
            controller.createPlayer(name2,marker2,2);

        }else {
            //just create one human player
            controller.createPlayer(name1,marker1,1);
        }

        //game round created
        controller.startNewGame(numOfPlayers,timeoutSec);

        //Start the game
        System.out.println("Let the game begin!");
        System.out.println("The first player will go first");


        while(controller.determineWinner() == 0){
            controller.getGameDisplay();

            isValid = false;

            //prompt the user for position input

            if(numOfPlayers == 1 && turnCounter== 2){
                //computer generate moves
                isValid = controller.computerGenerateMove();

                if(isValid) {
                    System.out.println(controller.player(1) +" move generated, "+ controller.player(0) +", hit me with your best shot!");
                    alternateTurn();
                }

            }else{
                System.out.println(controller.player(turnCounter-1)+ ", its your turn! Enter your coordinates as \"x y\" on command line");
                //Prompt user to move
                if(controller.timeout == 0){
                    while(!isValid){
                        try{
                            getHumanMoves(userInput);
                        }catch (IOException e){
                            System.out.println(e);
                        }
                    }
                }else{

                    long startTime = System.currentTimeMillis();
                    while (!isValid && (System.currentTimeMillis() - startTime) < controller.timeout * 1000)
                    {
                        try{
                            getHumanMoves(userInput);
                        }catch (IOException e){
                            System.out.println(e);
                        }
                    }

                    if(!isValid){
                        System.out.println("Time is up. You cannot make move for now.");
                        isValid = true;
                        alternateTurn();
                    }
                }
            }
        }

        controller.getGameDisplay();

        if(controller.determineWinner() != 3){
            System.out.println("Congrats "+controller.player(controller.determineWinner()-1)+"! You win!");
        }else{
            System.out.println("No one wins");
        }

    }
    public static void alternateTurn(){
        //alternate turns
        if(turnCounter == 1)
            turnCounter = 2;
        else
            turnCounter = 1;
    }

    public static void getHumanMoves(BufferedReader in) throws IOException{
        //If we have input
        if(in.ready()){
            String inputStr = (in.readLine()).trim();
            String [] inputStrings = inputStr.split("\\s+");

            //Check if there are two inputs
            if(inputStrings.length == 2){
                try{
                    x_coordinate = Integer.parseInt(inputStrings[0]);
                    y_coordinate = Integer.parseInt(inputStrings[1]);

                    if(!(x_coordinate  >= 0 && x_coordinate <= 3)){
                        System.out.println("column coordinate is invalid, needs to be int between 0 and 3");
                    }else if(!(y_coordinate  >= 0 && y_coordinate <= 3)){
                        System.out.println("row coordinate is invalid, needs to be int between 0 and 3");
                    }else if(controller.setSelection(y_coordinate, x_coordinate, turnCounter)){
                        System.out.println("Success!");
                        //alternate turns
                        alternateTurn();
                        isValid = true;
                    }else{
                        System.out.println("Try again, the spot is taken.");
                        isValid = false;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Invalid inputs, please enter numbers.");

                }
            }else if(inputStrings.length == 1 && inputStrings[0].equalsIgnoreCase("404")){
                System.out.println("Game Quitted ~");
                System.exit(0);
            }else{
                System.out.println("Invalid input, please enter column and row");
                isValid = false;
            }
        }
    }

    public static boolean checkNumeric(Scanner userInput){
        try{
            inputNum = userInput.nextInt();
            String extraString = userInput.nextLine();
            if(extraString.trim().isEmpty()){
                if(inputNum == 404){
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
            if(input == 404){
                System.exit(0);
            }

            System.out.println("Invalid input");
            userInput.next();
            return false;

        }
    }
}
