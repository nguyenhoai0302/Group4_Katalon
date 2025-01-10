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
// Log in to the website
WebUI.openBrowser(GlobalVariable.URL_LOGIN)
WebUI.setText(findTestObject('Object Repository/Login_page/txt_Email') , 'example@gmail.com', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.setEncryptedText(findTestObject('Object Repository/Login_page/txt_Password') , '9pLpHanxPWU/nR1wMcS9Kw==', FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click( findTestObject('Object Repository/Login_page/btn_SignIn'), FailureHandling.CONTINUE_ON_FAILURE)
// Close modal
WebUI.click( findTestObject('Object Repository/Login_page/btn_OK'), FailureHandling.CONTINUE_ON_FAILURE)
// Click to dropdown My profile
WebUI.click(findTestObject('Object Repository/Login_page/mnu_Toggle') , FailureHandling.CONTINUE_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Logout/btn_Logout'), FailureHandling.STOP_ON_FAILURE)

// step 2: Verify 'My profile' button doesn't display
WebUI.verifyElementPresent(findTestObject('Object Repository/Logout/btn_MyCart') , 3, FailureHandling.STOP_ON_FAILURE)

// Close browser
WebUI.closeBrowser()