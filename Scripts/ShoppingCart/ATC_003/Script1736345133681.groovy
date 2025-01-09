import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

'Click on the "Products" button'
WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/lnk_Products'))

'Click on the "Products" button'
WebUI.verifyTextPresent('All products', false)
	
'Click on the product "Positive Light Silky Touch Highlighter" to see details'
WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/lnk_DetailProduct3'))

'Verify that the message "Positive Light Silky Touch Highlighter" text is displayed'
WebUI.verifyTextPresent('Positive Light Silky Touch Highlighter', false)

'Click "Add to cart" button'
WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/btn_AddToCart'))

'Verify that the message "The product has been added to cart." is displayed'
WebUI.verifyTextPresent('The product has been added to cart.', false)

'Click on "My cart" link to display the shopping cart'
WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/lnk_MyCart'))

'Verify that the shopping cart page is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/ShoppingCart_Page/tbl_ShoppingCart'))

'Verify the updated quantity of the product in the shopping cart'
WebUI.verifyElementText(findTestObject('Object Repository/ShoppingCart_Page/input_ProductQuantity3'), '1')

'Close browser'
WebUI.closeBrowser()
