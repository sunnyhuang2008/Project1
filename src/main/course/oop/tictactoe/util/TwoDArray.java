package main.course.oop.tictactoe.util;
import java.util.HashMap;

/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 *
 */
public class TwoDArray {
	
	private int arr[][];
	private int defaultVal;
	private HashMap <Integer, Integer> numberMap = new HashMap<>();
	
	public TwoDArray(int rows, int cols, int defaultVal){
		/*TODO - Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 * */
		this.arr = new int[rows][cols];
		this.defaultVal = defaultVal;
		this.initArray(this.defaultVal);
	}
	
	public void initArray(int defaultVal) {
		/*TODO - (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		this.defaultVal = defaultVal;
		for(int i = 0; i < this.arr.length; i++){
			for(int j = 0; j < this.arr[i].length; j++){
				this.arr[i][j] = this.defaultVal;
			}
		}
		this.numberMap.put(defaultVal, this.arr.length * this.arr[0].length);	
	}
	
	public String insertInt(int row, int col, int val) {
		/*TODO - "Insert" based on the following conditions:
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 * 
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 * 
		 * 3. val is the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 * 
		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		if(this.arr[row][col] == this.defaultVal){
			this.arr[row][col] = val;
			if(numberMap.containsKey(val)){
				numberMap.put(val, numberMap.get(val) +1);
			}else{
				//numberMap.put(this.defaultVal, numberMap.get(this.defaultVal) -1);
				numberMap.put(val, 1);
			}
			numberMap.put(this.defaultVal, numberMap.get(this.defaultVal) -1);

			return "Success!" + val + " was inserted.";
		}
		if(this.arr[row][col] != this.defaultVal){
			return "Failure: "+row+", "+col+" is not empty";
		}
		if(val == this.defaultVal){
			return "Failure: "+val+" is not allowed";
		}

		return null;
	}
	
	public int getInt(int row, int col) {
		/*TODO - Return the value at the specified row, col
		 * 
		 */

		return this.arr[row][col];
	}
	
	public String getArrayDisplay() {
		/*TODO - Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 * 
		 */

		for(int i = 0; i < this.arr.length; i++){
			for(int j = 0; j < this.arr[i].length; j++){
				System.out.print(this.arr[i][j] + "	");
			}
			System.out.println("");
		}
		
		return "complete";
	}
	
	public String getArrayDetails() {
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 
		 * 			)
		 * 
		 */
		String list = "\n";
		for(int val : numberMap.keySet()){
			//System.out.println("value:"+ val + " count:" +numberMap.get(val));
			list += "value:"+ val + " count:" +numberMap.get(val) +"\n";
		}

		return list;
	}		

}


