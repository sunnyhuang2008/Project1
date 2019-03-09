package course.oop.main;

import course.oop.controller.TTTControllerImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TTTDriver {

    private static Scanner in;
    private static String inputStr;
    private static int inputNum;
    private static TTTControllerImpl controller = new TTTControllerImpl();
    private static int turnCounter = 1;
    private static int x_coordinate;
    private static int y_coordinate;

    public static void main(String[] args){
        in = new Scanner(System.in);
        int numOfPlayers = 0;

        //User creation variables
        String name1 = null;
        String name2 = null;
        String marker1 = null;
        String marker2 = null;

        //Variable key to safe guard input verification
        boolean isValid = false;

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
        controller.startNewGame(numOfPlayers,10);

        //Start the game
        System.out.println("Let the game begin!");
        System.out.println("The first player will go first");
        System.out.println(controller.player(turnCounter-1)+ ", its your turn!");

        while(controller.determineWinner() == 0){
            controller.getGameDisplay();
            isValid = false;

            //prompt the user for position input
            while(!isValid){
                if(numOfPlayers == 1 && turnCounter== 2){
                    //computer generate moves
                    isValid = controller.computerGenerateMove();

                    if(isValid) {
                        System.out.println(controller.player(1) +" move generated, "+ controller.player(0) +", hit me with your best shot!");
                        alternateTurn();
                    }

                }else{
                    isValid = promptHumanMoves();
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

    public static  boolean promptHumanMoves(){
        System.out.println(controller.player(turnCounter-1)+ ", please input your row coordinate");

        if(checkNumeric(in) && inputNum >= 0 && inputNum <= 3){
            x_coordinate = inputNum;
            System.out.println(controller.player(turnCounter-1)+ ", please input your column coordinate");

            //eval is y is valid
            if(checkNumeric(in) && inputNum >= 0 && inputNum <= 3){
                y_coordinate = inputNum;

                //Eval if spot is taken
                if(controller.setSelection(x_coordinate,y_coordinate,turnCounter)){

                    System.out.println("Success!");

                    //alternate turns
                    alternateTurn();

                    return true;

                }else{
                    System.out.println("Try again, the spot is taken.");
                }

            }else{
                System.out.println("Column coordinate is invalid, needs to be int between 0 and 3");
            }
        }else{
            System.out.println("Row coordinate is invalid, needs to be int between 0 and 3");
        }

        return false;
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
