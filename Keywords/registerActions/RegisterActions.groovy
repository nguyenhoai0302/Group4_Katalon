package registerActions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class RegisterActions {

	def fillRegisterForm(String name, String email, String phone, String address, String password, String confirmPassword) {
		WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Name') , name)
		WebUI.setText(findTestObject('Object Repository/Register_Page/txt_Email'), email)
		WebUI.setText( findTestObject('Object Repository/Register_Page/txt_Phone'), phone)
		WebUI.setText(findTestObject('Object Repository/Register_Page/txa_Address') , address)
		WebUI.setEncryptedText(findTestObject('Object Repository/Register_Page/txt_Password') , password)
		WebUI.setEncryptedText(findTestObject('Object Repository/Register_Page/txt_ConformPassword'), confirmPassword)
	}

	def verifyRegisterSuccessful() {
		WebUI.waitForPageLoad(5)
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_Message') ), "You have registered successfuly")
		WebUI.click(findTestObject('Object Repository/Register_Page/btn_OK'))
		WebUI.waitForPageLoad(5)
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_SignInTitle')), "Sign in")
	}

	def verifyRegisterFailWithEmailExits() {

		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_MessageEmail')) , "The email has already been taken.")
	}

	def verifyRegisterFailWithEmptyFields() {

		WebUI.verifyEqual( WebUI.getText( findTestObject('Object Repository/Register_Page/lbl_MessageName')), "The username field is required.")
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_MessageEmail') ), "The email field is required.")
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_MessagePhone')) , "The phone field is required.")
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_MessageAddress')), "The address field is required.")
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_MessagePassword')), "The password field is required.")
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_MessageConfirmPassword')) , "The confirm password field is required.")
	}

	def verifyRegisterFailWithShortPassword() {
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_MessagePassword')) , "The password must be at least 8 characters long.", FailureHandling.STOP_ON_FAILURE)
	}

	def verifyRegisterFailWithInvalidEmail() {
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_MessageEmail') ) , "The email must be a valid email address.")
	}

	def verifyRegisterFailWithShortPhoneNumber() {
		WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/Register_Page/lbl_MessagePhone') ) , "The phone must be 10 digits.")
	}
}
