package Primer1;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class NewTest {
	
	@BeforeTest
	public void m1() {
		System.out.println("Pocetak testa m1");
	}
	@AfterTest
	public void m2 () {
		System.out.println("pocetak testa m2...");
	}
	
	@BeforeClass
	public void naPocetkuKlase() {
		System.out.println("Na pocetku klase se izvrsila...@BeforeClass");
	}
	
	@AfterClass
	public void naKrajuKlase() {
		System.out.println("Na kraju klase se izvrsava...@AfterClass");
	}
	
  @Test
  public void f() {
	  System.out.println("Izvrsenje testa 1. ");
  }
  
 /* @Test
  public void f1() {
	  System.out.println("Metoda f1 sa @Test anotacijom...");
  }*/
  
  @Test
  public void metodaTest2 () {
	  System.out.println("Pocetak metode test 2");
	  
	  Operacije op = new Operacije (1, 2, 3);
	  int rezultat = op.zbir();
	  
	  //Hard assertion - ako nesto nije uredu sa kodom, on tu stoje u ovoj metodi (npr nece ispisati print ispod njega).
	  Assert.assertEquals(rezultat,  6);
	  
	  System.out.println("Nesto ispod Assert-a...");
  }
  @Test
  public void metodaTest3() {
		System.out.println("Pocetak metode test 3");

		Operacije op = new Operacije(1, 2, 3);
		int rezultat = op.zbir();
		
		SoftAssert sa = new SoftAssert ();
		
		sa.assertEquals(rezultat, 10);
		System.out.println("Nesto pisemo... ");
		sa.assertEquals(rezultat, 6);
		System.out.println(".........");
		
		sa.assertEquals(rezultat, 4);
		System.out.println("********");
		
		
		sa.assertAll();
		
		
  }
}
