package com.walmartmg.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.FiltersBusinessTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Filters Module - No session")
public class FiltersTest {
	
	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger( FiltersTest.class );
	private static FiltersBusinessTest filters = new FiltersBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		filters.driverDisconect();
	}	
	
	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}
	
	@After
	public void resetApp() {
		filters.resetApp();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Validate filters")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to filter search results")
	@Description("Validate that filters page has all elements")
	public void CP081_validate_filters() {
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.validateScreenFilter();
	}
	
	@Test
	@DisplayName("Filter results by A-Z filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to filter search results")
	@Description("Filter search result list usign A-Z filter")
	public void CP082_filter_order_by_az() {
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.filterOrderAZ();
	}
	
	@Test
	@DisplayName("Filter results by Z-A filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to filter search results")
	@Description("Filter search result list usign A-Z filter")
	public void CP083_filter_order_by_za() {
		logger.info("Start CP083 Filter Order By Z - A");
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.filterOrderZA();
	}
	
	@Test
	@DisplayName("Filter results by minnor filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to filter search results")
	@Description("Filter search result list usign minnor filter")
	public void CP084_filter_orderby_smallest_to_largest() {
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.filterSmallestToLargest();
	}
	
	@Test
	@DisplayName("Filter results by higher filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to filter search results")
	@Description("Filter search result list usign higher filter")
	public void CP085_filter_orderby_largest_to_smallest() {
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.filterLargestToSmallest();
	}
	
	@Test
	@DisplayName("Filter results by popularity filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to filter search results")
	@Description("Filter search result list usign popularity filter")
	public void CP086_filter_order_by_popularity () {
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.filterPopularity();
	}
	
	@Test
	@DisplayName("Filter results by sub category filter")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to filter search results")
	@Description("Filter search result list usign sub category filter")
	public void CP088_filter_filter_by () {
		filters.selectDepartmentOption();
		filters.selectDepartment();
		filters.selectFamily();
		filters.filterBy();
	}
}