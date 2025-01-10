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

// Pre-condition the user has logged out
WebUI.callTestCase(findTestCase('Logout/TC001_VerifyLogoutSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

// step 1 Go to http://127.0.0.1:8000
WebUI.openBrowser('http://127.0.0.1:8000')

// step 2: Click the 'My cart' button
WebUI.click(findTestObject('Object Repository/Logout/btn_MyCart') , FailureHandling.CONTINUE_ON_FAILURE)

// verify the user is redirected the user to sign in page 
String currentPage = WebUI.getUrl()
WebUI.verifyEqual(currentPage , GlobalVariable.URL_LOGIN, FailureHandling.CONTINUE_ON_FAILURE)

