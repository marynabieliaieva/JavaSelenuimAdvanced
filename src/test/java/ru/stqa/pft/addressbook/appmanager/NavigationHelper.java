package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void contactPage() throws InterruptedException {
    Thread.sleep(1000);
    By buttonLocator = By.cssSelector("span.button-group:nth-child(4) > button:nth-child(1)");
    if (! isElementPresent(buttonLocator)&& wd.findElement(buttonLocator).getText().equals("Přidat kontakt")){
      return;
    }
    wd.get("https://email.seznam.cz/#abook");
  }
}
