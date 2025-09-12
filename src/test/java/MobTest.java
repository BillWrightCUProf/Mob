public class MobTest {

    @Test
    void testSelectingParticipant() {
        Mob mob = new Mob();
        Driver driver = mob.selectDriver();
        assertTrue("ABCDEFGHIJ".contains(driver.getRow()));
        assertTrue(driver.getSeat() > 0 && driver.getSeat() < 20);
        System.out.println("\nDriver: " + driver);
    }
}
