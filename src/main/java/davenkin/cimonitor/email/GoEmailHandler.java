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
public class GoEmailHandler extends AbstractEmailHandler {

    @Override
    public boolean canHandle(MimeMessage mimeMessage) throws MessagingException {
        return mimeMessage.getSubject().contains("Stage [");
    }

    protected String resolveProjectName(MimeMessage mimeMessage) throws MessagingException {
        return mimeMessage.getSubject().split("\\[|/")[1].trim();
    }

    protected boolean resolveProjectStatus(MimeMessage mimeMessage) throws MessagingException {
        String subject = mimeMessage.getSubject();
        return subject.contains("passed") || subject.contains("fixed");
    }

}
