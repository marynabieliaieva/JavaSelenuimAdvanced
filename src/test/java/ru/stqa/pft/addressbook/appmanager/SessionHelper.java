package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase{

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String userName, String password) throws InterruptedException {
    type(By.id("login-username"), userName);
    Thread.sleep(1000);
    type(By.id("login-password"), password);
    Thread.sleep(1000);
    click(By.cssSelector("form.login > button:nth-child(8)"));
  }

}
