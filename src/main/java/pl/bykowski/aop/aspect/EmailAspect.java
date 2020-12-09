package pl.bykowski.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bykowski.aop.service.EmailService;

@Aspect
@Component
public class EmailAspect {

    private final EmailService emailService;

    @Autowired
    public EmailAspect(EmailService emailService) {
        this.emailService = emailService;
    }

    @After("@annotation(pl.bykowski.aop.aspect.SendEmailAspect)")
    private void sendEmail() {
        String to = "krokodyl101@o2.pl";
        String subject = "mail";
        String content = "dddd";
        emailService.sendEmail(to, subject, content);
    }

}
