package week1.day3;

public class IsPrime {

	public static void main(String[] args) {
		
		//Iterate through all numbers from 2 to n-1 (input) and for every number check if it divides n (input).  
		//If we find any number that divides, print non-prime. 
		//If nothing divides, then print prime 
		
		int n=7;
		boolean prime=true;
		
		//{1,2,3,4,5,6,7} - It should be divisible by 1 & 7
		for(int i=2;i<n;i++)
		{
			if(n%i==0)
			{
				prime=false;
				break;
			}		
		}
		
		System.out.println(prime);
	}
}
