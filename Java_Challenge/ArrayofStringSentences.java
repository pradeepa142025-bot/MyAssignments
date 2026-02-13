package javapracticeprograms;

public class ArrayofStringSentences {

	public static void main(String[] args) {
		
		/*Example 1:

			Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
			Output: 6
			Explanation: 
			- The first sentence, "alice and bob love leetcode", has 5 words in total.
			- The second sentence, "i think so too", has 4 words in total.
			- The third sentence, "this is great thanks very much", has 6 words in total.
			Thus, the maximum number of words in a single sentence comes from the third sentence, which has 6 words

*/
	int count=0;	
	String[] Sentences= {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
	for(String sentences : Sentences)
	{
		int words=sentences.split(" ").length;
		if(words>count)
		{
			count=words;
		}
	}
	System.out.println(count);
	}
	
}