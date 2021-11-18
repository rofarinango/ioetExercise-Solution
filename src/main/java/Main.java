import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final String filename = "input.txt";
        final EmployeeDataAnalyzer employeeDataAnalyzer = new EmployeeDataAnalyzer();
        final EmployeeDataParser employeeDataTXTParser = new EmployeeDataTXTParser();

        final Exporter exporter = new HtmlExporter();

        employeeDataAnalyzer.analyzeTXT(filename, employeeDataTXTParser, exporter);
    }
}
