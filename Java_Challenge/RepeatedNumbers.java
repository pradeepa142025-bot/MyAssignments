package javapracticeprograms;

import java.util.LinkedHashSet;
import java.util.Set;

public class RepeatedNumbers {

	public static void main(String[] args) {
		
		int Inputarr[] = {-3,0,1,-3,1,1,1,-3,10,0};
		//{1,2,2,1,1,3};		
		Set<Integer> inputset=new LinkedHashSet<>();
		
		for(Integer numbers : Inputarr)
		{
			if(inputset.contains(numbers))
			{
				System.out.println(true);
				return;
				
			}
		inputset.add(numbers);
		}
		
		System.out.println(false);
	}

}
