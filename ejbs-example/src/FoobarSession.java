import javax.ejb.Remote;

/**
This is our remote business interface.
*/
@Remote
public interface FoobarSession {
    public String getMessage();
}