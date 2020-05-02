package steps;

import configuration.User;
import forms.LoginPage;

public class LoginSteps {
    public void loginToPortal(User user) {
        LoginPage loginPage = new LoginPage();

        loginPage.enterCompany(user.getCompany());
        loginPage.enterLogin(user.getLogin());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLogin();
    }
}