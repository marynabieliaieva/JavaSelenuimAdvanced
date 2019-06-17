package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String lastName;

  public ContactData(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }
}
