package com.niton.model;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ### Requirements * Name * Email * Password
 */
@ApiModel(description = "### Requirements * Name * Email * Password")

public class RegistrationRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("name")
  private String name;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  public RegistrationRequest() {
	System.out.println("Created Registration body object");
//	new Exception().printStackTrace();
}
  
  public RegistrationRequest email(String email) {
    this.email = email;
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
    RegistrationRequest registrationRequest = (RegistrationRequest) o;
    return Objects.equals(name, registrationRequest.name) &&
        Objects.equals(email, registrationRequest.email) &&
        Objects.equals(password, registrationRequest.password);
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(example = "nbrugger@studnet.tgm.ac.at", required = true, value = "")
  @NotNull

  @Size(min=7,max=320) 
  public String getEmail() {
    return email;
  }

  /**
   * The name of an user.  unique
   * @return name
  */
  @ApiModelProperty(required = true, value = "The name of an user.  unique")
  @NotNull


  public String getName() {
    return name;
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

  @Override
  public int hashCode() {
    return Objects.hash(name, email, password);
  }

  public RegistrationRequest name(String name) {
    this.name = name;
    return this;
  }

  public RegistrationRequest password(String password) {
    this.password = password;
    return this;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
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
    sb.append("class RegistrationRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}

