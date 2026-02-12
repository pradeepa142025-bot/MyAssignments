package javapracticeprograms;

import java.util.LinkedHashSet;
import java.util.Set;

public class RepeatedCharacter {

	public static void main(String[] args) {
		
		String input ="abcdd";
		char[] inputchar=input.toCharArray();
		Set<Character> inputset=new LinkedHashSet<>();
		for(Character inputname: inputchar)
		{
			if(inputset.contains(inputname))
			{
				System.out.println(inputname);
				return;
			}
			
			inputset.add(inputname);
		}

	}

}
