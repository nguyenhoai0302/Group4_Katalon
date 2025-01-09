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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


// open browser and navigate to register url
WebUI.openBrowser(GlobalVariable.REGISTER_URL)

// verify current page is register page
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_RegisterTitle')), 'Register')

WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Name') , "Name 1")
WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Email'), "example123@gmail.com")
WebUI.setText( findTestObject('Object Repository/Register_Page/txt_Phone'), "0993456778")
WebUI.setText(findTestObject('Object Repository/Register_Page/txa_Address') , "Son Tra - Da Nang")
WebUI.setEncryptedText(findTestObject('Object Repository/Register_Page/txt_Password') , "9pLpHanxPWU/nR1wMcS9Kw==")
WebUI.setEncryptedText(findTestObject('Object Repository/Register_Page/txt_ConformPassword'), "9pLpHanxPWU/nR1wMcS9Kw==")

// verify confirm password is matched with password
String passwordValue = WebUI.getAttribute(findTestObject('Object Repository/Register_Page/txt_Password'), 'value')
String confirmPasswordValue = WebUI.getAttribute(findTestObject('Object Repository/Register_Page/txt_ConformPassword'), 'value')

if (passwordValue != confirmPasswordValue) {
	KeywordUtil.markFailed('Password and Confirm Password do not match!')
} else {
	KeywordUtil.markPassed('Password and Confirm Password match.')
}

// click button create account
WebUI.click(findTestObject('Object Repository/Register_Page/btn_CreateAccount'))

WebUI.waitForPageLoad(5)
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_Message') ), "You have registered successfuly")
WebUI.click(findTestObject('Object Repository/Register_Page/btn_OK'))
WebUI.waitForPageLoad(5)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_SignInTitle')), "Sign in")

