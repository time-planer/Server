package com.niton.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.niton.db.tables.records.TaskRecord;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A reduced task for editing
 */
@ApiModel(description = "A reduced task for editing")

public class EditTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("deadline")
	private LocalDate deadline;

	@JsonProperty("planedDate")
	private LocalDate planedDate;

	@JsonProperty("description")
	private String description;

	@JsonProperty("importance")
	private Integer importance;

	public EditTask deadline(LocalDate deadline) {
		this.deadline = deadline;
		return this;
	}

	public EditTask description(String description) {
		this.description = description;
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EditTask editTask = (EditTask) o;
		return Objects.equals(deadline, editTask.deadline) && Objects.equals(planedDate, editTask.planedDate)
				&& Objects.equals(description, editTask.description) && Objects.equals(importance, editTask.importance);
	}

	/**
	 * The last date where it is totaly needs to be done.
	 * 
	 * @return deadline
	 */
	@ApiModelProperty(value = "The last date where it is totaly needs to be done.")

	@Valid

	public LocalDate getDeadline() {
		return deadline;
	}

	/**
	 * The description of the task
	 * 
	 * @return description
	 */
	@ApiModelProperty(value = "The description of the task")

	public String getDescription() {
		return description;
	}

	/**
	 * A google playstore like rating. it is from zero to ten. Each point describing
	 * a half star. 10 is the best as it is 5 Stars minimum: 0 maximum: 10
	 * 
	 * @return importance
	 */
	@ApiModelProperty(example = "4", value = "A google playstore like rating. it is from zero to ten. Each point describing a half star. 10 is the best as it is 5 Stars")

	@Min(0)
	@Max(10)
	public Integer getImportance() {
		return importance;
	}

	/**
	 * The date at which you planed to be done with the task
	 * 
	 * @return planedDate
	 */
	@ApiModelProperty(value = "The date at which you planed to be done with the task")

	@Valid

	public LocalDate getPlanedDate() {
		return planedDate;
	}

	public TaskRecord getSQL(TaskRecord r) {
		if(deadline != null)
			r.setDeadline(Date.valueOf(deadline));
		if(planedDate != null)
			r.setPlaneddate(Date.valueOf(planedDate));
		if(description != null)
			r.setDescription(description);
		return r;
	}	

	@Override
	public int hashCode() {
		return Objects.hash(deadline, planedDate, description, importance);
	}

	public EditTask importance(Integer importance) {
		this.importance = importance;
		return this;
	}

	public EditTask planedDate(LocalDate planedDate) {
		this.planedDate = planedDate;
		return this;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImportance(Integer importance) {
		this.importance = importance;
	}

	public void setPlanedDate(LocalDate planedDate) {
		this.planedDate = planedDate;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EditTask {\n");

		sb.append("    deadline: ").append(toIndentedString(deadline)).append("\n");
		sb.append("    planedDate: ").append(toIndentedString(planedDate)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    importance: ").append(toIndentedString(importance)).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
