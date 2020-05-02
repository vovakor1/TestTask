package models;

import enums.Nationality;
import enums.Rank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private Nationality nationality;
    private Rank rank;
}