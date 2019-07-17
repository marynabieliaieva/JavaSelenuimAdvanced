package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {
  private String name;
  private String lastName;
  private String firma;
  private Object photo;


  public Object getPhoto() {
    return (File) photo;
  }

  public void setPhoto(File photo) {
    this.photo = photo;
  }

  public ContactData(String name, String lastName, String firma/*, Object photo*/) {
    this.name = name;
    this.lastName = lastName;
    this.firma = firma;
    //this.photo = photo;
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


