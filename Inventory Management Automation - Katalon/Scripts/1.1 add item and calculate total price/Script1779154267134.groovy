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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject


WebUI.openBrowser('file:///C:/Users/mufidatun.l/Documents/test/test.html')

WebUI.maximizeWindow()
int price = 1000
int qty = 1

WebUI.setText(findTestObject('Object Repository/add item and total calculation/Page_Inventory System/input_Inventory Manager_itemName'), 
    'book')

WebUI.setText(findTestObject('Object Repository/add item and total calculation/Page_Inventory System/input_Inventory Manager_itemPrice'), 
    price.toString())

WebUI.setText(findTestObject('Object Repository/add item and total calculation/Page_Inventory System/input_Inventory Manager_itemQty'), 
    qty.toString())

WebUI.click(findTestObject('Object Repository/add item and total calculation/Page_Inventory System/button_Add Item'))

double total = (price * qty) * 1.11
String expectedTotal = String.format("%.2f", total)

TestObject dynamicTotal = new TestObject()

dynamicTotal.addProperty(
	'xpath',
	ConditionType.EQUALS,
	"//span[text()='" + expectedTotal + "']"
)

WebUI.verifyElementPresent(dynamicTotal, 5)

WebUI.closeBrowser()