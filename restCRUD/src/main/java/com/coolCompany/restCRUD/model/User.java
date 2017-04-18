package com.coolCompany.restCRUD.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class User 
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column
  @NotNull(message = "error.field.notnull")
  @Size(min = 1, max = 30, message = "error.name.size")
  private String name;
  
  @Column
  @NotNull(message = "error.date.notnull")
  private Date birthday;

  //-- GETS, SETS-------------------------------------------------------------//
  public String getName() 
  {
    return name;
  }

  public void setName(String name) 
  {
    this.name = name;
  }

  public Date getBirthday() 
  {
    return birthday;
  }

  public void setBirthday(Date birthday) 
  {
    this.birthday = birthday;
  }

  public long getId() {
    return id;
  }


  @Override
  public String toString() 
  {
        return "User [id=" + id + ", name" + name + ", birthday=" + birthday + "]";
  }
}
