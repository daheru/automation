package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.MenuOptionsEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class AccountBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger( AccountBusinessTest.class );
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void selectProfileOption() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
	}
	
	public void selectCreateAccount() {
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.CREATE_PROFILE.getMenu() );
	}
	
	public void validateElements() {
		generalBusinessTest.validateElement( NamesMobileElements.ACCOUNT_NAME_CONT );
		generalBusinessTest.validateElement( NamesMobileElements.ACCOUNT_LASTNAME_CONT );
		generalBusinessTest.validateElement( NamesMobileElements.ACCOUNT_EMAIL_CONT );
		generalBusinessTest.validateElement( NamesMobileElements.ACCOUNT_PASS_CONT );
		generalBusinessTest.validateElement( NamesMobileElements.ACCOUNT_SHOW_PASS );
		generalBusinessTest.validateElement( NamesMobileElements.ACCOUNT_TERMS_LINK );
		generalBusinessTest.validateElement( NamesMobileElements.ACCOUNT_CREATE_BUTTON );
		generalBusinessTest.validateElement( NamesMobileElements.ACCOUNT_LOGIN_LINK );
	}
	
	public void createAccount( String name, String lastname, String email, String pass ) {
		fillElement( NamesMobileElements.ACCOUNT_NAME_TEXT, name);
		fillElement( NamesMobileElements.ACCOUNT_LASTNAME_TEXT, lastname);
		fillElement( NamesMobileElements.ACCOUNT_EMAIL_TEXT, email);
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP, NamesMobileElements.ACCOUNT_CREATE_BUTTON );
		fillElement( NamesMobileElements.ACCOUNT_PASS_TEXT, pass);
		tapOnElement( NamesMobileElements.ACCOUNT_CREATE_BUTTON );
	}
	
	public void validateEmptyFields() {
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_NAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_LASTNAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_EMAIL_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_PASS_CONT);
	}
	
	public void validateInvalidData() {
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_NAME, NamesMobileElements.ACCOUNT_NAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_LAST_NAME, NamesMobileElements.ACCOUNT_LASTNAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_EMAIL, NamesMobileElements.ACCOUNT_EMAIL_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_PASS, NamesMobileElements.ACCOUNT_PASS_CONT); 
	}
	
	public void validateExistEmail() {
		generalBusinessTest.validatePopUpMessages( AppMessages.ACCOUNT_EXIST_EMAIL ); 
	}
	
	public void validateCreateAccount() {
		generalBusinessTest.validatePopUpMessages( AppMessages.CREATE_ACCOUNT_SUCCESS );
		selectProfileOption();
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.PROFILE.getMenu() );
	}
	
	public void showPassword( String password ) {
		fillElement( NamesMobileElements.ACCOUNT_PASS_TEXT, password);
		tapOnElement( NamesMobileElements.LOGIN_SHOW_PASS );
		Assert.assertEquals( Boolean.FALSE.toString(), findElement(NamesMobileElements.ACCOUNT_PASS_TEXT).getAttribute("password") );
	}
	
	public void tapTermsLink( ) {
		tapOnElement( NamesMobileElements.ACCOUNT_TERMS_LINK );
	}
	
	public void validateTerms(int elementNum) {
		MobileElement menuTerm = findElement( NamesMobileElements.LIST_TERMS );
		List<MobileElement> terms = findSubElements( menuTerm, NamesMobileElements.LIST_TERM_ELEMENT );
		Assert.assertEquals(elementNum, terms.size());
		for( MobileElement element : terms) {
			element.click();
			tapOnElement( NamesMobileElements.BACK_BUTTON );
		}
	}
	
	public void tapLoginLink( ) {
		tapOnElement( NamesMobileElements.ACCOUNT_LOGIN_LINK );
	}
	
	public void validateLogin( ) {
		MobileElement loginButton = findElement( NamesMobileElements.LOGIN_BUTTON );
		Assert.assertNotNull( loginButton );
	}
	
}
