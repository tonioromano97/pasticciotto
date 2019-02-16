package test.model;



import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

import bean.Entrata;
import bean.Pasticceria;
import bean.Uscita;
import bean.Utente;
import junit.framework.*;
import model.FinanceManager;
import model.UserManager;


public class TestFinanceManager extends TestCase{

	private Pasticceria bakery;
	private Entrata e;
	private Uscita u;
	private Collection finances;
	private boolean done;
	
	public TestFinanceManager(String name)
	{
		super(name);
		
	}
	
	public void setUp() throws Exception {
		bakery = null;	
	}


	public void tearDown() throws Exception {
		done = false;
	}

	public void testGetFinances() throws SQLException{
		
		finances = FinanceManager.getFinances(null);
		assertNull(finances);
		
		
		bakery = new Pasticceria(2,"pasticceria","Via roma 306","pasticceria@mail.it","783273891", "Pasticceria dal 1983", "http://www.pasticceria.it", "/pasticcerie/pasticceria.png");
		finances = null;
		finances = FinanceManager.getFinances(bakery);
		assertEquals(0, finances.size());
		
		
		bakery = new Pasticceria(1,"pasticceria","Via roma 306","pasticceria@mail.it","783273891", "Pasticceria dal 1983", "http://www.pasticceria.it", "/pasticcerie/pasticceria.png");
		finances = null;
		finances = FinanceManager.getFinances(bakery);
		assertNotNull(finances);
	}
	
	public void testAddEntrata() throws SQLException{
		
		done = FinanceManager.addEntrata(null);
		assertFalse(done);
		
		e = new Entrata(-1,null,"Ordine #1090",Date.valueOf("2018-10-23"),10.40);
		done = FinanceManager.addEntrata(e);
		assertFalse(done);
		
		e.setPasticceria(new Pasticceria(1));
		done = FinanceManager.addEntrata(e);
		assertTrue(done);
		
	}
	
	public void testAddUscita() throws SQLException{
		done = FinanceManager.addUscita(null);
		assertFalse(done);
		
		u = new Uscita(-1,null,"Rifornimento #1",Date.valueOf("2018-10-23"),10.40,"Fattura");
		done = FinanceManager.addUscita(u);
		assertFalse(done);
		
		u.setPasticceria(new Pasticceria(1));
		done = FinanceManager.addUscita(u);
		assertTrue(done);
	}
	
	public void testDeleteFinance() throws SQLException{
		done = FinanceManager.deleteFinance(null);
		assertFalse(done);
		
		done = FinanceManager.deleteFinance(u);
		assertFalse(done);
		
		u = new Uscita(-1,null,"Rifornimento #1",Date.valueOf("2018-10-23"),10.40,"Fattura");
		u.setCodice(5);
		done = FinanceManager.deleteFinance(u);
		assertTrue(done);
	}
	
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new TestFinanceManager("testDeleteFinance"));
		return suite;
		
	}
}
