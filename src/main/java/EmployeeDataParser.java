import java.util.ArrayList;
import java.util.List;

public interface EmployeeDataParser {
    Employee parseFrom(String line);
    ArrayList<Employee> parseLinesFrom(List<String> lines);
}
