import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class Shift {
    private String day;
    private LocalTime clock_in;
    private LocalTime clock_out;
    private static final String[] WEEKDAYS = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};


    public Shift(String day, LocalTime clock_in, LocalTime clock_out) {
        this.day = day;
        this.clock_in = clock_in;
        this.clock_out = clock_out;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalTime getClock_in() {
        return clock_in;
    }

    public void setClock_in(LocalTime clock_in) {
        this.clock_in = clock_in;
    }

    public LocalTime getClock_out() {
        return clock_out;
    }

    public void setClock_out(LocalTime clock_out) {
        this.clock_out = clock_out;
    }

    // REQUIRES Obj != null
    // ̶M̶O̶D̶I̶F̶I̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶
    // EFFECTS returns true if the shift is equal or if the shift overlap at least at a certain time, else return false.
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Shift){
            Shift shift = (Shift) obj;
            if(shift!=null
                    && this.day.equals(shift.day)
                    && this.clock_in.equals(shift.clock_in)
                    && this.clock_out.equals(shift.clock_out)){
                return true;
            }
            else if(this.day.equals(shift.day) &&
                    (targetIsBetweenClockInAndClockOut(shift.clock_in, this.clock_in, this.clock_out) ||
                            targetIsBetweenClockInAndClockOut(shift.clock_out,this.clock_in, this.clock_out) ||
                            targetIsBetweenClockInAndClockOut(this.clock_in, shift.clock_in, shift.clock_out) ||
                            targetIsBetweenClockInAndClockOut(this.clock_out, shift.clock_in, shift.clock_out))){
                return true;
            }
        }
        return false;
    }

    // REQUIRES target !=null
    // ̶M̶O̶D̶I̶F̶I̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶
    // EFFECTS returns true if target is between given clock in time and clock out time, else returns false.
    private boolean targetIsBetweenClockInAndClockOut(LocalTime target, LocalTime clock_in, LocalTime clock_out){
        return target.isAfter(clock_in) && target.isBefore(clock_out);
    }

    // ̶R̶E̶Q̶U̶I̶R̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶
    // ̶M̶O̶D̶I̶F̶I̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶
    // EFFECTS return a notification obj with all the errors that occurs.
    public Notification validate(){
        final Notification notification = new Notification();
        if(!Arrays.asList(WEEKDAYS).contains(this.day)){
            notification.addError("Invalid day of the week");
        }
        final LocalTime parsedTimeClockIn;
        try{
            parsedTimeClockIn = LocalTime.parse(this.clock_in.toString());
            if (parsedTimeClockIn.isAfter(this.clock_out)){
                notification.addError("ClockIn cannot be after clockOut");
            }
        }catch (DateTimeParseException e){
            notification.addError("Invalid format for time");
        }
        return notification;
    }
}
