package ru.stqa.pft.addressbook.model;

public class GroupData {
  private final String groupName;


  public GroupData(String groupName) {
    this.groupName = groupName;
  }

  public String getgroupName() {
    return groupName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
  }

  @Override
  public int hashCode() {
    return groupName != null ? groupName.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "groupName='" + groupName + '\'' +
            '}';
  }
}

