package ru.stqa.pft.addressbook;

public class contactData {
  private final String name;
  private final String lastName;

  public contactData(String name, String lastName) {
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
