package test.model;



import java.sql.SQLException;

import bean.Pasticceria;
import bean.Prodotto;
import bean.Ricetta;
import junit.framework.*;
import model.RecipeManager;


public class TestRecipeManager extends TestCase{

	private Prodotto product;
	private Ricetta recipe;
	private Pasticceria bakery;
	private boolean done;
	
	public TestRecipeManager(String name)
	{
		super(name);
		
	}
	
	public void setUp() throws Exception {
		recipe = null;
		bakery = null;
		product = null;
		done = false;
	}


	public void tearDown() throws Exception {
		bakery = null;
		recipe = null;
		product = null;
		done = false;
	}

	
	public void testAdd() throws SQLException {
		//recipe = new Ricetta(codice, nome, h, m, prezzoVendita, prezzoAcquisto, p)
		recipe = new Ricetta(-1, "", -1, -1, -1, -1, null);
		done = RecipeManager.add(recipe);
		assertFalse(done);
		
		recipe = new Ricetta(-1, "RicettaN", -1, -1, -1, -1, null);
		done = RecipeManager.add(recipe);
		assertFalse(done);
		
		recipe = new Ricetta(-1, "RicettaN", 1, -1, -1, -1, null);
		done = RecipeManager.add(recipe);
		assertFalse(done);
		
		recipe = new Ricetta(-1, "RicettaN", 1, 20, -1, -1, null);
		done = RecipeManager.add(recipe);
		assertFalse(done);
		
		recipe = new Ricetta(-1, "RicettaN", 1, 20, 20, -1, null);
		done = RecipeManager.add(recipe);
		assertFalse(done);
		
		recipe = new Ricetta(-1, "RicettaN", 1, 20, 20, 20, null);
		done = RecipeManager.add(recipe);
		assertFalse(done);
		
		bakery = new Pasticceria(-1);
		recipe = new Ricetta(-1, "RicettaN", 1, 20, 20, 20, bakery);
		done = RecipeManager.add(recipe);
		assertFalse(done);
		
		bakery = new Pasticceria(1);
		recipe = new Ricetta(-1, "RicettaN", 1, 20, 20, 20, bakery);
		done = RecipeManager.add(recipe);
		assertTrue(done);
		
		
	}
	public void testUpdate() throws SQLException {
		
		
		//add
		
		recipe = null;
		product = null;
		done = RecipeManager.updateComposition(recipe, product, 0);
		assertFalse(done);
		
		recipe = new Ricetta(-1);
		product = null;
		done = RecipeManager.updateComposition(recipe, product, 0);
		assertFalse(done);
		
		recipe = new Ricetta(1);
		product = null;
		done = RecipeManager.updateComposition(recipe, product, 0);
		assertFalse(done);
		
		recipe = new Ricetta(1);
		product = new Prodotto(-1);
		product.setQuantita(-1);
		done = RecipeManager.updateComposition(recipe, product, 0);
		assertFalse(done);
		
		recipe = new Ricetta(1);
		product = new Prodotto(1);
		product.setQuantita(-1);
		done = RecipeManager.updateComposition(recipe, product, 0);
		assertFalse(done);
		
		recipe = new Ricetta(1);
		product = new Prodotto(1);
		product.setQuantita(10);
		done = RecipeManager.updateComposition(recipe, product, 0);
		assertTrue(done);
		
		//remove
		
		recipe = null;
		product = null;
		done = RecipeManager.updateComposition(recipe, product, 1);
		assertFalse(done);
		
		recipe = new Ricetta(-1);
		product = null;
		done = RecipeManager.updateComposition(recipe, product, 1);
		assertFalse(done);
		
		recipe = new Ricetta(1);
		product = null;
		done = RecipeManager.updateComposition(recipe, product, 1);
		assertFalse(done);
		
		recipe = new Ricetta(1);
		product = new Prodotto(-1);
		done = RecipeManager.updateComposition(recipe, product, 1);
		assertFalse(done);
		
		
		recipe = new Ricetta(1);
		product = new Prodotto(1);
		done = RecipeManager.updateComposition(recipe, product, 1);
		assertTrue(done);
		
	}
	
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new TestRecipeManager("testAdd"));
		suite.addTest(new TestRecipeManager("testUpdate"));
		return suite;
	}
}