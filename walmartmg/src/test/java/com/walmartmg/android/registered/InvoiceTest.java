package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.InvoiceBusinessTest;


public class InvoiceTest {
	
	public static final Logger logger = Logger.getLogger( InvoiceTest.class );
	public static InvoiceBusinessTest invoice = new InvoiceBusinessTest();

	@AfterClass
	public static void tearDown(){
		invoice.driverDisconect();
	}	
	
	@Before
	public void resetApp() {
		invoice.closeApp();
		invoice.lauchApp();
	}
	
	//Validate screen
	@Test
	public void CP110_validate_request_invoice() {
		logger.info("Start CP110 invoice");
		invoice.selectProfileOption();
		invoice.selectMenuLogin();
		invoice.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		invoice.selectRequestMyProfile();
		invoice.validateElements();
	}
	
	
	@Test
	public void CP113_empty_code_invoice(){
		logger.info("Start CP113 Validate Empty field");
		invoice.selectProfileOption();
		invoice.selectMenuLogin();
		invoice.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		invoice.selectRequestMyProfile();
		invoice.validateCodeInvoice("");
		invoice.validateMessageEmpty();	
	}
	
	@Test 
	public void CP113_code_correct_invoice() {
		logger.info("Start CP113 Validate correct code");
		invoice.selectProfileOption();
		invoice.selectMenuLogin();
		invoice.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		invoice.selectRequestMyProfile();
		invoice.validateCodeInvoice("55830475286542537193");
	}
	
	@Test
	public void CP114_code_wrong_invoice() {
		logger.info("Start CP114 Validate wrong code");
		invoice.selectProfileOption();
		invoice.selectMenuLogin();
		invoice.login("alejandra.jra11@gmail.com", "12345678");
		logger.info("Menu logueado");
		invoice.selectRequestMyProfile();
		invoice.validateCodeInvoice("55830475286542537199");
		invoice.validateMessageError();
	}

}