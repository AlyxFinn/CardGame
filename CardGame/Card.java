/**
 * This class makes up a single card by creating the attributes from {@link Attribute Attribute} then storing them in 
 * an <code>array</code>. Each <code>Attribute</code> <code>object</code> should contain the name of the attribute 
 * and its corresponding values. This class also stores the name of the card.
 * 
 * @author Alexander Finnigan (ID: 201084157)
 *
 */
public class Card {
	
	//--------------------------ATTRIBUTES----------------------------
	/**
	 * The <code>array</code> called <code>attributes</code> of type <code>Attribute</code> will store the name of 
	 * the attributes and their values.
	 */
	public Attribute[] attributes;
	/**
	 * The <code>String</code> variable <code>cardName</code> will store the name of the card given from the constructor.
	 */
	private String cardName;
	
	/**
	 * This constructor will populate the <code>array</code> <code>attributes[]</code> by creating objects of the 
	 * <code>Attribute</code> class. Each time an <code>object</code> is created, a name for the attribute is given and 
	 * the <code>object</code> is stores into the <code>array</code>.
	 * 
	 * @param name is the name given to the card. This name will be decided when the constructor is called
	 * in another class.
	 */
	//-------------------------CONSTRUCTOR----------------------------
	public Card(String name){
		cardName = name;
		attributes = new Attribute[5];
		attributes[1] = new Attribute("(1) Speed");
		attributes[2] = new Attribute("(2) Acceleration");
		attributes[3] = new Attribute("(3) Length");
		attributes[4] = new Attribute("(4) Value");
	}
	//--------------------------METHODS-------------------------------
	/**
	 * This method will print the entire card. It will print the name stored in this class then use a <code>for-loop</code>
	 * to print each attribute from the <code>array</code>.
	 */
	public void printCard(){
		// Prints Card name
		System.out.println(cardName);
		// Prints all the attributes 
		for (int i = 1; i < 5; i++){
			attributes[i].printAtts();
		}
	}
	
	/**
	 * This method will return the value of a given attribute in the form of an <code>integer</code>. It invokes the 
	 * method {@link Attribute#AttVal()} to find the value.
	 * 
	 * @param <code>i</code> indicates which attribute on the card is going to be read.
	 * @return The value of the attribute.
	 */
	public int getAtts(int i){
		return attributes[i].AttVal();
	}
}
