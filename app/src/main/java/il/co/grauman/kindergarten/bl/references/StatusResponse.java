package il.co.grauman.kindergarten.bl.references;

public class StatusResponse {
    boolean response;

    public StatusResponse() {
    }

    public StatusResponse(boolean response) {
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
}
