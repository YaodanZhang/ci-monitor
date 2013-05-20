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
public class JenkinsEmailHandler extends AbstractEmailHandler {

    @Override
    public boolean canHandle(MimeMessage mimeMessage) throws MessagingException {
        return mimeMessage.getSubject().contains("Jenkins");
    }

    protected String resolveProjectName(MimeMessage mimeMessage) throws MessagingException {
        String[] strings = mimeMessage.getSubject().split(":|#");
        return strings[strings.length - 2].trim();
    }

    protected boolean resolveProjectStatus(MimeMessage mimeMessage) throws MessagingException {
        return !mimeMessage.getSubject().contains("failed");
    }

}
