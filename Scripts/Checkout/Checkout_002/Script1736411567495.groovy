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

// Step 1: Open browser and navigate to the login page
WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:8000/login')

// Step 2: Login with valid user data (assuming valid session is created)
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Email'), 'van123@gmail.com')
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Password'), '12345')
WebUI.click(findTestObject('Object Repository/Login_Page/btn_SignIn'))

// Step 3: Navigate to the checkout page
WebUI.navigateToUrl('http://127.0.0.1:8000/checkout')

// Step 4: Retrieve session data (this is pseudocode, adapt based on your framework/server)
def sessionUsername = WebUI.executeJavaScript('return sessionStorage.getItem("username")', null)
def sessionEmail = WebUI.executeJavaScript('return sessionStorage.getItem("email")', null)
def sessionPhone = WebUI.executeJavaScript('return sessionStorage.getItem("phone")', null)
def sessionAddress = WebUI.executeJavaScript('return sessionStorage.getItem("address")', null)

// Step 5: Verify that the checkout page displays the correct data from the session
String displayedUsername = WebUI.getAttribute(findTestObject('Object Repository/Checkout_Page/txt_Username'), 'value')
String displayedEmail = WebUI.getAttribute(findTestObject('Object Repository/Checkout_Page/txt_Email'), 'value')
String displayedPhone = WebUI.getAttribute(findTestObject('Object Repository/Checkout_Page/txt_Phone'), 'value')
String displayedAddress = WebUI.getAttribute(findTestObject('Object Repository/Checkout_Page/txt_Address'), 'value')

// Step 6: Compare session data with the displayed data on the checkout page
WebUI.verifyMatch(displayedUsername, sessionUsername, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(displayedEmail, sessionEmail, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(displayedPhone, sessionPhone, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(displayedAddress, sessionAddress, false, FailureHandling.CONTINUE_ON_FAILURE)

// Step 7: Close browser after the verification
WebUI.closeBrowser()