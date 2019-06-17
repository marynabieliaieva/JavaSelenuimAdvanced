package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() throws InterruptedException {
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
  }
  }
