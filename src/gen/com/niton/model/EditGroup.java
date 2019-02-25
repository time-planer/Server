package com.niton.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.niton.model.GroupMember;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * An edited version of a group
 */
@ApiModel(description = "An edited version of a group")

public class EditGroup  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("members")
  @Valid
  private List<GroupMember> members = null;

  public EditGroup name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the group, must **NOT** be unique
   * @return name
  */
  @ApiModelProperty(example = "1BHIT", value = "The name of the group, must **NOT** be unique")

@Size(min=3,max=100) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EditGroup description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A short description of the Group visible for all members
   * @return description
  */
  @ApiModelProperty(value = "A short description of the Group visible for all members")

@Size(min=0,max=2500) 
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public EditGroup members(List<GroupMember> members) {
    this.members = members;
    return this;
  }

  public EditGroup addMembersItem(GroupMember membersItem) {
    if (this.members == null) {
      this.members = new ArrayList<>();
    }
    this.members.add(membersItem);
    return this;
  }

  /**
   * The List of members in the Group
   * @return members
  */
  @ApiModelProperty(value = "The List of members in the Group")

  @Valid

  public List<GroupMember> getMembers() {
    return members;
  }

  public void setMembers(List<GroupMember> members) {
    this.members = members;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EditGroup editGroup = (EditGroup) o;
    return Objects.equals(this.name, editGroup.name) &&
        Objects.equals(this.description, editGroup.description) &&
        Objects.equals(this.members, editGroup.members);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, members);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EditGroup {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
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

