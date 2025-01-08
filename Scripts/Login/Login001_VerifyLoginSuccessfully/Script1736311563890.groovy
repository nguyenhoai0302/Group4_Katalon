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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Step 1: Go to the http://127.0.0.1:8000/login
WebUI.openBrowser(GlobalVariable.LOGIN_URL)

// Step 2: Set email value to the Email text box
WebUI.setText(findTestObject('Object Repository/Login_page/txt_Email'), 'example@gmail.com')

// Step 3: Set password value to the Email text box
WebUI.setEncryptedText(findTestObject('Object Repository/Login_page/txt_Password'), '9pLpHanxPWU/nR1wMcS9Kw==')

// Step 4: 4. Click to "Sign in" 
WebUI.click( findTestObject('Object Repository/Login_page/btn_SignIn'), FailureHandling.CONTINUE_ON_FAILURE) 
WebUI.verifyElementText(findTestObject('Object Repository/Login_page/msg_Login'), 'Logged in successfully', FailureHandling.CONTINUE_ON_FAILURE)
// Close modal
WebUI.click(findTestObject('Object Repository/Login_page/btn_OK') , FailureHandling.CONTINUE_ON_FAILURE)

// Verify home page is displayed
String currentUrl = WebUI.getUrl();
boolean isHomePage = WebUI.verifyMatch(currentUrl, 'http://127.0.0.1:8000/', false)

if (isHomePage) {
	WebUI.comment('Verification successful: You are on the Home Page')
} else {
	WebUI.comment('Verification failed: URL does not match the Home Page')
}

// Log out
WebUI.click( findTestObject('Object Repository/Login_page/mnu_Toggle'), FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click( findTestObject('Object Repository/Login_page/btn_LogOut'), FailureHandling.CONTINUE_ON_FAILURE)
// Close browser
WebUI.closeBrowser()
