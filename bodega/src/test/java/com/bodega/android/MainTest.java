package com.bodega.android;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.MainBusinessTest;
import com.bodega.constants.AppMessages;
import com.bodega.enums.MenuOptionsEnum;
import com.bodega.vo.AddressVO;

public class MainTest {

	public static final Logger logger = Logger.getLogger(MainTest.class);
	public static MainBusinessTest main = new MainBusinessTest();
	public static GeneralBusinessTest general = new GeneralBusinessTest();
	public static AddressVO addressVO;

	@BeforeClass
	public static void init() {
		addressVO = new AddressVO("Direccion ", "Juan", "Perez", "Av Rodolfo Gaona 46", "456", "", "11200",
				"Lomas Hermosa", "Entre walmart", "Plaza Toreo", "Fijo", "5555555555");
	}

	@AfterClass
	public static void shutDown() {
		main.driverDisconect();
	}

	@Before
	public void initApp() {
		main.closeAndroidDialog();
		general.validateWelcomePage();
	}

	@After
	public void relauchApp() {
		main.resetApp();
	}

	@Test
	public void CF012_add_new_address_as_favorite() {
		logger.info("Iniciando caso de prueba: New Adress As Favorite");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.ADDRESS.getMenu());
		main.selectAddAddress();
		main.addNewDirection(addressVO);
		main.selectAsMainAddress(true);
		main.saveDirection();
		main.validateAddress(false, AppMessages.ADD_ADDRESS);
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF012_add_new_address() {
		logger.info("Iniciando caso de prueba: New Adress As Favorite");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.ADDRESS.getMenu());
		main.selectAddAddress();
		main.addNewDirection(addressVO);
		main.selectAsMainAddress(false);
		main.saveDirection();
		main.validateAddress(false, AppMessages.ADD_ADDRESS);
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF013_edit_main_address() {
		logger.info("Iniciando caso de prueba: Edit Address");
		addressVO.setAddressName("Mi direccion");
		addressVO.setAddressPhone("5512345678");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.ADDRESS.getMenu());
		main.selectAddAddress();
		main.editAddress(addressVO);
		main.saveDirection();
		main.validateAddress(true, AppMessages.ADD_ADDRESS);
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF014_remove_address() {
		logger.info("Iniciando caso de prueba: Remove address");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.ADDRESS.getMenu());
		main.removeAddress(addressVO);
		main.validateRemoveAddress();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF015_view_orders() {
		logger.info("Iniciando caso de prueba: View orders");
		// juan@correo.com 12345678
		// emmanuel.dominguez@live.com.mx Edominguez#1234
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("juan@correo.com", "12345678");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.ORDERS.getMenu());
		main.validateOrderPage();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF016_view_order_detail() {
		logger.info("Iniciando caso de prueba: View order detail");
		// juan@correo.com 12345678
		// emmanuel.dominguez@live.com.mx Edominguez#1234
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.ORDERS.getMenu());
		String orderNumber[] = main.orderDetail();
		main.validateOrderDetail(orderNumber);
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF017_view_notifications() {
		logger.info("Iniciando caso de prueba: View notifications");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.NOTIFICATIONS.getMenu());
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF019_scan_manually_ticket() {
		logger.info("Iniciando caso de prueba: Scan manually ticket");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.GET_BILL.getMenu());
		main.closeAndroidDialog();
		main.manualBill("36214691686686662445");
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF023_CF024_validate_suppor_page() {
		logger.info("Iniciando caso de prueba: Validate Support Page");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.SUPPORT.getMenu());
		main.validateSupportPage();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF025_CF029_validate_terms_page() {
		logger.info("Iniciando caso de prueba: Validate Terms Page");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.TERMS.getMenu());
		main.validateTerms(5);
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF030_CF035_validate_legals_page() {
		logger.info("Iniciando caso de prueba: Validate Legals Page");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LEGALS.getMenu());
		main.validateLegalsPage();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CF306_logout() {
		logger.info("Iniciando caso de prueba: Logout success");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGOUT.getMenu());
		main.validateLogout();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CF115_add_address_without_data() {
		addressVO = new AddressVO();
		logger.info("Iniciando caso de prueba: Add address without data");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		main.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
		main.selectProfile();
		main.selectMenu(MenuOptionsEnum.ADDRESS.getMenu());
		main.selectAddAddress();
		main.saveDirection();
		main.validateAddressErrorMessages();
	}
	
}