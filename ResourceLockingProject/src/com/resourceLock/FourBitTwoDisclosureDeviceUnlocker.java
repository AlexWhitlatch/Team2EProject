/**
 * Solution development for 4-bit/2-disclosure device.
 *
 * @version 4.1.4
 * @author Dr. Jody Paul
 * @author Stephen Bapple
 */
public class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker {
    public static final int LIMIT = 4; // TODO: Change to time.

    /** Suppresses default constructor, ensuring non-instantiability. */
    private FourBitTwoDisclosureDeviceUnlocker() {}

    public static boolean unlock(Device key) {
        // Check if device is already unlocked.
        if (key.spin() == true) {
            return true;
        }

        // Very naive solution:
        // Peek/poke the leftmost two bits to True every time.
        for (int i = 0; i < LIMIT; i++) {
            key.peek("??--");
            key.poke("TT--");

            if (key.spin() == true) {
                return true;
            }
        }
        return false;
    }
}


