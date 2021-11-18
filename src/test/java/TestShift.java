import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Test Shift class
 */
public class TestShift {

    @Test
    public void testConstructor(){
        Shift shift = new Shift("MO", LocalTime.parse("10:00"), LocalTime.parse("12:00"));

        assertEquals("MO", shift.getDay());
        assertEquals(LocalTime.parse("10:00"), shift.getClock_in());
        assertEquals(LocalTime.parse("12:00"), shift.getClock_out());

    }

    @Test
    public void testValidateDayGivenIsValid(){
        Shift shift = new Shift("MO", LocalTime.parse("10:00"), LocalTime.parse("12:00"));
        Notification notification = shift.validate();

        assertTrue(notification.getAllErrors().isEmpty());
    }

    @Test
    public void testValidateDayGivenIsInvalid(){
        Shift shift = new Shift("MS", LocalTime.parse("10:00"), LocalTime.parse("12:00"));
        Notification notification = shift.validate();

        assertEquals("Invalid day of the week", notification.getAllErrors());
    }

    @Test
    public void testValidateClockInIsAfterClockOut(){
        Shift shift = new Shift("MO", LocalTime.parse("15:00"), LocalTime.parse("12:00"));
        Notification notification = shift.validate();

        assertEquals("ClockIn cannot be after clockOut", notification.getAllErrors());
    }
}
