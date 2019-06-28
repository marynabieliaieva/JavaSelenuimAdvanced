package ru.stqa.pft.addressbook.model;

public class ContactData {
  private String name;
  private String lastName;
  private String firma;


  public ContactData(String name, String lastName, String firma) {
    this.name = name;
    this.lastName = lastName;
    this.firma = firma;
  }


  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirma() {
    return firma;
  }


}


