/**
 * This class inherits all the attributes and methods of {@link Player Player}, it contains override methods
 * to make them more specific for a Random Computer player. 
 * 
 * @author Alexander Finnigan (ID: 201084157)
 *
 */
public class RandomComputer extends Player {
	
	//---------------------------------------METHODS------------------------------------------
	/**
	 * This method sets and stores the Random Computer players name.
	 */
	public void AskName(){
		System.out.println("\nPlease enter your name: \nRandom Computer");
		playerName = "Random Computer";
	}
	
	/**
	 * This method shows the Random Computer's card then randomly selects an attribute and storing it in
	 * <code>attribNum</code>. It draws the card with {@link Player#DrawCard()}; generates a random number
	 * with {@link Math#random()} and finds the value of the attribute with {@link Queue#peek()}.
	 */
	public void ChooseAtts(){
		// Shows card on the top of the deck
		DrawCard();
		// Asks which attribute to select
		System.out.println(playerName+",select an Attribute to compare: ");
		// Randomly generate a number between 1 and 4
		playerNum = (int) ((Math.random()) * 5);
		System.out.println(playerNum+"\n");
		// Stores the value
		attribNum = deck.peek().getAtts(playerNum);
	}
	
	/**
	 * This method returns the attribute number.
	 */
	public int getAttribNum(){
		return playerNum;
	}
	
	/**
	 * This method displays the number of cards in a players deck. It does this by using {@link Queue#size()}.
	 */
	public void CardsInDeck(){
		System.out.println(playerName+"'s Deck size: "+deck.size()+"\n");
	}
}
