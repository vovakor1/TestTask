package enums;

import lombok.Getter;

@Getter
public enum Nationality {
    AUSTRIA("115");

    private String nationality;

    Nationality(String nationality) {
        this.nationality = nationality;
    }
}