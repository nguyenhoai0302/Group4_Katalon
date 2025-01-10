import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import ch.qos.logback.core.joran.conditional.ElseAction
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Step 1: Open the browser and navigate to the login page
WebUI.openBrowser(GlobalVariable.URL_LOGIN)

// Step 2: Loop through test data
for (int row = 1; row <= findTestData('LoginData/LoginData').getRowNumbers(); row++) {
	// Get data from file
	String email = findTestData('LoginData/LoginData').getValue('email', row)
	String password = findTestData('LoginData/LoginData').getValue('password', row)
	String expectedResult = findTestData('LoginData/LoginData').getValue('result', row)
	String expectedErrorEmail = findTestData('LoginData/LoginData').getValue('messageErrorEmail', row)
	String expectedErrorPassword = findTestData('LoginData/LoginData').getValue('messageErrorPassword', row)

	if(email != null && email != '') {
		WebUI.setText(findTestObject('Object Repository/Login_page/txt_Email'), email, FailureHandling.CONTINUE_ON_FAILURE)
	}
	if (password != null && password != '') {
		WebUI.setText(findTestObject('Object Repository/Login_page/txt_Password'), password, FailureHandling.CONTINUE_ON_FAILURE)
	}
	// Click 'Sign In' button
	WebUI.click(findTestObject('Object Repository/Login_page/btn_SignIn'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.delay(5)
	// Check result
	if (expectedResult != null && !expectedResult.isEmpty())  { 
		WebUI.verifyElementText(findTestObject('Object Repository/Login_page/msg_Login'), expectedResult, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Login_page/mnu_MyProfile'), 5, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Login_page/btn_OK'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Login_page/mnu_Toggle'), FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Login_page/btn_LogOut'), FailureHandling.CONTINUE_ON_FAILURE)
		// Return to log in page
		WebUI.navigateToUrl(GlobalVariable.URL_LOGIN)
	} else {
		if (expectedErrorEmail != null && !expectedErrorEmail.isEmpty()) {
			WebUI.verifyElementText(findTestObject('Object Repository/Login_page/lbl_EmailErrorMessage'), expectedErrorEmail, FailureHandling.CONTINUE_ON_FAILURE)
		}
		if (expectedErrorPassword != null && !expectedErrorPassword.isEmpty())  {
			println(row + expectedErrorPassword )
			WebUI.verifyElementText(findTestObject('Object Repository/Login_page/lbl_PasswordErrorMessage') , expectedErrorPassword, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}
}

// Step 3: Close the browser
WebUI.closeBrowser()
