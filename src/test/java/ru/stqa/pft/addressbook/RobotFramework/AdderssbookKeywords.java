package ru.stqa.pft.addressbook.RobotFramework;

import org.openqa.selenium.remote.BrowserType;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.IOException;

public class AdderssbookKeywords {
  public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

  private ApplicationManager app;

  public void initApplicationManager() throws IOException, InterruptedException {
    app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    app.init();
  }

  public void stopApplicationManager(){
    app.stop();
    app = null;
  }

  public int getGroupCount() throws InterruptedException {
    app.goTo().contactPage();
    return app.getGroupHelper().getGroupCount();
  }

  public void createGroup(String name) throws InterruptedException {
    app.goTo().contactPage();
    app.getGroupHelper().createGroup(new GroupData().withName(name));
  }
}
