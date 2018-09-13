package il.co.grauman.kindergarten.models;

import java.util.List;

public class WorkerShiftsDTO {

    User worker;
    List<Shift> shifts;

    public WorkerShiftsDTO(User worker, List<Shift> shifts) {
        this.worker = worker;
        this.shifts = shifts;
    }

    public User getWorker() {
        return worker;
    }

    public void setWorker(User worker) {
        this.worker = worker;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }
}
