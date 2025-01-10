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
WebUI.callTestCase(findTestCase('ShoppingCart/ATC_003'), [:], FailureHandling.STOP_ON_FAILURE)


// Step 1: Get cart details
String cartProductName = WebUI.getText(findTestObject('Object Repository/ShoppingCart_Page/lbl_ProductName'))

String cartProductQuantity = WebUI.getText(findTestObject('Object Repository/ShoppingCart_Page/lbl_Quantity'))

String cartProductPrice = WebUI.getText(findTestObject('Object Repository/ShoppingCart_Page/lbl_Price'))

String cartProductTotalPrice = WebUI.getText(findTestObject('Object Repository/ShoppingCart_Page/lbl_TotalPrice'))

// Calculate total price (quantity * price) and compare with cartProductTotalPrice
double quantity = Double.parseDouble(cartProductQuantity)

double price = Double.parseDouble(cartProductPrice.replaceAll('[^0-9.]', ''))

double calculatedTotalPrice = quantity * price

WebUI.verifyEqual(Double.parseDouble(cartProductTotalPrice.replaceAll('[^0-9.]', '')), calculatedTotalPrice)

// Step 3: Navigate to the checkout page
WebUI.click(findTestObject('Object Repository/Checkout_Page/btn_ProccedToCheckout'))


// Step 6: Get product details from the checkout page
String checkoutProductName = WebUI.getText(findTestObject('Object Repository/Checkout_Page/lbl_ProductName'))
String checkoutProductPrice = WebUI.getText(findTestObject('Object Repository/Checkout_Page/lbl_ProductPrice'))
String checkoutProductTotalPrice = WebUI.getText(findTestObject('Object Repository/Checkout_Page/lbl_ProductTotalPrice'))
String checkoutTotalOfPayment = WebUI.getText(findTestObject('Object Repository/Checkout_Page/lbl_TotalOfPayment'))

// Verify product name and total prices match between cart and checkout pages
WebUI.verifyMatch(cartProductName, checkoutProductName, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(cartProductTotalPrice, checkoutProductTotalPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(checkoutProductTotalPrice, checkoutTotalOfPayment, false, FailureHandling.CONTINUE_ON_FAILURE)