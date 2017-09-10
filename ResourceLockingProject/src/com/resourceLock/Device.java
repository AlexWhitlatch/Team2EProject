package com.resourceLock;

import java.util.ArrayList;

public class Device {
	public static final int DEFAULT_PEEKS = 2;
	public static final int DEFAULT_SIZE = 4;
	public static final char VALUE_FALSE = 70;
	public static final char VALUE_TRUE = 84;
	private int size;
	private int bitsPerPeek;
	private boolean[] initialBits;
	
	public Device(){
		
	}
	
	public Device(boolean[] initialBits, int bitsPerPeek){
		this.initialBits = initialBits;
		this.bitsPerPeek = bitsPerPeek;
		
	}
	
	public Device(int size, int bitsPerPeek){
		this.size = size;
		this.bitsPerPeek = bitsPerPeek;
	}
	
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
	
	public void poke(CharSequence pattern){
		
	}
	
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
