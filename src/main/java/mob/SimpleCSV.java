package mob;

import java.io.BufferedReader;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class SimpleCSV {
    List<String[]> data = new ArrayList<>();

    SimpleCSV(String filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String strippedLine = line.strip().replaceAll("\"", "");
                String[] values = strippedLine.split(",");
                data.add(values);
            }
        }
        assert !data.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String[] row : data) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }

    public String selectOne() {
        Random random = new Random();
        int index = random.nextInt(data.size());
        return getStudentName(index);
    }

    String getStudentName(int index) {
        String[] student = data.get(index);
        return student[1] + " " + student[0];
    }
}
