import java.util.*;

/**
 * This class will hold all the generic information for Players; such as creating a card deck, adding cards to the 
 * deck and drawing the cards. This class also contains a Predictable Computer Opponent. This opponent will only 
 * ever pick the first attribute on their card.
 * 
 * @author Alexander Finnigan (ID: 201084157)
 *
 */
public class Player {
	
	//-------------------------------ATTRIBUTES-----------------------------------------------
	/**
	 * This <code>queue</code> will be the deck of cards. The deck will be made up of <code>objects</code> of the class
	 * {@link Card Card}.
	 */
	protected Queue<Card> deck = new LinkedList<Card>();
	/**
	 * This <code>array</code> will contain all of the possible names for the cards. Since the theme is cars,
	 * each name will be a car model.
	 */
	protected String[] cardNames = {"FORD Fiesta", "TOYOTA Celica", "NISSAN 350Z", "LAMBORGHINI Aventador", "PORSCHE 911", "FERRARI 458", "ASTON MARTIN DB11", "AUDI TT", "BUGATTI Veyron", "BENTLEY Mulsanne", "BMW I8", "BUICK Encore", "CHEVROLET Camaro", "CHRYSLER 300", "CITROEN DS3", "DODGE Charger", "JAGUAR F-Type", "LEXUS RX", "MASERATI Ghibli", "MERCEDES-BENZ S-Class"};
	/**
	 * This <code>String</code> variable will store the name of the player which will be given by a later class.
	 */
	protected String playerName;
	/**
	 * This variable stores the variable number (i.e. the 1st, 2nd, 3rd, 4th variable) from user
	 * input in a later class.
	 */
	protected int playerNum;
	/**
	 * This variable stores the value of the attribute carried over by the <code>Card</code> <code>object</code>.
	 */
	protected int attribNum;
	
	//-----------------------------CONSTRUCTOR------------------------------------------------
	/**
	 * The constructor calls the method {@link #createDecks()} which populates the queue with Card objects.
	 */
	public Player(){
		createDecks();
	}
	
	//-------------------------------METHODS--------------------------------------------------
	/**
	 * This method will create card decks for any player in the game.
	 */
	public void createDecks(){
		for (int j = 10; j < 20; j++){
			addCard(new Card(cardNames[j]));
		}
	}
	
	/**
	 * This method adds a card to the deck using {@link Queue#add(Object)}.
	 * 
	 * @param playCard is the card that will be added to the deck.
	 */
	public void addCard(Card playCard){
		deck.add(playCard);
	}
	
	/**
	 * This method views the card at the top of the deck using {@link Queue#peek()}.
	 */
	public void DrawCard(){
		deck.peek().printCard();
	}
	
	/**
	 * This method asks for the Predictable Computer's name, then stores it.
	 */
	public void AskName(){
		System.out.println("Player 2, please enter your name: \nPredictable Computer");
		playerName = "Predictable Computer";
	}
	
	/**
	 * This method allows the Predictable Computer to select the first attribute. It does this by using 
	 * {@link #DrawCard()} to show the card then stores the 1st attributes value in <code>attribNum</code> by 
	 * combining {@link Queue#peek()} and {@link Card#getAtts(int)}. 
	 */
	public void ChooseAtts(){
		// Displays Card
		DrawCard();
		// Asks for the attribute
		System.out.println("\n"+playerName+", select an Attribute to compare: ");
		System.out.println("1\n");
		// Stores attribute
		attribNum = deck.peek().getAtts(1);
	}
	
	/**
	 * This method returns the attribute number (i.e. 1st, 2nd, 3rd, 4th attribute).
	 * 
	 * @return The attribute number.
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
