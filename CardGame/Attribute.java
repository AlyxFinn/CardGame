/**
 * This class handles individual attributes by storing their name and value.
 * 
 * @author Alexander Finnigan (ID: 201084157)
 *
 */
public class Attribute {
	
	//---------------------ATTRIBUTES------------------------------
	/**
	 * This <code>String</code> variable stores the name of the attribute.
	 */
	private String attName;
	/**
	 * This <code>integer</code> variable stores the value of the attribute.
	 */
	private int val;
	
	/**
	 * The constructor for this class sets the name of the attribute and sets the attribute value 
	 * to a random number between 0 and 9.
	 * 
	 * @param name is the given name for the attribute, e.g. "Speed", "Acceleration", etc...
	 */
	//--------------------CONSTRUCTOR-------------------------------
	public Attribute (String name){
		attName = name;
		val = (int) ((Math.random()) * 10);
	}
	
	/**
	 * This method returns the value of the attribute as an <code>integer</code>.
	 * 
	 * @return <code>val</code> is being returned as an <code>integer</code>, this is so the value of the attribute can be given 
	 * in other classes.
	 */
	//-----------------------METHODS--------------------------------
	public int AttVal(){
		return val;
	}
	
	/**
	 * This method prints the attribute along with the random value assigned to it.
	 */
	public void printAtts(){
		System.out.println(attName+" = "+val);
	}
}
