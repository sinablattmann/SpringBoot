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

  // localhost:8080/[parentMapping(users)]/[getMapping(thisIsMyGetMapping)]
  @GetMapping("/{id}")
  public @ResponseBody ResponseEntity<Optional<User>> getById(@PathVariable long id) {
    return new ResponseEntity<Optional<User>>(userService.getUserById(id), HttpStatus.OK);
  }

  @GetMapping({ "/", "" })
  public @ResponseBody ResponseEntity<List<User>> getAllUsers() {
    return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
  }

  @PostMapping("/createUser")
  public @ResponseBody ResponseEntity<User> postUser(@RequestBody User user) {
    return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public @ResponseBody ResponseEntity<Long> deleteUser(@PathVariable long id) {
    userService.deleteUser(id);
    return new ResponseEntity<Long>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}/{lastName}/{firstName}")
  public @ResponseBody ResponseEntity<User> updateUser(@PathVariable long id, @PathVariable String firstName,
      @PathVariable String lastName) {
    return new ResponseEntity<User>(userService.updateUser(id, firstName, lastName), HttpStatus.OK);
  }

}
