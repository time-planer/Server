package com.niton.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * The Member of a group defined by his name and permissions
 */
@ApiModel(description = "The Member of a group defined by his name and permissions")

public class GroupMember  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("email")
  private String email;

  @JsonProperty("edit")
  private Boolean edit;

  @JsonProperty("create")
  private Boolean create;

  @JsonProperty("delete")
  private Boolean delete;

  public GroupMember email(String email) {
    this.email = email;
    return this;
  }

  /**
   * The email of the user
   * @return email
  */
  @ApiModelProperty(required = true, value = "The email of the user")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public GroupMember edit(Boolean edit) {
    this.edit = edit;
    return this;
  }

  /**
   * Is the user permitted to edit tasks within the group
   * @return edit
  */
  @ApiModelProperty(required = true, value = "Is the user permitted to edit tasks within the group")
  @NotNull


  public Boolean isEdit() {
    return edit;
  }

  public void setEdit(Boolean edit) {
    this.edit = edit;
  }

  public GroupMember create(Boolean create) {
    this.create = create;
    return this;
  }

  /**
   * is the user permitted to create tasks within the Group
   * @return create
  */
  @ApiModelProperty(required = true, value = "is the user permitted to create tasks within the Group")
  @NotNull


  public Boolean isCreate() {
    return create;
  }

  public void setCreate(Boolean create) {
    this.create = create;
  }

  public GroupMember delete(Boolean delete) {
    this.delete = delete;
    return this;
  }

  /**
   * is the User permitted to delte tasks within the group
   * @return delete
  */
  @ApiModelProperty(required = true, value = "is the User permitted to delte tasks within the group")
  @NotNull


  public Boolean isDelete() {
    return delete;
  }

  public void setDelete(Boolean delete) {
    this.delete = delete;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GroupMember groupMember = (GroupMember) o;
    return Objects.equals(this.email, groupMember.email) &&
        Objects.equals(this.edit, groupMember.edit) &&
        Objects.equals(this.create, groupMember.create) &&
        Objects.equals(this.delete, groupMember.delete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, edit, create, delete);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupMember {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    edit: ").append(toIndentedString(edit)).append("\n");
    sb.append("    create: ").append(toIndentedString(create)).append("\n");
    sb.append("    delete: ").append(toIndentedString(delete)).append("\n");
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

