import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Parse a file containing the data of the employees with their schedules and return the schedule
 * Throws a SyntaxError exception on failure.
 *
 * This will allow data like:
 *  RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
 *
 * To be parsed into an object Employee with their respective shifts
 *  Employee name = RENE
 *      ArrayList<Shift> schedule = [Shift(MO, 10:00, 12:00), Shift(TU, 10:00, 12:00), Shift(TH, 01:00, 03:00),
 *      Shift(SA, 14:00, 18:00), Shift(SU, 20:00, 21:00)]
 * **/

public class EmployeeDataTXTParser implements EmployeeDataParser{
    private static final int NAME = 0;
    private static final int SHIFTS = 1;
    private static final int CLOCK_IN = 0;
    private static final int CLOCK_OUT = 1;
    public EmployeeDataTXTParser() {
    }

    // REQUIRES line != null
    // ̶M̶O̶D̶I̶F̶I̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶
    // EFFECTS parse the data of an employee from the input line and return an employee object with that data.
    @Override
    public Employee parseFrom(final String line) {
        String[] dataArrayOfEmployee = line.split("="); // Splits line in to strings [name, shifts]
        String name = dataArrayOfEmployee[NAME]; // String that contains employee Name
        String str_schedule = dataArrayOfEmployee[SHIFTS]; // String that contains employee schedule

        String[] strArrayOfShifts = str_schedule.split(","); // Splits str_schedule into shifts e.g "MO08:00-10:00"

        ArrayList<Shift> shifts = getShifts(strArrayOfShifts);

        return new Employee(name, shifts);
    }

    // REQUIRES List<String> lines not empty
    // ̶M̶O̶D̶I̶F̶I̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶
    // EFFECTS parse a list of lines with the data of employees and returns a list of employees.
    @Override
    public ArrayList<Employee> parseLinesFrom(final List<String> lines) {
        Notification notification;
        final ArrayList<Employee> employees = new ArrayList<>();

        for (String line: lines){
            Employee employee = parseFrom(line);
            notification = employee.validate();
            if (notification.hasErrors()){
                throw new IllegalArgumentException(String.valueOf(notification.getAllErrors()));
            }
            employees.add(employee);
        }
        return employees;
    }

    // REQUIRES String[] strArrayOfShifts not empty
    // ̶M̶O̶D̶I̶F̶I̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶
    // EFFECTS returns a list with the shifts parsed from the string array that contains the data of the shifts.
    private ArrayList<Shift> getShifts(String[] strArrayOfShifts) {
        Notification notification;
        ArrayList<Shift> shifts = new ArrayList<>();

        for (String str_shift : strArrayOfShifts){
            String day = str_shift.substring(0, 2); // Get DAY from shift string
            String worked_hours = str_shift.substring(2); // Get worked hours from shift string
            String[] arrayOfHours = worked_hours.split("-"); // Splits worked_hours into strings (clock_in, clock_out)

            LocalTime clock_in = LocalTime.parse(arrayOfHours[CLOCK_IN]);
            LocalTime clock_out = LocalTime.parse(arrayOfHours[CLOCK_OUT]);
            Shift shift = new Shift(day, clock_in, clock_out);
            notification = shift.validate();
            if (notification.hasErrors()){
                throw new IllegalArgumentException(String.valueOf(notification.getAllErrors()));
            }
            shifts.add(shift);
        }
        return shifts;
    }
}
