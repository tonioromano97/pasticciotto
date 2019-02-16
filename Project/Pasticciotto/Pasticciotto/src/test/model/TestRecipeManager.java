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


public class TestRecipeManager extends TestCase{

	private Pasticceria bakery;
	private boolean done;
	
	public TestRecipeManager(String name)
	{
		super(name);
		
	}
	
	public void setUp() throws Exception {
		bakery = null;	
	}


	public void tearDown() throws Exception {
		done = false;
	}

	public void testUpdate() throws SQLException {}
	public void testAdd() throws SQLException {}
	public void testGetRecipes() throws SQLException {}
	public void testUpdate() throws SQLException {}
	public void testUpdate() throws SQLException {}
	
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new TestRecipeManager(""));
		return suite;
		
	}
}
