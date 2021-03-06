/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
 /*
Question:
When the keyword is included in another word the programs acts as if the keyword was used even when it wasn't meant to. In order to fix this, we can change
the function to look for the indexOf " no " with spaces on each side to signify it is a seperate word but this would not work if just "no" was inputed.
public class Magpie2
*/
public class Magpie2
{
	/**
	 * Get a default greeting
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 *
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	 /*
	 When inputted a sentence like "My mother has a dog but no cat" with multiple keywords, it prioritizes the earliest if/ifelse statments
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("dog")>=0
				|| statement.indexOf("cat") >= 0)
				{
					response = "Tell me more about your pets.";
				}
		else if (statement.indexOf("Mr. Mykolyk")>=0){
			response = "He sounds like a good teacher.";
		}
		else if (statement.trim().length() <= 0){
			response = "Say something, please.";
		}
		else if (statement.indexOf("love")>=0){
			response = "I love it too!";
		}
		else if (statement.indexOf("color")>=0){
			response = "What is your favorite color?";
		}
		else if (statement.indexOf("hate")>=0){
			response = "I agree.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Please stop talking."	;
		}
		else if (whichResponse == 5)
		{
			response = "I want to know more.";
		}
		return response;
	}
}
