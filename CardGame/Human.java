/**
 * This class inherits all the attributes and methods of {@link Player Player}, it contains override methods
 * to make them more specific for a Human player. 
 * 
 * @author Alexander Finnigan (ID: 201084157)
 *
 */
public class Human extends Player {
	
	//------------------------------------METHODS------------------------------------------
	/**
	 * The constructor creates a deck of cards that will use the first 10 card names by using a <code>for-loop</code>.
	 * It utilises the {@link Player#addCard(Card)} method.
	 */
	public void createDecks(){
		for (int i = 0; i < 10; i++){
			addCard(new Card(cardNames[i]));
		}
	}
	
	/**
	 * This method stores the Human player's name after receiving it in the <code>parameter</code>.
	 * 
	 * @param input is the name of the player
	 */
	public void AskName(String input){
		playerName = input;
	}
	
	/**
	 * This method stores the input from Human on which attribute they wish to select and stores the value of
	 * that attribute in <code>attribNum</code>. It combines the methods {@link Queue#peek()} and {@link Card#getAtts(int)}.
	 * 
	 * @param input is the attribute number they have selected.
	 */
	public void ChooseAtts(int input){
		playerNum = input;
		attribNum = deck.peek().getAtts(playerNum);
	}
	
	
	/**
	 * This method prints the size of the Human players desk. It does this by using {@link Queue#size()}.
	 */
	public void CardsInDeck(){
		System.out.println("\n"+playerName+"'s Deck size: "+deck.size());
	}
	
	/**
	 * This method returns the attribute number the Human player has selected.
	 * 
	 */
	public int getAttribNum(){
		return playerNum;
	}
}
