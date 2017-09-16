import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Solution development for 4-bit/2-disclosure device.
 *
 * @version 9/16/17:50
 * @author Dr. Jody Paul, Stephen Bapple, Taylor Woehrle
 */
public class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker {

    /** Suppresses default constructor, ensuring non-instantiability. */
    private FourBitTwoDisclosureDeviceUnlocker() {}

    /** 
     * Unlocks a resource controlled by a 4-bit/2-disclosure device.
     * Behavior is unspecified if parameter is not a reference to a
     * valid 4-bit/2-disclosure device.
     * 
     * @param Key the device controlling the resource to unlock;
     * must be a 4-bit device with 2 peek/poke bits.
     * 
     * @return True if the resource is successfully unlocked
     * (all bits are now identical); false otherwise.
     */
    public static boolean unlock(Device key) {
    	Random rand = new Random();
        long endTime = getMaxRunTime() * 1000 + System.currentTimeMillis();
		while (System.currentTimeMillis() <= endTime) {
        	int randomCase = rand.nextInt(6);
        	switch (randomCase) {
	        	case 0:
	        		key.peek("??--");
	                key.poke("TT--");
	        	case 1:
	        		key.peek("?-?-");
	                key.poke("T-T-");
	        	case 2:
	        		key.peek("?--?");
	                key.poke("T--T");
	        	case 3:
	        		key.peek("-??-");
	                key.poke("-TT-");
	        	case 4:
	        		key.peek("-?-?");
	                key.poke("-T-T");
	        	case 5:
	        		key.peek("--??");
	                key.poke("--TT");
        	}
            key.peek("??--");
            key.poke("TT--");

            if (key.spin() == true) {
                return true;
            }
        }
        System.out.println("The device was not unlocked in the given amount of time.");
        return false;
    }

    /** Gets the time in seconds from user for the unlock method. */
    private static int getMaxRunTime() {
		Scanner input = new Scanner (System.in);
    	int secondsToRun = 0;
    	while (true) {
	    	System.out.println("Enter a number in seconds of the max time to try and " +
	    						" unlock the device:");
	    	try {
	    		secondsToRun = input.nextInt();
	    	} catch (InputMismatchException e) {
	    		System.out.println("You must enter a positive non-zero integer!");
	    		return getMaxRunTime();
	    	}
	    	if (secondsToRun > 0) {
	    		break;
	    	} else {
	    		System.out.println("You must enter a positive non-zero integer!");
	    	}
    	}
    	input.close();
    	return secondsToRun;
	}
}