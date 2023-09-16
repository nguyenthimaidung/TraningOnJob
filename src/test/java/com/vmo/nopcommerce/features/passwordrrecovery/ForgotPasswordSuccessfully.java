package com.vmo.nopcommerce.features.passwordrrecovery;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.PageGenerator;
import com.vmo.nopcommerce.pageobject.PasswordRecoveryObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ForgotPasswordSuccessfully extends BaseTest {

    WebDriver driver;
    private PasswordRecoveryObject forgot;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        driver = getDriverBrowser(browser);
        forgot = PageGenerator.getPasswordRecoveryObject(driver);
        Log.info("Open driver success");
    }
    @Test
    public void TC04_ForgotPassword(){
        forgot.gotoURL("https://demo.nopcommerce.com/");
        forgot.verifyTitle("nopCommerce demo store");
        Log.info("Open correct page");
        forgot.clickLogin();
        forgot.verifyTitle("nopCommerce demo store. Login");
        forgot.clickForgotPassword();
        forgot.verifyTitle("nopCommerce demo store. Password Recovery");
        forgot.inputEmail("dungntm@vmogroup.com");
        forgot.clickBtnRecover();
        forgot.verifyMessage();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        cleanBrowserAndDriver();
        Log.info("Close dirver success");
    }
}
