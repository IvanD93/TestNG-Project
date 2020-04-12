package banka_test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import banka_kod.Account;
public class AccountTest {
	
	@Test
	public void testKonstruktor() {
		
		String ime= "Ivan";
		String broj = "25345234";
		
		Account racun = new Account(ime, broj);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(racun.getName(), ime);
		sa.assertEquals(racun.getNumber(), broj);
		sa.assertEquals(racun.getAmount(), 0.0);
		
		sa.assertAll();
	}

}
