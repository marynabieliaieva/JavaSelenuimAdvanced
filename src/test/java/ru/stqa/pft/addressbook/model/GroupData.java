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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return groupName != null ? groupName.equals(groupData.groupName) : groupData.groupName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
    return result;
  }

  public GroupData(int id, String groupName) {

    this.id = id;
    this.groupName = groupName;

  }

  public GroupData(String groupName) {
    this.id = 0;
    this.groupName = groupName;

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

