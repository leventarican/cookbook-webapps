import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

public class DeveloperTest {

    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void init() {
        this.em = Persistence.createEntityManagerFactory("integration-test").createEntityManager();
        this.tx = this.em.getTransaction();
    }
	
	@Test
	public void test0() {
		System.out.println("\n");
		System.out.println("test0:");
		String expected = "cpp";
        Developer dev = new Developer("cpp");
        this.tx.begin();
        Developer created = this.em.merge(dev);
        this.tx.commit();
        this.em.clear();

        long id = created.getId();
        System.out.println("created: " + id);
        
        Developer found = this.em.find(Developer.class, id);
        System.out.println("found: " + found);
	}

	@Test
	public void test1() {
		System.out.println("\n");
		System.out.println("test1:");
        List<Developer> all = this.em.createNamedQuery("all", Developer.class).getResultList();
        for (Developer developer : all) {
			System.out.println(developer);
		}
        System.out.println("\n");
	}
	
	@Test
	public void test2() {
		System.out.println("\n");
		System.out.println("test2:");
        String sql = "SELECT d FROM Developer d";
        Query query = this.em.createQuery(sql);
        List<Developer> devs = query.getResultList();
        for (Developer dev : devs) {
        	System.out.println(dev);
        }
        System.out.println("\n");
	}

}
