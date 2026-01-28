package javapracticeprograms;

public class LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Java Challenge (1/20)
		Given a string s consisting of words and spaces, return the length of the last word in the string.
		A word is a maximal substring consisting of non-space characters only.

		Example 1:

		Input: s = "Hello World"
		Output: 
		Explanation: The last word is "World" with length 5.
		Example 2:

		Input: s = "   fly me   to   the moon  "
		Output: 4
		Explanation: The last word is "moon" with length 4.
		Example 3:

		Input: s = "luffy is still joyboy"
		Output: 6
		Explanation: The last word is "joyboy" with length 6
		*/
		//Declared and initialized the input
		String input = "luffy is still joyboy";
		//Used Regular expression to remove the spaces
		String[] wordsSplitted=input.split("\\s+");//
		//After splitted checked the length of the splitted words
		System.out.println(wordsSplitted.length);
		//Declaring the lastWordLength as an empty string
		String lastWordLength="";
		//Iterate the words by using for each loop
		for (String wordLength : wordsSplitted) {
			//To check wordLength is empty or not 
			if(!wordLength.isEmpty())
			{
				lastWordLength=wordLength;
			}
		}
		//Printed the lastWordLength
		System.out.println(lastWordLength.length());
	}

}
