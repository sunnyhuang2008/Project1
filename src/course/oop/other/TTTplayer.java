package course.oop;

public class TTTplayer {

    protected String m_name;
    protected int m_label;
    protected String m_marker;

    public TTTplayer(String p_name, int p_label, String p_marker){
        m_name = p_name;
        m_label = p_label;
        m_marker = p_marker;
    }

    //Getter methods
    public String name(){
        return m_name;
    }

    public int label(){
        return m_label;
    }

    public String marker(){
        return m_marker;
    }

}
