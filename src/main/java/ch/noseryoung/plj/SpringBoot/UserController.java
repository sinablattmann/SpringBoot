package ch.noseryoung.plj.SpringBoot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping("/createUser")
  public @ResponseBody ResponseEntity<String> postUser(@RequestBody User user) {
    return new ResponseEntity<String>(user.getFirstName(), HttpStatus.OK);

  }

}
