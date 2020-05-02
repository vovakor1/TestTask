import com.google.gson.Gson;
import configuration.User;
import enums.NavigationMenuItem;
import forms.DashboardPage;
import forms.NavigationMenu;
import forms.PersonnelPage;
import forms.AddPersonForm;
import models.Person;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.UpdatePersonSteps;
import utils.FileUtils;

public class CreatePersonTest extends BaseTest {
    private static Person person = new Gson().fromJson(FileUtils.getFileFromResource("/data/person.json"), Person.class);

    @Test
    public void run() {
        log.info("Logging to the portal");
        new LoginSteps().loginToPortal(new User());
        Assert.assertTrue(new DashboardPage().isDisplayed(), "Dashboard page is not displayed");

        log.info("Navigating to the Personnel page");
        new NavigationMenu().clickNavigationMenuItem(NavigationMenuItem.PERSONNEL);
        PersonnelPage personnelPage = new PersonnelPage();
        Assert.assertTrue(personnelPage.isDisplayed(), "Personnel page is not displayed");

        log.info("Opening Update Person form");
        personnelPage.clickAddPerson();

        log.info("Completing Update Person form");
        new UpdatePersonSteps().updatePerson(person);

        log.info("Checking success message");
        Assert.assertTrue(new AddPersonForm().isSuccessMessageDisplayed(), "Success message is not displayed");
    }
}