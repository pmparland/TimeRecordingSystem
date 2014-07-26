package model;
/**
* <h1>Result of adding data to the system!</h1>
* Captures success or failure of adding people or 
* bookings and an error message indication
*<p>
*/
public class Result {
	public boolean result;
	public String message;
	public void displayResult (){
		if (this.result) System.out.print("true");
		else System.out.print("false");
		System.out.println(this.message);
	}
	public  Result(boolean r, String msg){
		this.result =r;
		this.message = msg;
	}

}
