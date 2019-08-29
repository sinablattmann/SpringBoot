package ch.noseryoung.plj.SpringBoot.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendMail")
public class MailController {

  private MailService mailService;

  @Autowired
  public MailController(MailService mailService) {
    this.mailService = mailService;
  }
  
  

}
