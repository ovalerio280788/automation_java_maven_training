package org.automation.testcases;

import org.automation.configurations.selenium.TestCaseBase;
import org.automation.pageobjects.DashBoardPage;
import org.automation.pageobjects.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginSuite extends TestCaseBase {

    @Test(groups = {"full_regression"})
    @Parameters({"username", "password"})
    public void validLogin(String userName, String password) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        loginPage.fillUserName(userName);
        loginPage.fillPassword(password);
        DashBoardPage dashBoardPage = loginPage.submit();

        // verificar que el login fue exitoso
        Assert.assertTrue(dashBoardPage.isChangePasswordDisplayed(), "NO se mostro el link para cambio de contrasena");
        Assert.assertTrue(dashBoardPage.isLogOutDisplayed(), "NO se mostro el link para cerrar session");
    }
}
