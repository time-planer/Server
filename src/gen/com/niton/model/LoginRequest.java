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
 * The Credentials of the  user * Password * Email
 */
@ApiModel(description = "The Credentials of the  user * Password * Email")

public class LoginRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  public LoginRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LoginRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * # Password   * Min length: 8   * Max Length : 40   * At least one small capitalized char   * One upper case char   * pattern : \"(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9!$%&/()\\\\=?}\\]\\[{\\.]+\"
   * @return password
  */
  @ApiModelProperty(required = true, value = "# Password   * Min length: 8   * Max Length : 40   * At least one small capitalized char   * One upper case char   * pattern : \"(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9!$%&/()\\\\=?}\\]\\[{\\.]+\"")
  @NotNull

@Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9!$%&/()\\\\=?}\\]\\[{\\.]+") @Size(min=8,max=40) 
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginRequest loginRequest = (LoginRequest) o;
    return Objects.equals(this.email, loginRequest.email) &&
        Objects.equals(this.password, loginRequest.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginRequest {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

