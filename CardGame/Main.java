import java.util.Scanner;

/**
 * This class acts as the main method for the card game and will handle the majority of user input.
 * It uses an instance of {@link Game Game} which is determined by input from the user.
 * 
 * @author Alexander Finnigan (ID: 201084157)
 *
 */
public class Main {
	
	//--------------------------MAIN METHOD-----------------------------
	/**
	 * The main method that will create an instance of the card game.  It uses the methods {@link Human#AskName()}, 
	 * {@link Game#AskCompName()} and {@link Game#GameProgress()}.
	 * 
	 * @param args is the usual parameter used in main methods.
	 */
	public static void main(String[] args) {
		
		// Instantiate the Scanner
		Scanner input = new Scanner(System.in);
		
		// Introduce player to the game
		System.out.println("WELCOME TO THE CAR CARD GAME!");
		// Ask player which Computer they which to play against
		System.out.println("\nPlease select which computer you wish to play against: ");
		System.out.println("Predictable Computer  OR  Random Computer");
		System.out.println("(Type '1' for Predictable Computer) (Type '2' for Random Computer)");
		int choice = input.nextInt();
		// Validation check
		while ((choice != 1) && (choice != 2)){
			System.out.println("\nPlease select a number between 1 and 4...");
			choice = input.nextInt();
		}
		
		// Instantiate Game class
		Game game = new Game(choice);
		
		// Ask Player to enter their name
		System.out.println("\nPlayer 1, please enter your name: ");
		String name = input.next();
		game.human.AskName(name);
		// Sets Computer player's name
		game.AskCompName();
		
		// Calls the main game method
		game.GameProgress();
		
		// Close the Scanner
		input.close();
	}

}
