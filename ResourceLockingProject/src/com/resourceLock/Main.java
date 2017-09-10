package com.resourceLock;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		boolean[] p = {false, true, true, true};
		Device dev = new Device(p, 2);
		if(dev.spin() == false){
			System.out.println("Not equal");
		}
		else{
			System.out.println("Equal!");
		}
		System.out.println(dev.peek("?--?"));
	}
	
}
