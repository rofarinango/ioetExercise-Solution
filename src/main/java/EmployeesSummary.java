import java.util.ArrayList;

public class EmployeesSummary {
    private final ArrayList<String> employeesAtSameTimePeriod;

    public EmployeesSummary(ArrayList<String> employeesAtSameTimePeriod) {
        this.employeesAtSameTimePeriod = employeesAtSameTimePeriod;
    }

    public ArrayList<String> getEmployeesAtSameTimePeriod() {
        return employeesAtSameTimePeriod;
    }
}
