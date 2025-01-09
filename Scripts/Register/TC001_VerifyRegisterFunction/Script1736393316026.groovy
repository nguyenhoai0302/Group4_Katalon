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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import registerActions.RegisterActions as RegisterActions

// open browser and navigate to register url
WebUI.openBrowser(GlobalVariable.REGISTER_URL)

// verify current page is register page
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_RegisterTitle')), 'Register')

// get data from data file 
def registrationData = findTestData('Data Files/RegistrationData/RegistrationData')

// create RegisterActions object 
RegisterActions registerActions = new RegisterActions()

for (def index : (1..registrationData.getRowNumbers())) {
	
	// 	Get data test from registration data. 
	String name = registrationData.getValue('Name', index)
	String email = registrationData.getValue('Email', index)
	String phone = registrationData.getValue('Phone', index)
	String address = registrationData.getValue('Address', index)
	String password = registrationData.getValue('Password', index)
	String confirmPassword = registrationData.getValue('ConfirmPassword', index)
	String expectedResult = registrationData.getValue('ExpectedResult', index)

	// Set data into input of the register form.
	WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Name'), name)
	WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Email'), email)
	WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Phone'), phone)
	WebUI.setText(findTestObject('Object Repository/Register_Page/txa_Address'), address)
	WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Password'), password)
	WebUI.setText(findTestObject('Object Repository/Register_Page/txt_ConformPassword'), confirmPassword)
	
	// verify confirm password is matched with password
	String passwordValue = WebUI.getAttribute(findTestObject('Object Repository/Register_Page/txt_Password'), 'value')
	String confirmPasswordValue = WebUI.getAttribute(findTestObject('Object Repository/Register_Page/txt_ConformPassword'), 'value')

	if (passwordValue != confirmPasswordValue) {
		KeywordUtil.markFailed('Password and Confirm Password do not match!')
	} else {
		KeywordUtil.markPassed('Password and Confirm Password match.')
	}
	
	// click button create account 
	WebUI.click(findTestObject('Object Repository/Register_Page/btn_CreateAccount'))

	switch (expectedResult) {
		case 'Registration successful':
			registerActions.verifyRegisterSuccessful()
			WebUI.back()
			break
		case 'Email already exists':
			registerActions.verifyRegisterFailWithEmailExits()
			break
		case 'Missing required fields':
			registerActions.verifyRegisterFailWithEmptyFields()
			break
		case 'Invalid email format':
			registerActions.verifyRegisterFailWithInvalidEmail()
			break
		case 'Invalid phone number':
			registerActions.verifyRegisterFailWithShortPhoneNumber()
			break
		case 'Password too short':
			registerActions.verifyRegisterFailWithShortPassword()
			break
	}
}

WebUI.closeBrowser()