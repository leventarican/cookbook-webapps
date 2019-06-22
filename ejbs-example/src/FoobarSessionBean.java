import javax.ejb.Stateless;

@Stateless
public class FoobarSessionBean implements FoobarSession {
    public String getMessage() {
        return "foobar";
    }
}