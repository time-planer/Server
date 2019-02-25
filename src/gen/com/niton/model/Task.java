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
 * A task is a thing you need to do till a certain point.
 */
@ApiModel(description = "A task is a thing you need to do till a certain point.")

public class Task  implements Serializable {
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

  @JsonProperty("entererAt")
  private LocalDate entererAt;

  @JsonProperty("process")
  private Integer process;

  public Task name(String name) {
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

  public Task deadline(LocalDate deadline) {
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

  public Task planedDate(LocalDate planedDate) {
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

  public Task description(String description) {
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

  public Task importance(Integer importance) {
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

  public Task entererAt(LocalDate entererAt) {
    this.entererAt = entererAt;
    return this;
  }

  /**
   * The date the taks was created
   * @return entererAt
  */
  @ApiModelProperty(required = true, value = "The date the taks was created")
  @NotNull

  @Valid

  public LocalDate getEntererAt() {
    return entererAt;
  }

  public void setEntererAt(LocalDate entererAt) {
    this.entererAt = entererAt;
  }

  public Task process(Integer process) {
    this.process = process;
    return this;
  }

  /**
   * How far the task is done in percent
   * minimum: 0
   * maximum: 100
   * @return process
  */
  @ApiModelProperty(required = true, value = "How far the task is done in percent")
  @NotNull

@Min(0) @Max(100) 
  public Integer getProcess() {
    return process;
  }

  public void setProcess(Integer process) {
    this.process = process;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.name, task.name) &&
        Objects.equals(this.deadline, task.deadline) &&
        Objects.equals(this.planedDate, task.planedDate) &&
        Objects.equals(this.description, task.description) &&
        Objects.equals(this.importance, task.importance) &&
        Objects.equals(this.entererAt, task.entererAt) &&
        Objects.equals(this.process, task.process);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, deadline, planedDate, description, importance, entererAt, process);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
    sb.append("    planedDate: ").append(toIndentedString(planedDate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    importance: ").append(toIndentedString(importance)).append("\n");
    sb.append("    entererAt: ").append(toIndentedString(entererAt)).append("\n");
    sb.append("    process: ").append(toIndentedString(process)).append("\n");
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

