package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import enums.Nationality;
import enums.Rank;
import org.openqa.selenium.By;

public class AddPersonForm extends Form {
    private final ITextBox firstNameTxb = getElementFactory().getTextBox(By.name("Firstname"), "First Name");
    private final ITextBox lastNameTxb = getElementFactory().getTextBox(By.name("Surname"), "Last Name");
    private final ITextBox dateOfBirthTxb = getElementFactory().getTextBox(By.name("DateOfBirth"), "DateOfBirth");
    private final ITextBox addressTxb = getElementFactory().getTextBox(By.name("Address"), "Address");
    private final IComboBox nationalityCmb = getElementFactory().getComboBox(By.name("Nationality"), "Nationality");
    private final IComboBox rankCmb = getElementFactory().getComboBox(By.name("Rank"), "Rank");
    private final IButton saveBtn = getElementFactory().getButton(By.xpath("//button[@data-test = 'add-save-button']"), "Save");
    private final ILabel successMessageLbl = getElementFactory().getLabel(By.xpath("//div[@data-test = 'success-alert']"), "Success message");

    public AddPersonForm() {
        super(By.xpath("//h4[contains(text(), 'Add new person')]"), "Add Person Form");
    }

    public void enterFirstName(String firstName) {
        firstNameTxb.clearAndType(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameTxb.clearAndType(lastName);
    }

    public void enterDateOfBirth(String dateOfBirth) {
        dateOfBirthTxb.clearAndType(dateOfBirth);
    }

    public void enterAddress(String address) {
        addressTxb.clearAndType(address);
    }

    public void selectNationality(Nationality nationality) {
        nationalityCmb.clickAndSelectByValue(nationality.getNationality());
    }

    public void selectRank(Rank rank) {
        rankCmb.clickAndSelectByText(rank.getRank());
    }

    public void clickSave() {
        saveBtn.clickAndWait();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessageLbl.getElement().isDisplayed();
    }
}