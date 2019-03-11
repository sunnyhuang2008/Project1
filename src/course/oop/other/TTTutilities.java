package course.oop;

public class TTTutilities {

    public TTTutilities(){}

    public boolean checkValidInt(String num){
        try{
            int input = Integer.parseInt(num);
            if(input > Integer.MAX_VALUE || input < Integer.MIN_VALUE) return false;

            return true;

        }catch(NumberFormatException ex){
            return false;
        }
    }
}
