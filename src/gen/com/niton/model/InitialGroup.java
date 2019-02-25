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
 * The Data Type to create an Group.  It is the reduced form of an Group as it only contains the values needed for initialisation.
 */
@ApiModel(description = "The Data Type to create an Group.  It is the reduced form of an Group as it only contains the values needed for initialisation.")

public class InitialGroup  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("description")
  private String description;

  @JsonProperty("name")
  private String name;

  public InitialGroup description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A Description of the Group what it is for
   * @return description
  */
  @ApiModelProperty(required = true, value = "A Description of the Group what it is for")
  @NotNull

@Size(min=0,max=2500) 
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public InitialGroup name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the task.  **NOT** unique
   * @return name
  */
  @ApiModelProperty(example = "1BHIT", required = true, value = "The name of the task.  **NOT** unique")
  @NotNull

@Size(min=3,max=100) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitialGroup initialGroup = (InitialGroup) o;
    return Objects.equals(this.description, initialGroup.description) &&
        Objects.equals(this.name, initialGroup.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitialGroup {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

