package il.co.grauman.kindergarten.bl.references;

public class StatusResponse<T> {
    T response;

    public StatusResponse() {
    }

    public StatusResponse(T response) {
        this.response = response;
    }

    public T isResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
