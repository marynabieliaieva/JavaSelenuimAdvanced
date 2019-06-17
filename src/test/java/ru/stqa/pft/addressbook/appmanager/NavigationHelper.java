package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void goToAddContactPage() throws InterruptedException {
    Thread.sleep(1000);
    wd.get("https://email.seznam.cz/#abook");
  }
}
