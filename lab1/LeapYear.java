// Adapted from Sierra and Bates, Head First Java

// You need not use all of the lines below, and you may use duplicates.
public class LeapYear{
	public static void main (String[] args){
		int year=2000;
		if (args.length!=0)
			year=Integer.parseInt(args[0]);
		if((year%4==0 && year%100!=0)||(year%400==0))
			System.out.println(year + " is LeapYear");
		else
			System.out.println(year + " is not LeapYear");
	}
}