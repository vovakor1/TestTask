package forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DashboardPage extends Form {
    public DashboardPage() {
        super(By.xpath("//span[@data-test = 'dashboard-working-progress-indicator']"), "Dashboard Page");
    }
}