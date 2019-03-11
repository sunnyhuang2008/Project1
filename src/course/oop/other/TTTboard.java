package course.oop.other;

import java.util.ArrayList;

public class TTTboard extends TwoDArray {
    private String [] players;

    //constructor
    public TTTboard(String player1Marker, String player2Marker){
        super(3, 3,0);
        players = new String [] {player1Marker, player2Marker};
    }

    public int size(){
        return arr.length;
    }

    //get available moves currently: Use to generate moves for computer
    public ArrayList<int []> getAvaliable(){
        ArrayList <int[]> result = new ArrayList<int []>();

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == 0){
                    int [] res = {i,j};
                    result.add(res);
                }

            }
        }

        return result;
    }


    //Board Specific Methods

    //Ultimate checkwin
    /*
    * returns the player number if the player won in any scenario
    * returns 0 if no wins by this player has been detected
    * */
    public int ultimateCheckWin(int player){

        //check columns
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] != player)
                    break;
                if(j == arr.length-1)
                    return player;
            }
        }

        //check rows
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[j][i] != player)
                    break;
                if(j == arr.length-1)
                    return player;
            }
        }

        //check diagonal
        for(int i = 0; i < arr.length; i++){
            if(arr[i][i] != player)
                break;
            if(i == arr.length-1)
                return player;
        }

        //check anti diagonal
        for(int i = 0; i < arr.length; i++){
            if(arr[i][arr.length-1-i]!=player)
                break;
            if(i == arr.length-1)
                return player;

        }

        return 0;
    }

    //check step by step
    public int checkWin(int player, int x, int y){
        //check columns
        for(int i = 0; i < arr.length; i ++){
            if(arr[x][i] != player)
                break;
            if(i == arr.length -1)
                return player;
        }

        //check row
        for(int i = 0; i < arr.length; i++){
            if(arr[i][y] != player)
                break;
            if(i == arr.length -1)
                return player;
        }

        //check diagonal
        if(x == y){
            for(int i = 0; i < arr.length; i++){
                if(arr[i][i] != player)
                    break;
                if(i == arr.length-1)
                    return player;
            }
        }

        //check anti diagonal
        if(x + y == arr.length-1){
            for(int i = 0; i < arr.length; i++){
                if(arr[i][arr.length-1-i]!=player)
                    break;
                if(i == arr.length-1)
                    return player;

            }
        }

        //check if no more avaliable spaces
        if(getAvaliable().size() == 0){
            return 3;
        }

        return 0;
    }

    public void clearBoard(){
        initArray(0);
        return;
    }

    public boolean checkValidPlayer(int playerNum){ // TODO: Not extendable, need to change
        if(playerNum == 1 || playerNum == 2)
            return true;
        return false;
    }

    public String display(){
        String result = "";

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == 1){
                   // System.out.format("%10s",players[0]);
                    result = result + players[0] + "   ";
                }
                else if(arr[i][j] == 2) {
                  //  System.out.format("%10s",players[1]);
                    result = result + players[1] + "   ";
                }else{
                 //   System.out.format("%10s","0");
                    result = result + "0" + "   ";
                }
            }
          //  System.out.println("");
            result = result + "\n";
        }
        return result;
    }
}
