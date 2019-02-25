package com.niton.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Detailed information about an Error
 */
@ApiModel(description = "Detailed information about an Error")

public class ErrorResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * A short description only a few words, what went wrong
   */
  public enum MessageEnum {
    API_KEY_MISSING("api key missing"),
    
    API_KEY_WRONG("api key wrong"),
    
    GROUP_NOT_FOUND("group not found"),
    
    GROUP_NOT_OWNED("group not owned"),
    
    NO_PASSWORD("no password"),
    
    NO_PERMISSION("no permission"),
    
    USER_NOT_FOUND("user not found"),
    
    PARAMS_NOT_MATCHING_PATTERN("params not matching pattern"),
    
    NO_EMAIL_ADDRESS("No email address"),
    
    WRONG_PASSWORD("wrong password"),
    
    USER_ALLREADY_EXISTS("User allready exists"),
    
    TASK_NOT_FOUND("task_not_found");

    private String value;

    MessageEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MessageEnum fromValue(String text) {
      for (MessageEnum b : MessageEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }
  }

  @JsonProperty("message")
  private MessageEnum message;

  public ErrorResponse message(MessageEnum message) {
    this.message = message;
    return this;
  }

  /**
   * A short description only a few words, what went wrong
   * @return message
  */
  @ApiModelProperty(required = true, value = "A short description only a few words, what went wrong")
  @NotNull


  public MessageEnum getMessage() {
    return message;
  }

  public void setMessage(MessageEnum message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponse errorResponse = (ErrorResponse) o;
    return Objects.equals(this.message, errorResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

