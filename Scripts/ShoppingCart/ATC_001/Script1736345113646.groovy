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

WebUI.scrollToElement(findTestObject('Object Repository/ShoppingCart_Page/lnk_DetailProduct'), 10)
WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/lnk_DetailProduct'))

'Click on the product "Super Serum Skin Tint SPF 40 Skincare Foundation'
//WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/lnk_DetailProduct'))

'Verify that the message "Super Serum Skin Tint SPF 40 Skincare Foundation" text is displayed'
WebUI.verifyTextPresent('Super Serum Skin Tint SPF 40 Skincare Foundation', false)

'Click "Add to cart" button'
WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/btn_AddToCart'))

'Verify the message "The product has been added to cart." is displayed'
WebUI.verifyTextPresent('The product has been added to cart.', false)

'Close browser'
WebUI.closeBrowser()