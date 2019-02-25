package com.niton.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A Group only containing the complete neccessary information
 */
@ApiModel(description = "A Group only containing the complete neccessary information")

public class ReducedGroup  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("members")
  private Integer members;

  @JsonProperty("creation_date")
  private LocalDate creationDate;

  @JsonProperty("tasks")
  private Integer tasks;

  @JsonProperty("uid")
  private String uid;

  public ReducedGroup name(String name) {
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

  public ReducedGroup description(String description) {
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

  public ReducedGroup members(Integer members) {
    this.members = members;
    return this;
  }

  /**
   * The number of members in the Group
   * minimum: 0
   * @return members
  */
  @ApiModelProperty(required = true, value = "The number of members in the Group")
  @NotNull

@Min(0)
  public Integer getMembers() {
    return members;
  }

  public void setMembers(Integer members) {
    this.members = members;
  }

  public ReducedGroup creationDate(LocalDate creationDate) {
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

  public ReducedGroup tasks(Integer tasks) {
    this.tasks = tasks;
    return this;
  }

  /**
   * The number of all tasks within the Group
   * minimum: 0
   * @return tasks
  */
  @ApiModelProperty(example = "5", required = true, value = "The number of all tasks within the Group")
  @NotNull

@Min(0)
  public Integer getTasks() {
    return tasks;
  }

  public void setTasks(Integer tasks) {
    this.tasks = tasks;
  }

  public ReducedGroup uid(String uid) {
    this.uid = uid;
    return this;
  }

  /**
   * An identifyer for the Group as multiple groups with the same name can exist
   * @return uid
  */
  @ApiModelProperty(required = true, value = "An identifyer for the Group as multiple groups with the same name can exist")
  @NotNull

@Pattern(regexp="[A-Za-z0-9]{30}") @Size(min=30,max=30) 
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
    ReducedGroup reducedGroup = (ReducedGroup) o;
    return Objects.equals(this.name, reducedGroup.name) &&
        Objects.equals(this.description, reducedGroup.description) &&
        Objects.equals(this.members, reducedGroup.members) &&
        Objects.equals(this.creationDate, reducedGroup.creationDate) &&
        Objects.equals(this.tasks, reducedGroup.tasks) &&
        Objects.equals(this.uid, reducedGroup.uid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, members, creationDate, tasks, uid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReducedGroup {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    members: ").append(toIndentedString(members)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    tasks: ").append(toIndentedString(tasks)).append("\n");
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

