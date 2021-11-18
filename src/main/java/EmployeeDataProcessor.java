import java.util.ArrayList;
import java.util.Collections;

public class EmployeeDataProcessor {
    private final ArrayList<Employee> employees;

    public EmployeeDataProcessor(final ArrayList<Employee> employees){
        this.employees = employees;
    }

    //  R̶E̶Q̶U̶I̶R̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶
    // MODIFIES: this
    // EFFECTS return EmployeesSummary object that resolves employees that where at the same time frame.
    public EmployeesSummary summarizeEmployeesAtSameTimeFrame(){
        EmployeesSummary employeesSummary = new EmployeesSummary(new ArrayList<>());

        ArrayList<Employee> employeesReversed = new ArrayList<Employee>();
        employeesReversed.addAll(this.employees);
        Collections.reverse(employeesReversed);

        for(Employee employeeA : this.employees){
            employeesReversed.remove(employeesReversed.size()-1);
            for (Employee employeeZ : employeesReversed){
                System.out.println(employeeA.getName() + "-" + employeeZ.getName() + ": "
                        + employeeA.compareScheduleAtSameTimeFrames(employeeZ));
                employeesSummary.getEmployeesAtSameTimePeriod().add(employeeA.getName() + "-" + employeeZ.getName() + ": "
                        + employeeA.compareScheduleAtSameTimeFrames(employeeZ));
            }
        }
        return employeesSummary;
    }

}
