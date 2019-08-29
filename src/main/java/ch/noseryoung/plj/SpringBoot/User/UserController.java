package ch.noseryoung.plj.SpringBoot.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * This method returns a User with a specific ID
   * 
   * @param id
   * @return ResponseEntity with the requested User
   */
  @GetMapping({ "/{id}", "/{id}/" })
  public @ResponseBody ResponseEntity<Optional<User>> getById(@PathVariable long id) {
    return new ResponseEntity<Optional<User>>(userService.getUserById(id), HttpStatus.OK);
  }

  /**
   * This method returns all the saved Users from the DB
   * 
   * @return ResponseEntity with a List containing all the Users
   */
  @GetMapping({ "/", "" })
  public @ResponseBody ResponseEntity<List<User>> getAllUsers() {
    return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
  }

  /**
   * This method creates a new User 
   * 
   * @param user
   * @return ResponseEntity with the saved User and its new unique ID
   */
  @PostMapping({ "/createUser", "/createUser/" })
  public @ResponseBody ResponseEntity<User> postUser(@RequestBody User user) {
    return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
  }

  /**
   * This method deletes an existing User
   * 
   * @param id
   * @return ResponseEntity without any content
   */
  @DeleteMapping({ "/{id}", "/{id}/" })
  public @ResponseBody ResponseEntity<Long> deleteUser(@PathVariable long id) {
    userService.deleteUser(id);
    return new ResponseEntity<Long>(HttpStatus.NO_CONTENT);
  }

  /**
   * This method updates a user's data
   * 
   * @param id
   * @param firstName
   * @param lastName
   * @return ResponseEntity with the updated User 
   */
  @PutMapping({ "/{id}/{lastName}/{firstName}", "/{id}/{lastName}/{firstName}/" })
  public @ResponseBody ResponseEntity<User> updateUser(@PathVariable long id, @PathVariable String firstName,
      @PathVariable String lastName) {
    return new ResponseEntity<User>(userService.updateUser(id, firstName, lastName), HttpStatus.OK);
  }
}
