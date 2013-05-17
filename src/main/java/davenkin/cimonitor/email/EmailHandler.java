package davenkin.cimonitor.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/17/13
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EmailHandler {
    public boolean canHandle(MimeMessage mimeMessage) throws MessagingException;

    public void handle(MimeMessage mimeMessage) throws MessagingException;
}
