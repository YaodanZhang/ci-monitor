package davenkin.cimonitor.email;

import com.google.common.base.Predicate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;

import static com.google.common.collect.FluentIterable.from;

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
        return from(Arrays.asList(mimeMessage.getSubject().split(":|#|\u00bb|"))).filter(new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return !input.equalsIgnoreCase("Fwd");
            }
        }).get(1).trim();
    }

    protected boolean resolveProjectStatus(MimeMessage mimeMessage) throws MessagingException {
        return !(mimeMessage.getSubject().contains("failed") || mimeMessage.getSubject().contains("failing"));
    }

}
