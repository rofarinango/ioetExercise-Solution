import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyzeTXT(final String filename, final EmployeeDataParser employeeDataParser, final Exporter exporter) throws IOException {
        final Path path = Paths.get(RESOURCES + filename);
        final List<String> lines = Files.readAllLines(path);
        final ArrayList<Employee> employees = employeeDataParser.parseLinesFrom(lines);
        final EmployeeDataProcessor employeeDataProcessor = new EmployeeDataProcessor(employees);

        final EmployeesSummary employeesSummary = employeeDataProcessor.summarizeEmployeesAtSameTimeFrame();

        System.out.println(exporter.export(employeesSummary));
    }
}
