package week1.day3;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    //Requirements: 
	//   1.User input for the desired range of the Fibonacci series. 
	//  2.Displaying the generated Fibonacci series as the program output – 0, 1, 1, 2, 3, 5, 8, and 13.
		
		//Adding a+b values results in Fibonacci series
		//Formula to proceed further:0+1=1,1+1=2,2+3=3,3+5=8,5+8=13,
		//Declaring and intializing a values to the variable
		int fibo,a=0,b=1,c;	
		//Print the statement for Fibonacci series
	    System.out.println("Fibonacci series are: ");
	    //Using For loop iterating the values and printing the result of a
	    for(int i=0;i<8;i++)
	    {
	    	System.out.println(a);	
	    	fibo=a+b;
	    	a=b;
	    	b=fibo;
	    	
	    }
	}

}
