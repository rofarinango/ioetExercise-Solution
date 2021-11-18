import java.util.ArrayList;

public class Employee {
    private String name;
    private ArrayList<Shift> schedule;

    public Employee(String name, ArrayList<Shift> schedule) {
        this.name = name;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Shift> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Shift> schedule) {
        this.schedule = schedule;
    }

    /**
     *
     * @param employee != this
     * @return int; number of periods that employees have been at the office within the same time frame.
     */

    // REQUIRES employee != this;
    // M̶O̶D̶I̶F̶I̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶;̶
    // EFFECTS search for same shifts between employees A and B ( employeeA.compareScheduleAtSameTimeFrames(employeeB) )
    //          returns int number of periods that employees have been at the office within the same time frame
    public int compareScheduleAtSameTimeFrames(Employee employee){
        int totalPeriods = 0;
        for (Shift shift: employee.getSchedule()){
            if (this.getSchedule().contains(shift)){
                totalPeriods++;
            }
        }
        return  totalPeriods;
    }

    //  ̶R̶E̶Q̶U̶I̶R̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶;
    // M̶O̶D̶I̶F̶I̶E̶S̶ ̶n̶o̶t̶h̶i̶n̶g̶;̶
    // EFFECTS return a notification object with the message of the error.
    public Notification validate(){
        final Notification notification = new Notification();
        if (this.name.length() > 10){
            notification.addError("The name is too long");
        }
        return notification;
    }
}
