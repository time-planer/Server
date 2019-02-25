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
 * InlineResponse200
 */

public class InlineResponse200  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("user_key")
  private String userKey;

  public InlineResponse200 userKey(String userKey) {
    this.userKey = userKey;
    return this;
  }

  /**
   * Every user has an uniqe API key. Whith this Key you can access all datas and actions
   * @return userKey
  */
  @ApiModelProperty(value = "Every user has an uniqe API key. Whith this Key you can access all datas and actions")

@Pattern(regexp="^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).{500,1000}$") @Size(min=500,max=1000) 
  public String getUserKey() {
    return userKey;
  }

  public void setUserKey(String userKey) {
    this.userKey = userKey;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.userKey, inlineResponse200.userKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    userKey: ").append(toIndentedString(userKey)).append("\n");
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

