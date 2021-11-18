import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test the parser
 */
public class TestEmployeeDataTXTParser {
    @Test
    public void testParserValidFormat(){
        List<String> input = new ArrayList<>();
        input.add("RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00");

        EmployeeDataTXTParser p = new EmployeeDataTXTParser();

        ArrayList<Employee> employees = p.parseLinesFrom(input);

        assertEquals("RENE", employees.get(0).getName());

        // Day: MO
        assertEquals("MO", employees.get(0).getSchedule().get(0).getDay());
        assertEquals(LocalTime.parse("10:00"), employees.get(0).getSchedule().get(0).getClock_in());
        assertEquals(LocalTime.parse("12:00"), employees.get(0).getSchedule().get(0).getClock_out());
        // Day: TU
        assertEquals("TU", employees.get(0).getSchedule().get(1).getDay());
        assertEquals(LocalTime.parse("10:00"), employees.get(0).getSchedule().get(1).getClock_in());
        assertEquals(LocalTime.parse("12:00"), employees.get(0).getSchedule().get(1).getClock_out());
        // Day: TH
        assertEquals("TH", employees.get(0).getSchedule().get(2).getDay());
        assertEquals(LocalTime.parse("01:00"), employees.get(0).getSchedule().get(2).getClock_in());
        assertEquals(LocalTime.parse("03:00"), employees.get(0).getSchedule().get(2).getClock_out());
        // Day: SA
        assertEquals("SA", employees.get(0).getSchedule().get(3).getDay());
        assertEquals(LocalTime.parse("14:00"), employees.get(0).getSchedule().get(3).getClock_in());
        assertEquals(LocalTime.parse("18:00"), employees.get(0).getSchedule().get(3).getClock_out());
        // Day: SU
        assertEquals("SU", employees.get(0).getSchedule().get(4).getDay());
        assertEquals(LocalTime.parse("20:00"), employees.get(0).getSchedule().get(4).getClock_in());
        assertEquals(LocalTime.parse("21:00"), employees.get(0).getSchedule().get(4).getClock_out());

    }

}
