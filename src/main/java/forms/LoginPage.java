package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LoginPage extends Form {
    private static final String XPATH_TEMPLATE = "//input[@name = '%s']";

    private final ITextBox companyTxb = getElementFactory().getTextBox(By.xpath(String.format(XPATH_TEMPLATE, "Company")), "Company");
    private final ITextBox loginTxb = getElementFactory().getTextBox(By.xpath(String.format(XPATH_TEMPLATE, "User")), "User");
    private final ITextBox passwordTxb = getElementFactory().getTextBox(By.xpath(String.format(XPATH_TEMPLATE, "Password")), "Password");
    private final IButton loginBtn = getElementFactory().getButton(By.xpath("//button[@data-test = 'login-submit-button']"), "Login");

    public LoginPage(){
        super(By.xpath("//div[contains(@class, 'login-box')]"), "Login page");
    }

    public void enterCompany(String company) {
        companyTxb.clearAndType(company);
    }

    public void enterLogin(String login) {
        loginTxb.clearAndType(login);
    }

    public void enterPassword(String password) {
        passwordTxb.clearAndType(password);
    }

    public void clickLogin() {
        loginBtn.clickAndWait();
    }
}