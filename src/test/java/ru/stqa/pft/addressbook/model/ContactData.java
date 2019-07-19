package ru.stqa.pft.addressbook.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "addressbook")
public class ContactData {
  @Id
  @Column(name="id")
  private int id;

  @Column(name="firstname")
  private String name;

  @Column(name="lastName")
  private String lastName;

  @Column(name="firma")
  @Type(type = "text")
  private String firma;

  @Column(name="photo")
  private String photo;

  @Transient
  private String group;


  public Object getPhoto() {
    return new File(photo);
  }

  public void setPhoto(File photo) {
    this.photo = photo.getPath();
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


