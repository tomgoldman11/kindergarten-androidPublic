package il.co.grauman.kindergarten.bl.shifts.shiftModels;

public class UpdateShiftResponse {
    boolean response;

    public UpdateShiftResponse() {
    }

    public UpdateShiftResponse(boolean response) {
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
