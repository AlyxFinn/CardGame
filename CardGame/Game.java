import java.util.Scanner;

/**
 * This class handles the main logic for the card game such as the progress of the game, deciding who won the
 * round and if the game has been won. It includes methods from {@link Player Player}, {@link Human Human} and 
 * {@link RandomComputer RandomComputer}.
 * 
 * @author Alexander Finnigan (ID: 201084157)
 *
 */
public class Game {
	
	//Scanner is instantiated for use in the class
	Scanner input = new Scanner(System.in);
	
	//-------------------------------------ATTRIBUTES-------------------------------------
	/**
	 * This <code>integer</code> variable holds the value of the attribute that was chosen by a player.
	 */
	public int compared;
	/**
	 * This <code>boolean</code> variable contains <code>false</code> if the game has not been won or
	 * contains <code>true</code> if the game has been won.
	 */
	public boolean win;
	/**
	 * This <code>integer</code> variable decides who's turn it is; <code>1</code> if it is the Human's
	 * turn, <code>2</code> if it is the Computer's turn.
	 */
	public int turn = 1;
	/**
	 * This <code>boolean</code> variable decides whether a Random Computer is in play; <code>true</code>
	 * if there is a Random Computer, <code>false</code> if there isn't.
	 */
	public boolean randomComp;
	
	// Player, Human and RandomComputer are all instantiated
	Human human = new Human();
	Player predict = new Player();
	RandomComputer rando = new RandomComputer();
	
	//------------------------------------CONSTRUCTOR-------------------------------------
	/**
	 * The constructor determines whether or not the Random Computer is playing the game.
	 * 
	 * @param type is an <code>integer</code> that when it is equal to <code>1</code> the Predictable 
	 * Computer plays, when it's equal to <code>2</code> the Random Computer plays.
	 */
	public Game(int type){
		// When Predictable Computer is playing
		if (type == 1){
			randomComp = false;
		}
		// When Random Computer is playing
		if (type == 2){
			randomComp = true;
		}
	}
	
	//-------------------------------------METHODS----------------------------------------
	/**
	 * This method controls the flow of the game. This method contains methods from the rest of the class
	 * and will not end until the game has been won. It counts the cards using {@link Human#CardsInDeck()} and 
	 * {@link #CompDeck()}. It draws a card from the deck with {@link Human#DrawCard()} and {@link #CompDrawCard()}.
	 * It retrieves the attribute values with {@link Human#ChooseAtts(int)}, {@link #ForceCompChoose(int)} and 
	 * {@link #getCompAttNum()}. The Computer player also chooses the attribute with {@link #CompChoose()}.
	 * Finally, the round winner is worked out by {@link #decide()} and the winner of the game is determined by
	 * {@link #CheckWin()}. It also uses {@link #Continue()} to help keep track of game progress.
	 */
	public void GameProgress(){
		win = false;
		// Game loop
		while (win == false){
			// When Human's turn
			if (turn == 1){	
				// Show number of cards in each others deck
				human.CardsInDeck();
				CompDeck();
				// Draw card and ask for selection
				human.DrawCard();
				System.out.println("\n"+human.playerName+", select an Attribute to compare: ");
				int attChoice = 0;
				boolean choice = false;
				while (choice = false){
					try {
						attChoice = input.nextInt();
						choice = true;
					} catch (Exception e) {
						System.out.println("\nPlease select a number between 1 and 4...");
					}
				}
				// Validation check
				while ((attChoice != 1) && (attChoice != 2) && (attChoice != 3) && (attChoice != 4)){
					System.out.println("\nPlease select a number between 1 and 4...");
					attChoice = input.nextInt();
				}
				System.out.print("\n");
				// Comparing attribute values
				human.ChooseAtts(attChoice);
				compared = human.getAttribNum();
				ForceCompChoose(compared);
				CompDrawCard();
				// Decide who won
				decide();
				// Ask for input before carrying on
				Continue();
			}
			// When Computer's turn
			else if (turn == 2){
				// Show number of cards in each others deck
				human.CardsInDeck();
				CompDeck();
				// Draw card and ask for selection
				CompChoose();
				// Comparing attribute values
				getCompAttNum();
				human.DrawCard();
				// Decide who won
				decide();
				// Ask for input before carrying on
				Continue();
			}
			// Check whether game has been won
			CheckWin();
		}
	}
	
	/**
	 * This method asks for the Computer's name depending on which Computer is playing. It is done with
	 * {@link Player#AskName()} and {@link RandomComputer#AskName()}.
	 */
	public void AskCompName(){
		// When Predictable Computer is playing
		if (randomComp == false){
			predict.AskName();
		}
		// When Random Computer is playing
		if (randomComp == true){
			rando.AskName();
		}
	}
	
	/**
	 * This method counts the number of cards held by the Computer depending on which Computer is
	 * playing. This method utilises {@link Player#CardsInDeck()} and {@link RandomComputer#CardsInDeck()}.
	 */
	public void CompDeck(){
		// When Predictable Computer is playing
		if (randomComp == false){
			predict.CardsInDeck();
		}
		// When Random Computer is playing
		if (randomComp == true){
			rando.CardsInDeck();
		}
	}
	
