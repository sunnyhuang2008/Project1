package course.oop;

public class TTTTimer {
    private int m_timeout;
    private boolean m_isTimeOut;

    public TTTTimer(int p_timeout){
        m_timeout = p_timeout;
        m_isTimeOut = false;
    }

    //Getter
    public boolean isTimeOut(){ return m_isTimeOut;}

    public void start() throws InterruptedException{
        Thread thread = new Thread();
        for(int i = m_timeout; i >= 0; i--){
            thread.sleep(1000);
        }

        m_isTimeOut = true;
    }

    public void reset(){
        m_isTimeOut = false;
    }

}
