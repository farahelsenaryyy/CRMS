package CRMS;

public class Schedule {
    private String workingHours;
    private boolean available;

    public Schedule(String workingHours, boolean available) {
        this.workingHours = workingHours;
        this.available = available;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "workingHours='" + workingHours + '\'' +
                ", available=" + available +
                '}';
    }
}
