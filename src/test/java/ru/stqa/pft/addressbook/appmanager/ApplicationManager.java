package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;

  public NavigationHelper navigationHelper;
  public ContactHelper contactHelper;
  public GroupHelper groupHelper;
  public SessionHelper sessionHelper;

  public void init() throws InterruptedException {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    wd.get("https://login.szn.cz/");
    wd.manage().window().maximize();
    contactHelper = new ContactHelper(wd);
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("ta168872", "Buska123");
  }



  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
