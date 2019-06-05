package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {
  FirefoxDriver wd;


  @BeforeMethod
  public void setUp() throws Exception{
    wd= new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    wd.get("https://mailbook.nl/");
    login("marynelko@gmail.com", "Ab123456");
  }

  private void login(String userName, String password) {
    wd.findElement(By.linkText("Login")).click();
    wd.findElement(By.id("email")).click();
    wd.findElement(By.id("email")).clear();
    wd.findElement(By.id("email")).sendKeys(userName);
    wd.findElement(By.id("password")).click();
    wd.findElement(By.id("password")).clear();
    wd.findElement(By.id("password")).sendKeys(password);
    wd.findElement(By.cssSelector("div[class='field row end']>button")).click();
  }

  @Test
  public void testGroupCreation(){
    goToAddContactPage();
    initContactCreation(new contactData("Lars", "Jochansen"));
    submitContactCreation();
  }

  private void initContactCreation(contactData contactData) {
    wd.findElement(By.id("to")).click();
    wd.findElement(By.id("to")).clear();
    wd.findElement(By.id("to")).sendKeys(contactData.getName());
    wd.findElement(By.id("lastName")).click();
    wd.findElement(By.id("lastName")).clear();
    wd.findElement(By.id("lastName")).sendKeys(contactData.getLastName());

  }

  private void goToAddContactPage() {
    wd.findElement(By.cssSelector("div[class='field row addressbook']>button")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.cssSelector("div[class='field row end']>button")).click();
  }

  @AfterMethod
  public void tearDown(){
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd){
    try{
      wd.switchTo().alert();
      return true;
    }
    catch (NoAlertPresentException e){
      return false;
      }
  }

}
