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

WebUI.openBrowser('')
WebUI.navigateToUrl('http://127.0.0.1:8000/login')

WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Email'), 'van123@gmail.com')
WebUI.setText(findTestObject('Object Repository/Login_Page/txt_Password'), '12345')
WebUI.click(findTestObject('Object Repository/Login_Page/btn_SignIn'))

WebUI.navigateToUrl('http://127.0.0.1:8000/checkout')


// Step 1: Find Username field
WebUI.clearText(findTestObject('Object Repository/Checkout_Page/txt_Email'))

// Step 2: Click "Place Order" button
WebUI.click(findTestObject('Object Repository/Checkout_Page/btn_PlaceOrder'))

// Step 3: Verify error message
WebUI.verifyElementVisible(findTestObject('Object Repository/Checkout_Page/span_EmailErrorMessage'))