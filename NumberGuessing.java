import java.util.Scanner;

public class NumberGuessing {

	/** Wait for user to guess a number, use types "ready" to begin the game.
	 * This program assumes user guesses a number between 1 and 1000 inclusive
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Guess a number between 1 and 1000 (inclusive) and type \"ready\" to start the game!");
		int min = 1, max = 1000;
		String strReady = input.nextLine();
		while(!strReady.equalsIgnoreCase("ready")){
			System.out.println("Please type \"ready\" to start the game.");
			strReady = input.nextLine();
		}
		searchNumber(min, max);
	}
	
	/** Get user input and use binary search algorithm to hunt for the number within the range 
	 * @param min
	 * @param max
	 */
	private static void searchNumber(int min, int max){
		int midway = (max + min) / 2 ;
		System.out.format("Is the Number %d?", midway);
		System.out.println();
		Scanner input = new Scanner(System.in);
		String highLow = input.nextLine();
		while(!highLow.equalsIgnoreCase("higher") && !highLow.equalsIgnoreCase("lower")
				&& !highLow.equalsIgnoreCase("yes")&& !highLow.equalsIgnoreCase("end")){
			System.out.println("Please type \"higher\"|\"lower\"|\"yes\"|\"end\".");
			highLow = input.nextLine();
		}
		if(highLow.equalsIgnoreCase("higher")){
			searchNumber(midway + 1, max);
		} else if(highLow.equalsIgnoreCase("lower")){
			searchNumber(min, midway - 1);
		} else {
			return;
		}
	}

}