	/**
	 * This method draws the card on the top of the Computer player's deck. This method uses {@link Player#DrawCard()}
	 * and {@link RandomComputer#DrawCard()}.
	 */
	public void CompDrawCard(){
		// When Predictable Computer is playing
		if (randomComp == false){
			predict.DrawCard();
		}
		// When Random Computer is playing
		if (randomComp == true){
			rando.DrawCard();
		}
	}
	
	/**
	 * This method decides on the attribute for the Computer player. It uses {@link Player#ChooseAtts()}
	 * and {@link RandomComputer#ChooseAtts()}.
	 */
	public void CompChoose(){
		// When Predictable Computer is playing
		if (randomComp == false){
			predict.ChooseAtts();
		}
		// When Random Computer is playing
		if (randomComp == true){
			rando.ChooseAtts();
		}
	}
	
	/**
	 * This method gets the value of the attribute chosen by the Computer. It uses {@link Player#getAttribNum()}
	 * and {@link RandomComputer#getAttribNum()}.
	 */
	public void getCompAttNum(){
		// When Predictable Computer is playing
		if (randomComp == false){
			compared = predict.getAttribNum();
		}
		// When Random Computer is playing
		if (randomComp == true){
			compared = rando.getAttribNum();
		}
	}
	
	
	/**
	 * This method finds the attribute of the Computer player's card depending on what the Human player picked.
	 * The method combines {@link Queue#peek()} and {@link Card#getAtts(int)}.
	 * 
	 * @param i is the attribute number chosen by the Human player.
	 */
	public void ForceCompChoose(int i){
		// When Predictable Computer is playing
		if (randomComp == false){
			predict.attribNum = predict.deck.peek().getAtts(i);
		}
		// When Random Computer is playing
		if (randomComp == true){
			rando.attribNum = rando.deck.peek().getAtts(i);
		}
	}
	
	/**
	 * This method decides who won the round. It uses {@link Player#addCard(Card)} and {@link Queue#poll()}.
	 */
	public void decide(){
		// When Random Computer is playing
		if (randomComp == true){
			if (human.attribNum >= rando.attribNum){
				// Prints winner
				System.out.println("\n"+human.playerName+" wins!\n");
				// Takes loser's card and puts it at the back of the deck
				human.addCard(rando.deck.poll());
				// Takes winner's card and puts it at the back of the deck
				human.addCard(human.deck.poll());
				// Winner takes a turn next
				turn = 1;
			}
			if (human.attribNum < rando.attribNum){
				// Prints winner
				System.out.println("\n"+rando.playerName+" wins!\n");
				// Takes loser's card and puts it at the back of the deck
				rando.addCard(human.deck.poll());
				// Takes winner's card and puts it at the back of the deck
				rando.addCard(rando.deck.poll());
				// Winner takes a turn next
				turn = 2;
			}
		}
		// When Predictable Computer is playing
		if (randomComp == false){
			if (human.attribNum >= predict.attribNum){
				// Prints winner
				System.out.println("\n"+human.playerName+" wins!\n");
				// Takes loser's card and puts it at the back of the deck
				human.addCard(predict.deck.poll());
				// Takes winner's card and puts it at the back of the deck
				human.addCard(human.deck.poll());
				// Winner takes a turn next
				turn = 1;
			}
			if (human.attribNum < predict.attribNum){
				// Prints winner
				System.out.println("\n"+predict.playerName+" wins!\n");
				// Takes loser's card and puts it at the back of the deck
				predict.addCard(human.deck.poll());
				// Takes winner's card and puts it at the back of the deck
				predict.addCard(predict.deck.poll());
				// Winner takes a turn next
				turn = 2;
			}
		}
	}
	
	/**
	 * This method determines whether or not the game has been won by a player. It uses {@link Queue#isEmpty()}
	 * to detect the loser, which shows us who the winner is.
	 * 
	 * @return <code>win</code> will allow us to exit the game loop if it returns <code>true</code>.
	 */
	public boolean CheckWin(){
		// When Random Computer is playing
		if (randomComp == true){
			if (rando.deck.isEmpty() == true){
				// Winner of the game is printed
				System.out.println(human.playerName+" wins the Game!!!");
				System.out.println("GAME OVER.");
				// Set flag to end the game
				win = true;
			}
			if (human.deck.isEmpty() == true){
				// Winner of the game is printed
				System.out.println(rando.playerName+" wins the Game!!!");
				System.out.println("GAME OVER.");
				// Set flag to end the game
				win = true;
			}
		}
		// When Predictable Computer is playing
		if (randomComp == false){
			if (predict.deck.isEmpty() == true){
				// Winner of the game is printed
				System.out.println(human.playerName+" wins the Game!!!");
				System.out.println("GAME OVER.");
				// Set flag to end the game
				win = true;
			}
			if (human.deck.isEmpty() == true){
				// Winner of the game is printed
				System.out.println(predict.playerName+" wins the Game!!!");
				System.out.println("GAME OVER.");
				// Set flag to end the game
				win = true;
			}
		}
		return win;
	}
	
	/**
	 * This method is used to help keep track of events in the game, especially when it is the Computer's
	 * turn.
	 */
	public void Continue(){
		System.out.println("Press ENTER to continue...");
		input.nextLine();
	}
}
