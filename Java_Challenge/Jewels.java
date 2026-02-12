package javapracticeprograms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Jewels {
	
	public static void main(String[] args)
	{
	
	int count=0;
	String jewels = "aA";
	String stones = "aAAbbbb";
	char[] jewelschar = jewels.toCharArray();
	char[] stoneschar = stones.toCharArray();
	Set<Character> jewelset = new LinkedHashSet<>();
	for(Character Jewelchars : jewelschar)
	{
		jewelset.add(Jewelchars);
	}
	for(Character Stones : stoneschar)
	{
		if(jewelset.contains(Stones))
		{
			count++;
		}
	}
	System.out.println(count);
	}
}





