import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class FailTest {
    @Test
    public void testFailure() {
        try {
            Device dev = new Device();
            assertNotNull(dev);
        } catch (Exception e) {
            fail();
        }
    }
    @Test
    public void testClassAreAvailable() {
        // Note: this test tests if the device unlocks successfully.
        // However, it might not and that's actually fine.
        assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(new Device()));
    }
}