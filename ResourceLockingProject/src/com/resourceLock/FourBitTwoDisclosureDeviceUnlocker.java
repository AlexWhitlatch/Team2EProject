/**
 * Solution development for 4-bit/2-disclosure device.
 *
 * @version 4.1.5
 * @author Dr. Jody Paul
 * @author Stephen Bapple
 * @author Christopher Davis
 * @author Alex Whitlatch
 * @author Taylor Woehrle
 *
 *
 * @see <a href="http://jodypaul.com/cs/sweprin/deviceProj/projectDescription.html">Project Description</a>
 *
 */
public class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker {
    /* Unlock attempt limit to prevent small chance where device will not unlock. */
    private static final int LIMIT = 10;

    /* Suppresses default constructor, ensuring non-instantiability. */
    private FourBitTwoDisclosureDeviceUnlocker() {}

    /**
     * Unlocks a resource controlled by a 4-bit/2-disclosure device.
     * Behavior is unspecified if parameter is not a reference to a valid 4-bit/2-disclosure device.
     * @param dev the device controlling the resource to unlock; must be a 4-bit device with 2 peek/poke bits.
     * @return true if the resource is successfully unlocked (all bits are now identical); false otherwise
     */
    public static boolean unlock(Device dev) {
        /* Check if device is already unlocked. */
        if (dev.spin() == true) {
            return true;
        }

        /* move loop invariant outside of the loop in order validate device state */
        int i = 0;

        /* at this point the loop invariant should be 0 still and the device should be locked */
        assert(i == 0 && !dev.spin());

        /* Solution:
        Peek/poke the leftmost two bits to True every time. */
        while(i++ < LIMIT) {
            dev.peek("??--");
            dev.poke("TT--");
            if (dev.spin() == true) {
                /* the loop invariant should be less than the limit if you're in the loop still and here the device
                should be unlocked */
                assert(i<LIMIT && dev.spin());
                return true;
            }
            /* the loop invariant should be less than the limit if you're in the loop still and here the device
                should be locked */
            assert(i<LIMIT && !dev.spin());
        }
        /* the loop invariant should be equal to the limit if we are returning false for unlock */
        assert(i==LIMIT && !dev.spin());
        return false;
    }
}


