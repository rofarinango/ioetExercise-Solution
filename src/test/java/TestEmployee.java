import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test Employee class
 */
public class TestEmployee {
    private Employee employeeOne;
    private Employee employeeTwo;
    private Employee employeeThree;
    @BeforeEach
    public void init(){
        ArrayList<Shift> shiftsOne = new ArrayList<>();
        ArrayList<Shift> shiftsTwo = new ArrayList<>();
        shiftsOne.add(new Shift("MO", LocalTime.parse("10:00"), LocalTime.parse("12:00")));
        shiftsOne.add(new Shift("TU", LocalTime.parse("10:00"), LocalTime.parse("12:00")));
        shiftsOne.add(new Shift("TH", LocalTime.parse("01:00"), LocalTime.parse("03:00")));
        shiftsOne.add(new Shift("SA", LocalTime.parse("14:00"), LocalTime.parse("18:00")));
        shiftsOne.add(new Shift("SU", LocalTime.parse("20:00"), LocalTime.parse("21:00")));

        shiftsTwo.add(new Shift("MO", LocalTime.parse("10:00"), LocalTime.parse("12:00")));
        shiftsTwo.add(new Shift("TH", LocalTime.parse("12:00"), LocalTime.parse("14:00")));
        shiftsTwo.add(new Shift("SU", LocalTime.parse("20:00"), LocalTime.parse("21:00")));

        employeeOne = new Employee("RENE", shiftsOne);
        employeeTwo = new Employee("ASTRID", shiftsTwo);

    }

    @Test
    public void testConstructor(){
        ArrayList<Shift> expectedShifts = new ArrayList<>();
        expectedShifts.add(new Shift("MO", LocalTime.parse("10:00"), LocalTime.parse("12:00")));
        expectedShifts.add(new Shift("TU", LocalTime.parse("10:00"), LocalTime.parse("12:00")));
        expectedShifts.add(new Shift("TH", LocalTime.parse("01:00"), LocalTime.parse("03:00")));
        expectedShifts.add(new Shift("SA", LocalTime.parse("14:00"), LocalTime.parse("18:00")));
        expectedShifts.add(new Shift("SU", LocalTime.parse("20:00"), LocalTime.parse("21:00")));

        assertEquals("RENE", employeeOne.getName());
        for (int i = 0; i < expectedShifts.size(); i++){
            assertEquals(expectedShifts.get(i).getDay(), employeeOne.getSchedule().get(i).getDay());
            assertEquals(expectedShifts.get(i).getClock_in(), employeeOne.getSchedule().get(i).getClock_in());
            assertEquals(expectedShifts.get(i).getClock_out(), employeeOne.getSchedule().get(i).getClock_out());
        }
    }

    @Test
    public void testCompareScheduleAtSameTimeFramesMoreThanZeroPeriods(){
        assertEquals(2, employeeOne.compareScheduleAtSameTimeFrames(employeeTwo));
    }

    @Test
    public void testCompareScheduleAtSameTimeFramesNoEqualPeriods(){
        ArrayList<Shift> shiftsThree = new ArrayList<>();
        employeeThree = new Employee("ANDRES", shiftsThree);
        shiftsThree.add(new Shift("MO", LocalTime.parse("01:00"), LocalTime.parse("02:00")));
        shiftsThree.add(new Shift("TU", LocalTime.parse("07:00"), LocalTime.parse("09:00")));
        assertEquals(0, employeeOne.compareScheduleAtSameTimeFrames(employeeThree));
    }

    @Test
    public void testValidateNameGivenIsValid(){
        Employee employee = new Employee("ASTRID", new ArrayList<Shift>());
        Notification notification = employee.validate();
        assertTrue(notification.getAllErrors().isEmpty());
    }

    @Test
    public void testValidateNameGivenIsTooLong(){
        Employee employee = new Employee("RENEASTRIDANDRES", new ArrayList<>());
        Notification notification = employee.validate();
        assertEquals("The name is too long", notification.getAllErrors());
    }
}
