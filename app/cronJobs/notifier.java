package cronJobs;

import models.User;
import org.apache.commons.mail.*;
import play.jobs.*;
import play.libs.Mail;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Every("1h")
public class notifier extends Job {
    public void doJob() throws EmailException {
        // fetches all the users
        List<User> users = User.findAll();
        for (User user: users) {
            Integer notifyBefore = user.getNotifyBefore();
            if (notifyBefore == null) continue;

            // gets the time a friend has to have his/her birthday at to send a notification.
            Date now = new Date();
            now.setHours(0);
            now.setMinutes(0);
            now.setSeconds(0);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(now);
            calendar.add(Calendar.HOUR_OF_DAY, notifyBefore);
            List<User> friends = user.getFriends();

            for (User friend: friends) {
                // sends an email if the friend has the birthday at the calculated date.
                if (friend.getDateOfBirth().equals(calendar.getTime())) {
                    SimpleEmail email = new SimpleEmail();
                    email.setFrom("ctxadmin@contax.com");
                    email.addTo(user.getUsername());
                    email.setSubject("BirthDay Reminder");
                    email.setMsg("Your friend " + friend.getUsername() + " has his/her birthday in " + notifyBefore + " hours");
                    Mail.send(email);
                }
            }
        }
    }
}
