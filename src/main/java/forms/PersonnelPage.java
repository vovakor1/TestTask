package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonnelPage extends Form {
    private final IButton addPersonBtn = getElementFactory().getButton(By.xpath("//a[@data-test = 'add-person-button']"), "Add Person");

    public PersonnelPage() {
        super(By.xpath("//div[contains(@class, 'card') and contains(@class, 'mt-2')]"), "Personnel Page");
    }

    public void clickAddPerson() {
        addPersonBtn.clickAndWait();
    }
}