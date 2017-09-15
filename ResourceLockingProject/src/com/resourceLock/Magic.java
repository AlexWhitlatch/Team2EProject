public class Magic {
    public static void main(String [] args) {
        Device key = new Device(4,2);
        boolean isUnlocked = FourBitTwoDisclosureDeviceUnlocker.unlock(key);
        if (isUnlocked) {
            System.out.println("Device unlocked.");
        } else {
            System.out.println("Failed to unlock device.");
        }
    }
}