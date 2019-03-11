package course.oop.other;

public class TTTgameRound {
    private TTTplayer m_player1;
    private TTTplayer m_player2;
    private TTTboard m_board;

    public TTTgameRound(TTTplayer p_player1, TTTplayer p_player2, TTTboard p_board){
        m_player1 = p_player1;
        m_player2 = p_player2;
        m_board = p_board;
    }

    //getter methods
    public TTTboard board(){
        return m_board;
    }

    public TTTplayer player1(){
        return m_player1;
    }

    public TTTplayer player2(){
        return m_player2;
    }

}
