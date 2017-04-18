package com.coolCompany.restCRUD.controller;

import java.util.*;
import java.util.concurrent.Callable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.coolCompany.restCRUD.model.User;
import com.coolCompany.restCRUD.repository.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/api")
public class UserController
{
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private UserRepository repository;

  /**
   * Returns list of all users
   * 
   * @return list of users
   */
  @RequestMapping(value="/user/getAll", method= RequestMethod.GET)
  public List<User> getAll() 
  {
    return repository.findAll();
  }

  /**
   * Add a new user
   * @param User id
   * @return Container with user data load from the repository
   */    
  @RequestMapping(value="/user/get/{id}", method = RequestMethod.GET)
  public User get(@PathVariable long id) 
  {
    return repository.findOne(id);
  }
  
  /**
   * Add a new user
   * @param Container with user data
   * @return Container with user data save in the repository
   */  
  @RequestMapping(value="/user/create", method= RequestMethod.POST,  produces="application/json")
  public User create(@Validated @RequestBody User user) 
  {    
    logger.debug("Creating new user(name):" + user.getName());
    logger.debug("Creating new user(bithday):" + user.getBirthday());
    User model = new User();
    model.setBirthday(user.getBirthday());
    model.setName(user.getName());    
    return repository.saveAndFlush(model);
  }

  @RequestMapping(value="/user/update", method = RequestMethod.POST)
  public User update(@Validated @RequestBody User user) 
  {
    User model = repository.findOne(user.getId());
    logger.debug("Updating user(name):" + user.getName());
    logger.debug("Updating user(bithday):" + user.getBirthday());

    if (model != null) {
      model.setName(user.getName());
      model.setBirthday(user.getBirthday());
      return repository.saveAndFlush(model);
    }
    return null;
  }
  
  @RequestMapping(value= "/user/remove/{id}", method = RequestMethod.GET)
  public void delete(@PathVariable long id) 
  {
    repository.delete(id);
  }  

  /**
   * General for this class exception controller handler
   * @param Exception
   */  
  @ExceptionHandler
  public String handleException(Exception ex) 
  {
    return "Handled exception>>>: " + ex.getMessage();
  }
}
