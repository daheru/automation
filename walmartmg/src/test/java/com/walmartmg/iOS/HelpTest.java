package com.walmartmg.iOS;

import org.junit.AfterClass;
import org.junit.Test;

import com.walmartmg.business.iOS.HelpBusinessTest;

public class HelpTest {
	public static HelpBusinessTest help = new HelpBusinessTest();

	@AfterClass
	public static void tearDown() {
		help.driverDisconect();
	}

	@Test // Entrar a apartado ayuda
	public void Enter() {
		help.selectProfile();
		help.selectMenu();
		help.helpPage();

	}

}
