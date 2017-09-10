import java.util.ArrayList;

/**
 * 
 * @author Team 2E, design and API by Jody Paul
 * @version 0.1.2T
 * Resource-locking device with circular bit storage.
 */
public class Device {
	/** Default number of bits to reveal per peek.*/
	public static final int DEFAULT_PEEKS = 2;
	/** Default number of bits stored. */
	public static final int DEFAULT_SIZE = 4;
	/** Character indicator of false. */
	public static final char VALUE_FALSE = 70;
	/** Character indicator of true. */
	public static final char VALUE_TRUE = 84;
	
	private int size;

	private int bitsPerPeek;

	private boolean[] initialBits;
	
	/** Construct device using defaults.*/
	public Device(){
		
	}
	
	/**
	 * Construct device with specified bits for testing. Initial bit values are
	 * represented by an array of boolean primitives.
	 * @param initialBits  The bit values for this test device.
	 * @param bitsPerPeek The number of bits to disclose via peek or set via poke.
	 */
	public Device(boolean[] initialBits, int bitsPerPeek){
		this.initialBits = initialBits;
		this.bitsPerPeek = bitsPerPeek;
		
	}
	
	/**
	 * Construct device with specified size and number
	 * of peek/poke bits.
	 * @param size The number of bits stored in this device.
	 * @param bitsPerPeek the number of bits to disclose via peek or set via poke.
	 */
	public Device(int size, int bitsPerPeek){
		this.size = size;
		this.bitsPerPeek = bitsPerPeek;
	}

	/**
	 * Initiate device rotation.
	 * @return True if all bits have identical value; false otherwise.
	 */
	public boolean spin(){
		boolean retVal = false;
		boolean temp;
		int numOfSpins = 3;
		System.out.println("Current Values are: \r\n");
		outputBool(initialBits);
		System.out.println("Spinning...");
		for(int i = 0; i < numOfSpins; i++){//handles number of rotations
			temp = initialBits[initialBits.length-1];//saving last parameter
			for(int j = initialBits.length-1; j > 0; j--){//rotates bits
				initialBits[j] = initialBits[j-1];
			}
			initialBits[0] = temp;
			outputBool(initialBits);
		}
		temp = initialBits[initialBits.length-1];//used as a reference bit
		for(int i = 0; i < initialBits.length; i++){//checks to see if all bits are the same
			if(initialBits[i] == temp){
				retVal = true;
			}
			else{
				return false;
			}
		}
		
		return retVal;
	}

	/**
	 * Peek at bits of device.
	 * @param pattern Indicates which bits to reveal as '?'. pattern.length() must be exactly
	 * equal to the number of bits stored in the device.
	 * @return A pattern that discloses the values of the indicated bits as 'T' or 'F'.
	 */
	public CharSequence peek(CharSequence pattern){
		StringBuilder str = new StringBuilder().append("[");
		String retVal = null;
		if(pattern.length() == initialBits.length){
			for(int i = 0; i < initialBits.length; i ++){
				if(pattern.charAt(i) == '?'){
					if(initialBits[i] == true){
						str.append("T");
					}
					else{
						str.append("F");
					}
				}
				else if(pattern.charAt(i) == '-'){
					str.append("-");
				}
			}
			str.append("]");
			retVal = str.toString();
		}
		else{
			System.out.println("Invalid pattern length");
		}
		return retVal;
	}
	
	/**
	 * Poke bits into device.
	 * @param pattern Indicator of values of bits to poke. pattern.length() must be
	 * exactly equal to the number of bits stored in the device. Values of 'T' or 'F'
	 * that correspond to '?' in the preceding peek request pattern replace the values
	 * in the device.
	 */
	public void poke(CharSequence pattern){
		
	}
	
	/**
	 * Render device information as a string.
	 * @return Rendering that reveals partial state.
	 */
	public String toString(){
		return null;
	}
	
	public static void outputBool(boolean[] b){
		System.out.println("Inside outputBool method");
		ArrayList<String> s = new ArrayList<String>();
		for(int i = 0; i < b.length; i ++){
			if(b[i] == true){
				s.add("True");
			}
			else{
				s.add("false");
			}
		}
		System.out.println(s.toString());
		
	}
	

}
