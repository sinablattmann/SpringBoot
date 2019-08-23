package ch.noseryoung.plj.SpringBoot.User;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> getUserById(long id) {
    return userRepository.findById(id);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public void deleteUser(long id) {
    userRepository.delete(userRepository.findById(id).get());
  }

  public User updateUser(long id, String firstName, String lastName) {
    User user = userRepository.findById(id).get();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    userRepository.save(user);
    return user;
  }
}
