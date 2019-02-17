package test.model;



import java.sql.Date;
import java.sql.SQLException;

import bean.Entrata;
import bean.Pasticceria;
import bean.Uscita;
import junit.framework.*;
import model.FinanceManager;

public class TestFinanceManager extends TestCase{

	private Entrata entry;
	private Uscita exit;
	private boolean done;
	private Pasticceria bakery;
	
	public TestFinanceManager(String name)
	{
		super(name);
		
	}
	
	public void setUp() throws Exception {
		entry = null;
		exit = null;
		bakery = null;
		done = false;
	}


	public void tearDown() throws Exception {
		entry = null;
		exit = null;
		bakery = null;
		done = false;
	}
	
	
	public void testAddEntrata() throws SQLException {
		
		entry = new Entrata(-1, null, "", null, -1);
		done = FinanceManager.addEntrata(entry);
		assertFalse(done);
		
		entry = new Entrata(-1, null, "Prenotazione.1", null, -1);
		done = FinanceManager.addEntrata(entry);
		assertFalse(done);

		entry = new Entrata(-1, null, "Prenotazione.1", Date.valueOf("2017-12-11"), -1);
		done = FinanceManager.addEntrata(entry);
		assertFalse(done);
		
		entry = new Entrata(-1, null, "Prenotazione.1", Date.valueOf("2017-12-11"), 234.70);
		done = FinanceManager.addEntrata(entry);
		assertFalse(done);
		
		bakery = new Pasticceria(-1);
		entry = new Entrata(-1, bakery, "Prenotazione.1", Date.valueOf("2017-12-11"), 234.70);
		done = FinanceManager.addEntrata(entry);
		assertFalse(done);
		
		bakery = new Pasticceria(1);
		entry = new Entrata(-1, bakery, "Prenotazione.1", Date.valueOf("2017-12-11"), 234.70);
		done = FinanceManager.addEntrata(entry);
		assertTrue(done);
		
	}
	
	public void testAddUscita() throws SQLException {
		
		exit = new Uscita(-1, null, "", null, -1, null);
		done = FinanceManager.addUscita(exit);
		assertFalse(done);
		
		exit = new Uscita(-1, null, "Enel", null, -1, null);
		done = FinanceManager.addUscita(exit);
		assertFalse(done);

		exit = new Uscita(-1, null, "Enel", Date.valueOf("2017-12-11"), -1, null);
		done = FinanceManager.addUscita(exit);
		assertFalse(done);
		
		exit = new Uscita(-1, null, "Enel", Date.valueOf("2017-12-11"), 143.90, null);
		done = FinanceManager.addUscita(exit);
		assertFalse(done);
		
		exit = new Uscita(-1, null, "Enel", Date.valueOf("2017-12-11"), 143.90, "Bolletta");
		done = FinanceManager.addUscita(exit);
		assertFalse(done);
		
		bakery = new Pasticceria(-1);
		exit = new Uscita(-1, bakery, "Enel", Date.valueOf("2017-12-11"), 143.90, "Bolletta");
		done = FinanceManager.addUscita(exit);
		assertFalse(done);
		
		bakery = new Pasticceria(1);
		exit = new Uscita(-1, bakery, "Enel", Date.valueOf("2017-12-11"), 143.90, "Bolletta");
		done = FinanceManager.addUscita(exit);
		assertTrue(done);
			
	}
	
	public void testDelete() throws SQLException {
		
		entry = null;
		done = FinanceManager.deleteFinance(entry);
		assertFalse(done);
		
		entry = new Entrata(-1);
		done = FinanceManager.deleteFinance(entry);
		assertFalse(done);
		
		exit = new Uscita(1);
		done = FinanceManager.deleteFinance(exit);
		assertTrue(done);		
	}
	
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new TestFinanceManager("testAddEntrata"));
		suite.addTest(new TestFinanceManager("testAddUscita"));
		suite.addTest(new TestFinanceManager("testDelete"));
		return suite;
	}
}