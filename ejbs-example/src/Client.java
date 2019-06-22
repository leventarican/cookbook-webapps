import javax.ejb.*;
import javax.naming.*;
 
public class Client {
    public static void main(String[] args) throws Exception {
        Context ic = new InitialContext();
        FoobarSession ejb = (FoobarSession) ic.lookup(FoobarSession.class.getName());
        System.out.println("ejb message: " + ejb.getMessage());
    }
}