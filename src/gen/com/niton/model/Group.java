package com.niton.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.niton.model.GroupMember;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * All information about the group
 */
@ApiModel(description = "All information about the group")

public class Group  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("members")
  @Valid
  private List<GroupMember> members = new ArrayList<>();

  @JsonProperty("creation_date")
  private LocalDate creationDate;

  @JsonProperty("tasks")
  @Valid
  private List<String> tasks = new ArrayList<>();

  @JsonProperty("creator")
  private String creator;

  @JsonProperty("uid")
  private String uid;

  public Group name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the group, must **NOT** be unique
   * @return name
  */
  @ApiModelProperty(example = "1BHIT", required = true, value = "The name of the group, must **NOT** be unique")
  @NotNull

@Size(min=3,max=100) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Group description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A short description of the Group visible for all members
   * @return description
  */
  @ApiModelProperty(required = true, value = "A short description of the Group visible for all members")
  @NotNull

@Size(min=0,max=2500) 
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Group members(List<GroupMember> members) {
    this.members = members;
    return this;
  }

  public Group addMembersItem(GroupMember membersItem) {
    this.members.add(membersItem);
    return this;
  }

  /**
   * The List of members in the Group
   * @return members
  */
  @ApiModelProperty(required = true, value = "The List of members in the Group")
  @NotNull

  @Valid

  public List<GroupMember> getMembers() {
    return members;
  }

  public void setMembers(List<GroupMember> members) {
    this.members = members;
  }

  public Group creationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * The date when the group was created
   * @return creationDate
  */
  @ApiModelProperty(required = true, value = "The date when the group was created")
  @NotNull

  @Valid

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public Group tasks(List<String> tasks) {
    this.tasks = tasks;
    return this;
  }

  public Group addTasksItem(String tasksItem) {
    this.tasks.add(tasksItem);
    return this;
  }

  /**
   * The list of all tasks within the Group
   * @return tasks
  */
  @ApiModelProperty(required = true, value = "The list of all tasks within the Group")
  @NotNull


  public List<String> getTasks() {
    return tasks;
  }

  public void setTasks(List<String> tasks) {
    this.tasks = tasks;
  }

  public Group creator(String creator) {
    this.creator = creator;
    return this;
  }

  /**
   * The email of the creator of the group
   * @return creator
  */
  @ApiModelProperty(required = true, value = "The email of the creator of the group")
  @NotNull


  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Group uid(String uid) {
    this.uid = uid;
    return this;
  }

  /**
   * An identifyer for the Group as multiple groups with the same name can exist
   * @return uid
  */
  @ApiModelProperty(required = true, value = "An identifyer for the Group as multiple groups with the same name can exist")
  @NotNull

@Pattern(regexp="[A-Z0-9a-z]{30}") @Size(min=30,max=30) 
  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Group group = (Group) o;
    return Objects.equals(this.name, group.name) &&
        Objects.equals(this.description, group.description) &&
        Objects.equals(this.members, group.members) &&
        Objects.equals(this.creationDate, group.creationDate) &&
        Objects.equals(this.tasks, group.tasks) &&
        Objects.equals(this.creator, group.creator) &&
        Objects.equals(this.uid, group.uid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, members, creationDate, tasks, creator, uid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Group {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

