package enums;

import lombok.Getter;

@Getter
public enum NavigationMenuItem {
    PERSONNEL("personnel", "Personnel");

    private String menuItem;
    private String name;

    NavigationMenuItem(String menuItem, String name) {
        this.menuItem = menuItem;
        this.name = name;
    }
}