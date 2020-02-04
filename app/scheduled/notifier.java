package scheduled;

import play.jobs.*;

@Every("1h")
public class notifier extends Job {
    public void doJob() {
        SimpleEmail email = new SimpleEmail();
        email.setFrom("sender@zenexity.fr");
        email.addTo("recipient@zenexity.fr");
        email.setSubject("subject");
        email.setMsg("Message");
        Mail.send(email);
    }
}
