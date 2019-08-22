package ch.noseryoung.plj.SpringBoot;

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
  
  

  // localhost:8080/[parentMapping(users)]/[getMapping(thisIsMyGetMapping)]
  @GetMapping("/{id}")
  public @ResponseBody ResponseEntity<User> getById(@PathVariable long id) {
    return new ResponseEntity<User>(new User("Sina", "Blattmann", id), HttpStatus.OK);
  }
  
  @GetMapping("/getAllUsers")
  public @ResponseBody ResponseEntity<User[]> getAllUsers() {
    User[] userList = {new User("Seb", "Stan", 12), new User("Len", "Blattmann", 12)};
    return new ResponseEntity<User[]>(userList, HttpStatus.OK);
  }

  @PostMapping("/createUser")
  public @ResponseBody ResponseEntity<User> postUser(@RequestBody User user) {
    return new ResponseEntity<User>(user, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public @ResponseBody ResponseEntity<Long> deleteUser(@PathVariable long id) {
    return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public @ResponseBody ResponseEntity<Long> updateUser(@PathVariable long id) {
    return new ResponseEntity<Long>(id, HttpStatus.OK);
  }
}
