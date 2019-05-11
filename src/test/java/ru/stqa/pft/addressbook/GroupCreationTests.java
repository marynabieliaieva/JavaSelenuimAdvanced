package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupCreationTests {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception{
    wd= new FirefoxDriver();
  }

  @Test
  public void GroupCreationTests(){
    wd.get("https://www.postable.com");
    wd.findElement(By.linkText("Login")).click();
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys("marynelko@gmail.com");
    wd.findElement(By.name("password")).click();
    wd.findElement(By.name("password")).clear();
    wd.findElement(By.name("password")).sendKeys("123456");
    wd.findElement(By.cssSelector("button[class='full-width']")).click();

  }

}
