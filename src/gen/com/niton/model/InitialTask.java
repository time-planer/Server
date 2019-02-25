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
 * A reduced task for adding
 */
@ApiModel(description = "A reduced task for adding")

public class InitialTask  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("deadline")
  private LocalDate deadline;

  @JsonProperty("planedDate")
  private LocalDate planedDate;

  @JsonProperty("description")
  private String description;

  @JsonProperty("importance")
  private Integer importance;

  public InitialTask name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the Task. needs to be uniqe
   * @return name
  */
  @ApiModelProperty(required = true, value = "The name of the Task. needs to be uniqe")
  @NotNull

@Size(min=1,max=50) 
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InitialTask deadline(LocalDate deadline) {
    this.deadline = deadline;
    return this;
  }

  /**
   * The last date where it is totaly needs to be done.
   * @return deadline
  */
  @ApiModelProperty(required = true, value = "The last date where it is totaly needs to be done.")
  @NotNull

  @Valid

  public LocalDate getDeadline() {
    return deadline;
  }

  public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
  }

  public InitialTask planedDate(LocalDate planedDate) {
    this.planedDate = planedDate;
    return this;
  }

  /**
   * The date at which you planed to be done with the task
   * @return planedDate
  */
  @ApiModelProperty(required = true, value = "The date at which you planed to be done with the task")
  @NotNull

  @Valid

  public LocalDate getPlanedDate() {
    return planedDate;
  }

  public void setPlanedDate(LocalDate planedDate) {
    this.planedDate = planedDate;
  }

  public InitialTask description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description of the task
   * @return description
  */
  @ApiModelProperty(required = true, value = "The description of the task")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public InitialTask importance(Integer importance) {
    this.importance = importance;
    return this;
  }

  /**
   * A google playstore like rating. it is from zero to ten. Each point describing a half star. 10 is the best as it is 5 Stars
   * minimum: 0
   * maximum: 10
   * @return importance
  */
  @ApiModelProperty(example = "4", required = true, value = "A google playstore like rating. it is from zero to ten. Each point describing a half star. 10 is the best as it is 5 Stars")
  @NotNull

@Min(0) @Max(10) 
  public Integer getImportance() {
    return importance;
  }

  public void setImportance(Integer importance) {
    this.importance = importance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InitialTask initialTask = (InitialTask) o;
    return Objects.equals(this.name, initialTask.name) &&
        Objects.equals(this.deadline, initialTask.deadline) &&
        Objects.equals(this.planedDate, initialTask.planedDate) &&
        Objects.equals(this.description, initialTask.description) &&
        Objects.equals(this.importance, initialTask.importance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, deadline, planedDate, description, importance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InitialTask {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
    sb.append("    planedDate: ").append(toIndentedString(planedDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    importance: ").append(toIndentedString(importance)).append("\n");
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

