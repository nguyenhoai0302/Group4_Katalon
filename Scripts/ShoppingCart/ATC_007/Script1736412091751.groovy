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

'Call test case LoginTest trong PurchaseTest'
WebUI.callTestCase(findTestCase('Test Cases/Login/TC001_LoginSuccessfullyWithValidAccount'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on "My cart" link to display the shopping cart'
WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/lnk_MyCart'))

'Verify that the shopping cart page is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/ShoppingCart_Page/tbl_ShoppingCart'))

'Click on the icon trash'
WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/lnk_DeleteProduct'))

'Verify that the product is no longer in the cart'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/ShoppingCart_Page/lnk_DeleteProduct'), 10)

'Close browser'
WebUI.closeBrowser()