package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import enums.NavigationMenuItem;
import org.openqa.selenium.By;

public class NavigationMenu extends Form {
    private static String XPATH_TEMPLATE = "//a[contains(@class, 'nav-link') and contains(@href, '%s')]";

    public NavigationMenu() {
        super(By.xpath("//nav[contains(@class, 'navbar')]"), "Navigation Menu");
    }

    private IButton getNavigationMenuItem(NavigationMenuItem menuItem) {
        return getElementFactory().getButton(By.xpath(String.format(XPATH_TEMPLATE, menuItem.getMenuItem())), menuItem.getName());
    }

    public void clickNavigationMenuItem(NavigationMenuItem menuItem) {
        getNavigationMenuItem(menuItem).clickAndWait();
    }
}