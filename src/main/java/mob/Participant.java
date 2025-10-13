package mob;

import java.util.Random;

public class Participant {
    static final String[] sections = {"Left", "Right"};
    static final int TOTAL_ROWS = 8;
    static final int TOTAL_SEATS = 8;
    Random random = new Random();
    private String section;
    private int row;
    private int seat;

    public Participant() {
        section = sections[random.nextInt(sections.length)];
        row = random.nextInt(TOTAL_ROWS) + 1; // Rows 1-30
        seat = random.nextInt(TOTAL_SEATS) + 1; // Seats 1-6
    }

    public String getSection() {
        return section;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public String toString() {
        return "Section: " + section + ", Row: " + row + ", Seat: " + seat;
    }
}

