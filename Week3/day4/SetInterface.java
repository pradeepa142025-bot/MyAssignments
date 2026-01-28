package week3.day4;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String companyName = "google";
		char[] companyChar=companyName.toCharArray();
		Set<Character> nameset = new LinkedHashSet<Character>();
		for (Character name : companyChar) {
			nameset.add(name);
			
		}
		System.out.println(nameset);

	}

}
