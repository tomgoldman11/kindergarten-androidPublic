package il.co.grauman.kindergarten.models.exceptions;

public class LoginFailedException extends Exception {
    public LoginFailedException(String msg){
        super(msg);
    }
}
