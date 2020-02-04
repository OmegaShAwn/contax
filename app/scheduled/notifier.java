package scheduled;

import org.apache.commons.mail.*;
import play.jobs.*;
import play.libs.Mail;

@Every("1h")
public class notifier extends Job {
    public void doJob() throws EmailException{
        System.out.println("sending Email");
        SimpleEmail email = new SimpleEmail();
        email.setFrom("sender@zenexity.fr");
        email.addTo("receiver@email.com");
        email.setSubject("subject");
        email.setMsg("Message");
        Mail.send(email);
    }
}
