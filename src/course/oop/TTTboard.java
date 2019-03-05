package course.oop;
import java.util.ArrayList;

public class TTTboard extends TwoDArray{
    private int m_player1;
    private int m_player2;

    //constructor
    public TTTboard(int p_player1, int p_player2){
        super(3, 3,0);
        m_player1 = p_player1;
        m_player2 = p_player2;
    }

    //getter methods
    public int player1(){
        return this.m_player1;
    }

    public int player2(){
        return this.m_player2;
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
        evaluation: for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] != player)
                    break evaluation;
                if(j == arr.length-1)
                    return player;
            }
        }

        //check rows
        evaluation: for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[j][i] != player)
                    break evaluation;
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
    }

    public boolean checkValidPlayer(int playerNum){
        if(playerNum == m_player1 || playerNum == m_player2)
            return true;
        return false;
    }

}
