package mob;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SimpleCSVTest {

    @Test
    void testReadingRosterFile() throws IOException {
        SimpleCSV roster = new SimpleCSV("iClicker.csv");
//        System.out.println(roster);

        String name = roster.selectOne();
        System.out.println(name);
        name = roster.selectOne();
        System.out.println(name);
    }

    @Test
    void testReadingLastestRosterFile() throws IOException {
        Path latestRoster = Attendance.latestRosterFinder();
        SimpleCSV roster = new SimpleCSV(latestRoster.toString());
        System.out.println(latestRoster);
    }

    @Test
    void testCreateTeamsFromAttendance() throws IOException {
        Path latestRoster = Attendance.latestRosterFinder();
        Attendance attendance = new Attendance(latestRoster.toString());
        int numberOfTeams = 7;
        HashMap<String, List<String>> teams = new HashMap<>();
        for (int i = 1; i <= numberOfTeams; i++) {
            teams.put("Team " + i, new ArrayList<>());
        }
        int currentTeam = 0;
        for (String student : attendance) {
            teams.get("Team " + (currentTeam + 1)).add(student);
            currentTeam = (currentTeam + 1) % numberOfTeams;
        }

        // Print out the teams and the students in each team
        for (int i = 1; i <= numberOfTeams; i++) {
            String teamName = "Team " + i;
            System.out.println(teamName + ":");
            System.out.print("\t");
            int studentsPerRow = 3;
            int currentStudentCount = 1;
            for (String student : teams.get(teamName)) {
                System.out.print(student + ", ");
                if (currentStudentCount % studentsPerRow == 0) {
                    System.out.println();
                    System.out.print("\t");
                }
                currentStudentCount++;
            }
            System.out.println();
        }
    }
}
