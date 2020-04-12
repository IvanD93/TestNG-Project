package banka_test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.*;

import banka_kod.Account;
import banka_kod.Bank;

public class BankTest {

	Bank mobi;

	@BeforeClass
	public void konstruktor() {
		mobi = new Bank();
	}

	@Test(priority = 3)
	public void testOpen() {

		int max = 5;
		Account racuni[] = new Account[max];
		for (int i = 0; i < max; i++) {
			racuni[i] = mobi.openAccount("ivan" + i);
			Assert.assertEquals(mobi.getAccount(racuni[i].getNumber()), racuni[i]);
		}
	}

	@Test(priority = 2)
	public void testUplata() {

		Double uplata = 1500d;
		Account a1 = mobi.openAccount("ivan");
		
		Double stanjeNakonUplate = a1.getAmount() + uplata;
		
		mobi.payInMoney(a1.getNumber(), uplata);
		
		Assert.assertEquals(a1.getAmount(), stanjeNakonUplate);	
	}
	

	@Test(priority = 1)
	public void testTransfer() {
		Double prenos= 1000d;
		Account a1 = mobi.openAccount("Dragoljub");
		Account a2 = mobi.openAccount("Djordje");
		
		a2.setAmount(10000d);
		
		mobi.transferMoney(a2.getNumber(), a1.getNumber(), prenos);
		
		SoftAssert sa = new SoftAssert ();
		
		sa.assertEquals(a1.getAmount(), 1000d);
		sa.assertEquals(a2.getAmount(), 9000d);
		
		sa.assertAll();
	}
}
