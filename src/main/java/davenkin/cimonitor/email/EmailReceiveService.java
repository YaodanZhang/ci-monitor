package davenkin.cimonitor.email;

import davenkin.cimonitor.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/16/13
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmailReceiveService {
    private static Logger logger = LoggerFactory.getLogger(EmailReceiveService.class);
    private List<EmailHandler> emailHandlers;


    public void receive(MimeMessage mimeMessage) throws MessagingException {
        logger.info("Received email: " + mimeMessage.getSubject());

        for (EmailHandler emailHandler : emailHandlers) {
            if (emailHandler.canHandle(mimeMessage)) {
                emailHandler.handle(mimeMessage);
                return;
            }
        }
    }

    @Required
    public void setEmailHandlers(List<EmailHandler> emailHandlers) {
        this.emailHandlers = emailHandlers;
    }
}
