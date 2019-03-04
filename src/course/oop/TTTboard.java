package course.oop;

public class TTTboard extends TwoDArray{ //maybe inherit from 2D array
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

    //Board Specific Methods
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

        return 0;
    }

    public void clearBoard(){
        initArray(0);
    }
}
