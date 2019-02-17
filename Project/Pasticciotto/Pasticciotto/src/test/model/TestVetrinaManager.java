package test.model;

import bean.Ricetta;
import java.sql.SQLException;
import junit.framework.*;
import model.VetrinaManager;

public class TestVetrinaManager extends TestCase{

	private Ricetta recipes;
	private boolean done;
	
	public TestVetrinaManager(String name)
	{
		super(name);
		
	}
	
	public void setUp() throws Exception {
		recipes = null;
		done = false;
	}


	public void tearDown() throws Exception {
		recipes = null;
		done = false;
	}
	
	
	public void testAdd() throws SQLException {
		
		recipes = new Ricetta(-1);
		done = VetrinaManager.add(recipes);
		assertFalse(done);
		
		recipes = new Ricetta(1);
		done = VetrinaManager.add(recipes);
		assertTrue(done);
		
	}
	
	public void testRemove() throws SQLException {
		
		recipes = new Ricetta(-1);
		done = VetrinaManager.remove(recipes);
		assertFalse(done);
		
		recipes = new Ricetta(1);
		done = VetrinaManager.remove(recipes);
		assertTrue(done);
		
	}
	
	public void testModifySalesPrice() throws SQLException {
		recipes = new Ricetta(-1);
		recipes.setPrezzoVendita(-1);
		done = VetrinaManager.modifySalesPrice(recipes);
		assertFalse(done);
		
		recipes = new Ricetta(1);
		recipes.setPrezzoVendita(-1);
		done = VetrinaManager.modifySalesPrice(recipes);
		assertFalse(done);
		
		recipes = new Ricetta(1);
		recipes.setPrezzoVendita(18.5);
		done = VetrinaManager.modifySalesPrice(recipes);
		assertTrue(done);
		
	}
	
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new TestVetrinaManager("testAdd"));
		suite.addTest(new TestVetrinaManager("testRemove"));
		suite.addTest(new TestVetrinaManager("testModifySalesPrice"));
		return suite;
	}
}