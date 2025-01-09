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

'List of products to add to cart'
def products = [
    [name: 'Sculpt Cream Contour Stick', detailObject: 'Object Repository/ShoppingCart_Page/lnk_DetailProduct4'],
    [name: 'Backstage Face & Body Foundation', detailObject: 'Object Repository/ShoppingCart_Page/lnk_DetailProduct5']
]

'Loop through each product in the list'
for (def product : products) {
    'Click on the "Products" button'
    WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/lnk_Products'))

    'Verify that the "All products" text is displayed'
    WebUI.verifyTextPresent('All products', false)

    'Wait for the product to be visible and scroll to it'
    WebUI.waitForElementVisible(findTestObject(product.detailObject), 10)
    WebUI.scrollToElement(findTestObject(product.detailObject), 10)

    'Click on the product to see details'
    WebUI.click(findTestObject(product.detailObject))
    'Verify product name is displayed'
    WebUI.verifyTextPresent(product.name, false)

    'Click "Add to cart" button after ensuring it is clickable'
    WebUI.waitForElementClickable(findTestObject('Object Repository/ShoppingCart_Page/btn_AddToCart'), 10)
    WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/btn_AddToCart'))

    'Verify product added to cart message'
    WebUI.verifyTextPresent('The product has been added to cart.', false)
}

'Click on "My cart" link to display the shopping cart'
WebUI.click(findTestObject('Object Repository/ShoppingCart_Page/lnk_MyCart'))

'Verify that the shopping cart page is displayed'
WebUI.verifyElementVisible(findTestObject('Object Repository/ShoppingCart_Page/tbl_ShoppingCart'))

'Verify the updated quantity of the product in the shopping cart'
WebUI.verifyElementText(findTestObject('Object Repository/ShoppingCart_Page/input_ProductQuantity4'), '1')

'Verify the updated quantity of the product in the shopping cart'
WebUI.verifyElementText(findTestObject('Object Repository/ShoppingCart_Page/input_ProductQuantity5'), '1')

'Close browser'
WebUI.closeBrowser()
