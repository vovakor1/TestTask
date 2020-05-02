package steps;

import forms.AddPersonForm;
import models.Person;

public class UpdatePersonSteps {
    public void updatePerson(Person person) {
        AddPersonForm addPersonForm = new AddPersonForm();

        addPersonForm.enterFirstName(person.getFirstName());
        addPersonForm.enterLastName(person.getLastName());
        addPersonForm.enterDateOfBirth(person.getDateOfBirth());
        addPersonForm.enterAddress(person.getAddress());
        addPersonForm.selectNationality(person.getNationality());
        addPersonForm.selectRank(person.getRank());

        addPersonForm.clickSave();
    }
}