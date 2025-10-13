package mob;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class SimpleCSVTest {

    @Test void testReadingRosterFile() throws IOException {
        SimpleCSV roster = new SimpleCSV("iClicker.csv");
//        System.out.println(roster);

        String name = roster.selectOne();
        System.out.println(name);
        name = roster.selectOne();
        System.out.println(name);
    }
}