import mob.Participant;
import mob.Mob;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class MobTest {

    @Test
    void testSelectingParticipant() {
        Mob mob = new Mob();
        Participant driver = mob.selectParticipant();
        Participant navigator = mob.selectParticipant();
        assertTrue(driver.getSection() == "Right" || driver.getSection() == "Left");
        assertTrue(driver.getRow() > 0 && driver.getRow() < 9);
        assertTrue(driver.getSeat() > 0 && driver.getSeat() < 9);
        System.out.println("\nDriver: " + driver);
        System.out.println("\nNavigator: " + navigator);
    }


}
