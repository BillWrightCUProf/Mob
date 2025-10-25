package mob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Attendance extends SimpleCSV implements Iterable<String> {
    static final String DOWNLOADS_DIRECTORY = "/Users/billwright/Downloads";
    static final String ICLICKER_FILE_NAME_PATTERN = "iClicker_AttendanceExport_.*\\.csv";
    static final int ATTENDANCE_FIELD_NUMBER = 7;
    static final String ATTENDANCE_VALUE = "PRESENT";

    List<String> presentStudents = new java.util.ArrayList<>();

    public Attendance(String filePath) throws IOException {
        super(filePath);
        identifyPresentStudents();
    }

    void identifyPresentStudents() {
        for (String[] row : data) {
            if (row.length > ATTENDANCE_FIELD_NUMBER && ATTENDANCE_VALUE.equals(row[ATTENDANCE_FIELD_NUMBER])) {
                presentStudents.add(getStudentName(data.indexOf(row)));
            }
        }
    }

    class AttendanceIterator implements Iterator<String> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < presentStudents.size();
        }

        @Override
        public String next() {
            return presentStudents.get(index++);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new AttendanceIterator();
    }

    public static Path latestRosterFinder() throws IOException {
        Path dir = Paths.get(DOWNLOADS_DIRECTORY);
        Pattern pattern = Pattern.compile(ICLICKER_FILE_NAME_PATTERN);  // your filename regex

        return Files.list(dir)
                .filter(Files::isRegularFile)
                .filter(path -> pattern.matcher(path.getFileName().toString()).matches())
                .max(Comparator.comparingLong(Attendance::getModifiedTime))
                .orElse(null);
    }

    private static long getModifiedTime(Path path) {
        try {
            return Files.getLastModifiedTime(path).toMillis();
        } catch (IOException e) {
            return 0L;
        }
    }
}

