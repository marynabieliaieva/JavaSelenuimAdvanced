package ru.stqa.pft.addressbook.model;

public class GroupData {
  private int id;
  private final String groupName;

  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", groupName='" + groupName + '\'' +
            '}';
  }

  public GroupData(int id, String groupName) {

    this.id = id;
    this.groupName = groupName;

  }

  public GroupData(String groupName) {
    this.id = Integer.MAX_VALUE; // because of that group will be at the last place
    this.groupName = groupName;

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

  public String getgroupName() {
    return groupName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}

