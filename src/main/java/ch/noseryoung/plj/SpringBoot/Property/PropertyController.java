package ch.noseryoung.plj.SpringBoot.Property;

import org.springframework.beans.factory.annotation.Autowired;

import ch.noseryoung.plj.SpringBoot.User.UserService;

public class PropertyController {
  
  private UserService userService;
  
  @Autowired
  public PropertyController(UserService userService) {
    this.userService = userService;
  }

}
