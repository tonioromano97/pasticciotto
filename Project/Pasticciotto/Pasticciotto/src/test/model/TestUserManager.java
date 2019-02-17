package test.model;



import java.sql.SQLException;

import bean.Pasticceria;
import bean.Utente;
import junit.framework.*;
import model.UserManager;


public class TestUserManager extends TestCase{

	private Utente user;
	private boolean done;
	private Pasticceria bakery;
	
	public TestUserManager(String name)
	{
		super(name);
		
	}
	
	public void setUp() throws Exception {
		user = null;
		bakery = null;
	}


	public void tearDown() throws Exception {
		user = null;
		done = false;
	}

	
	public void testLogin() throws SQLException
	{
		user = UserManager.login("", null);
		assertNull(user);
		
		user = new Utente();
		user = UserManager.login("pasti@mail.it", null);
		assertNull(user);
		
		user = new Utente();
		user = UserManager.login("mario.rossi@mail.it", "");
		assertNull(user); 
		
		user = new Utente();
		user = UserManager.login("mario.rossi@mail.it", "6C47D77D1C44E6A4243157B10B81E3B5");
		assertNotNull(user);
	}
	
	public void testRegister() throws SQLException
	{
		user = new Utente();
		done = UserManager.register(user);
		assertFalse(done);
		
		user = new Utente("Vittorio",null,null,null,null,null,null,-1);
		done = UserManager.register(user);
		assertFalse(done);
		
		user = new Utente("Vittorio","Bianchi",null,null,null,null,null,-1);
		done = UserManager.register(user);
		assertFalse(done);
		
		user = new Utente("Vittorio","Bianchi","vittorio.bianchi@mail.it",null,null,null,null,-1);
		done = UserManager.register(user);
		assertFalse(done);
		
		user = new Utente("Vittorio","Bianchi","vittorio.bianchi@mail.it","Pasticceria.111",null,null,null,-1);
		done = UserManager.register(user);
		assertFalse(done);
	
		user = new Utente("Vittorio","Bianchi","vittorio.bianchi@mail.it","Pasticceria.111",null,null,"Proprietario",-1);
		done = UserManager.register(user);
		assertTrue(done);
		
		user = new Utente("Vittorio","Bianchi","vittorio.bianchi10@mail.it","Pasticceria.111","123456789",null,"Proprietario",-1);
		done = UserManager.register(user);
		assertTrue(done);
		
		user = new Utente("Vittorio","Bianchi","vittorio.bianchi12@mail.it","Pasticceria.111","123456789",new Pasticceria(999),"Proprietario",-1);
		done = UserManager.register(user);
		assertFalse(done);
		
		user = new Utente("Vittorio","Bianchi","vittorio.bianchi11@mail.it","Pasticceria.111","123456789",new Pasticceria(1),"Proprietario",-1);
		done = UserManager.register(user);
		assertTrue(done);
		
	}
	
	public void testAddPasticceria() throws SQLException
	{
		user = new Utente("marco","rossi","marco.rossi@mail.it","Pasticciotto.111","1234567",null,"Proprietario",0);
		
		done = UserManager.addPasticceria(null, null);
		assertFalse(done);
		
		done = UserManager.addPasticceria(null, user);
		assertFalse(done);
		
		bakery = new Pasticceria(1,null,null,"pasticceria@mail.it","783273891", "Pasticceria dal 1983", "http://www.pasticceria.it", "/pasticcerie/pasticceria.png");
		done = UserManager.addPasticceria(bakery, user);
		assertFalse(done);
	
		bakery = new Pasticceria(1,"pasticceria",null,"pasticceria@mail.it","783273891", "Pasticceria dal 1983", "http://www.pasticceria.it", "/pasticcerie/pasticceria.png");
		done = UserManager.addPasticceria(bakery, user);
		assertFalse(done);
		
		bakery = new Pasticceria(1,"pasticceria","Via roma 306","pasticceria@mail.it","783273891", "Pasticceria dal 1983", "http://www.pasticceria.it", "/pasticcerie/pasticceria.png");
		done = UserManager.addPasticceria(bakery, user);
		assertTrue(done);
	}
	
	public void testModifyEmail() throws SQLException
	{
		
		done = UserManager.modifyEmail(null, null);
		assertFalse(done);
		
		user = new Utente("marco","rossi","giuseppe@mail.it","Pasticciotto.111","1234567",null,"Proprietario",0);
		done = UserManager.modifyEmail(user, null);
		assertFalse(done);
		
		user = new Utente("Giuseppe","Rossi","mario.rossi@mail.it","Pasticciotto.111","1234567",null,"Proprietario",0);
		done = UserManager.modifyEmail(user, null);
		assertFalse(done);
		
		done = UserManager.modifyEmail(user, "giuseppe.rossi10@mail.it");
		assertTrue(done);
	}
	
	public void testModifyPassword() throws SQLException
	{
		done = UserManager.modifyPassword(null, null);
		assertFalse(done);
		
		user = new Utente("marco","rossi","giuseppe@mail.it","Pasticciotto.111","1234567",null,"Proprietario",0);
		done = UserManager.modifyPassword(user, null);
		assertFalse(done);
		
		user = new Utente("Giuseppe","Rossi","giuseppe.rossi10@mail.it","Pasticciotto.111","1234567",null,"Proprietario",0);
		done = UserManager.modifyPassword(user, null);
		assertFalse(done);
		
		done = UserManager.modifyPassword(user, "Pasticceria.101010");
		assertTrue(done);
		
	}
	public static Test suite(){
		TestSuite suite = new TestSuite();
		suite.addTest(new TestUserManager("testModifyPassword"));
		return suite;
		
	}
}
