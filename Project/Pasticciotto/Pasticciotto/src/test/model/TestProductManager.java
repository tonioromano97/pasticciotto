package test.model;



import java.sql.SQLException;

import bean.Pasticceria;
import bean.Prodotto;
import junit.framework.*;
import model.ProductManager;

public class TestProductManager extends TestCase{

	private Prodotto product;
	private boolean done;
	private Pasticceria bakery;
	
	public TestProductManager(String name)
	{
		super(name);
		
	}
	
	public void setUp() throws Exception {
		product = null;
		bakery = null;
	}


	public void tearDown() throws Exception {
		product = null;
		done = false;
	}
	
	
	public void testAdd() throws SQLException {
		
		//FN2
		product = new Prodotto(null, -1, "", -1, 1, -1);
		done = ProductManager.add(product);
		assertFalse(done);
		
		//FN1 FQ2
		product = new Prodotto(null, -1, "Zucchero a velo", -1, -1, -1);
		done = ProductManager.add(product);
		assertFalse(done);

		//FN1 FQ1
		product = new Prodotto(null, -1, "Zucchero a velo", 10, -1, -1);
		done = ProductManager.add(product);
		assertFalse(done);
		
		//FN1 FQ1 FP2
		product = new Prodotto(null, -1, "Zucchero a velo", 10, -1, -1);
		done = ProductManager.add(product);
		assertFalse(done);
		
		//FN1 FQ1 FP1
		product = new Prodotto(null, -1, "Zucchero a velo", 10, -1, 10.90);
		done = ProductManager.add(product);
		assertFalse(done);
		
		//FN1 FQ1 FP1 E2
		product = new Prodotto(null, -1, "Zucchero a velo", 10, -1, 10.90);
		done = ProductManager.add(product);
		assertFalse(done);
		
		//FN1 FQ1 FP1 E1
		bakery = new Pasticceria(3);
		product = new Prodotto(bakery, -1, "Zucchero a velo", 10, -1, 10.90);
		done = ProductManager.add(product);
		assertTrue(done);
		
	}
	
	public void testDelete() throws SQLException {
		product = null;
		done = ProductManager.delete(product);
		assertFalse(done);
		
		product = new Prodotto(-1);
		done = ProductManager.delete(product);
		assertFalse(done);
		
		product = new Prodotto(3);
		done = ProductManager.delete(product);
		assertTrue(done);
		
	}
	
	public void testModify() throws SQLException {
		
		
		product = new Prodotto(null, -1, "", -1, 1, -1);
		done = ProductManager.modifyProduct(product);
		assertFalse(done);
		
		product = new Prodotto(null, -1, "Zucchero a velo", -1, -1, -1);
		done = ProductManager.modifyProduct(product);
		assertFalse(done);
		
		product = new Prodotto(null, -1, "Zucchero a velo", 10, -1, -1);
		done = ProductManager.modifyProduct(product);
		assertFalse(done);
		
		product = new Prodotto(null, -1, "Zucchero a velo", 10, 10, -1);
		done = ProductManager.modifyProduct(product);
		assertFalse(done);
		
		product = new Prodotto(null, -1, "Zucchero a velo", 10, 10, 10.90);
		done = ProductManager.modifyProduct(product);
		assertFalse(done);
		
		bakery = new Pasticceria(-1);
		product = new Prodotto(bakery, -1, "Zucchero a velo", 10, 10, 10.90);
		done = ProductManager.modifyProduct(product);
		assertFalse(done);
		
		bakery = new Pasticceria(1);
		product = new Prodotto(bakery, 1, "Zucchero a velo", 10, 10, 10.90);
		done = ProductManager.modifyProduct(product);
		assertTrue(done);
				
	}
	
	
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new TestProductManager("testAdd"));
		suite.addTest(new TestProductManager("testDelete"));
		suite.addTest(new TestProductManager("testModify"));
		return suite;
	}
}