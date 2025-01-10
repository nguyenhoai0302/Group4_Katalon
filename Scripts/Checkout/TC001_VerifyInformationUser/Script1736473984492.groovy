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

// Call previous test case


// Step 3: Navigate to the checkout page
WebUI.click(findTestObject('Object Repository/Checkout_Page/btn_ProccedToCheckout'))

// Step 4: Retrieve session details
def sessionUsername = GlobalVariable.UserName
def sessionEmail = GlobalVariable.Email
def sessionPhone = GlobalVariable.Phone
def sessionAddress = GlobalVariable.Address

// Step 5: Get checkout page details and verify them
String displayedUsername = WebUI.getAttribute(findTestObject('Object Repository/Checkout_Page/txt_Username'), 'value')
String displayedEmail = WebUI.getAttribute(findTestObject('Object Repository/Checkout_Page/txt_Email'), 'value')
String displayedPhone = WebUI.getAttribute(findTestObject('Object Repository/Checkout_Page/txt_Phone'), 'value')
String displayedAddress = WebUI.getAttribute(findTestObject('Object Repository/Checkout_Page/txt_Address'), 'value')

WebUI.verifyMatch(displayedUsername, sessionUsername, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(displayedEmail, sessionEmail, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(displayedPhone, sessionPhone, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(displayedAddress, sessionAddress, false, FailureHandling.CONTINUE_ON_FAILURE)

