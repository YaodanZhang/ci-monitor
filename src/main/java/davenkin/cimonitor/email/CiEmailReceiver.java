package davenkin.cimonitor.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/16/13
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class CiEmailReceiver {
    public void receive(MimeMessage mimeMessage) throws MessagingException {
        System.out.println("message received");
        String subject = mimeMessage.getSubject();
        String encoding = mimeMessage.getEncoding();
        System.out.println(encoding);
        System.out.println(subject);
    }
}
