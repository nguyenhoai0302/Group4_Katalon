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

// step 1:  Go http://127.0.0.1:8000/login
WebUI.openBrowser(GlobalVariable.URL_LOGIN)

// step 2: Set "example@gmail.com" to the Email text box
WebUI.setText(findTestObject('Object Repository/Login_page/txt_Email') , GlobalVariable.Email, FailureHandling.CONTINUE_ON_FAILURE)

// step 3: Set "Name123!@#" to the Password text box
WebUI.setEncryptedText(findTestObject('Object Repository/Login_page/txt_Password') , '9pLpHanxPWU/nR1wMcS9Kw==', FailureHandling.CONTINUE_ON_FAILURE)

// step 4: Click to "Sign in"
WebUI.click( findTestObject('Object Repository/Login_page/btn_SignIn'), FailureHandling.CONTINUE_ON_FAILURE)

// Verify log in successfully
WebUI.verifyElementText( findTestObject('Object Repository/Login_page/msg_Login'), 'Logged in successfully', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Object Repository/Login_page/mnu_MyProfile') , 5, FailureHandling.CONTINUE_ON_FAILURE)

// Verify the current page is home page
String currentPage = WebUI.getUrl()
WebUI.verifyEqual(currentPage , 'http://127.0.0.1:8000/', FailureHandling.CONTINUE_ON_FAILURE)

// Close modal
WebUI.click( findTestObject('Object Repository/Login_page/btn_OK'), FailureHandling.CONTINUE_ON_FAILURE)

// Click the log out button
//WebUI.click(findTestObject('Object Repository/Login_page/mnu_Toggle') , FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.click(findTestObject('Object Repository/Login_page/btn_LogOut') , FailureHandling.CONTINUE_ON_FAILURE)
