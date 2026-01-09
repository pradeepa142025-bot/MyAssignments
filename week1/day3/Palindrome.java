package week1.day3;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Requirements: 
			 
	    -To reverse a number and check for palindrome, Declare two variables of int data type such as 
	    - ‘input’ to assign the given number 
	    - ‘output’ to store the reversed form of the input number  - Use for loop to reverse the digits of 'input'. - Finally, compare ‘input’ with ‘output’ to print whether the given input is a palindrome or not. 	
		
		Hints to solve:
       /*Implement a 'for' loop where the control variable ‘i’ starts with the value of the ‘input’ variable, continues as 
         long as ‘i’ is greater than 0, and update ‘i’ by dividing it by 10 in each iteration.  - Use appropriate operator to calculate the remainder by dividing the ‘input’ by 10. Assign this value to an integer        
         variable ‘rem’. - Use ‘if’ statement to compare the output with the given input.*/
		
		//Declaring a variable input with int datatype and intializing value to it
		int input=121;
		//Declaring a variable output with int datatype and intializing value as '0'
		int output=0;
		//Iterating for loop 
		for(int i=input;i>0;i=i/10)
		{
			  int rem=i%10;	
			  output=output*10+rem;  
		}
		    //To check whether the given number is palindrome or not
			if(input==output)
			{
				System.out.println("Given number is  a palindrome");
			}
				else 
				{
					System.out.println("Given number is not a palindrome");
				}
			}
				
		}