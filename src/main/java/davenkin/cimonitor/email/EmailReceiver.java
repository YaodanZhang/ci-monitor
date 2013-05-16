package davenkin.cimonitor.email;

import davenkin.cimonitor.domain.Project;
import org.springframework.beans.factory.annotation.Required;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/16/13
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmailReceiver {
    private ProjectRepository projectRepository;

    public void receive(MimeMessage mimeMessage) throws MessagingException {
        if (!isCiProject(mimeMessage)) {
            return;
        }

        String name = resolveProjectName(mimeMessage);
        Project project = projectRepository.findCiProjectByName(name);
        if (project == null) {
            project = new Project(name);
            projectRepository.addCiProject(project);
        }

        boolean status = resolveProjectStatus(mimeMessage);
        project.setSuccess(status);
    }

    private boolean isCiProject(MimeMessage mimeMessage) {
        return true;
    }

    private boolean resolveProjectStatus(MimeMessage mimeMessage) throws MessagingException {
        return mimeMessage.getSubject().contains("session");  //To change body of created methods use File | Settings | File Templates.
    }

    private String resolveProjectName(MimeMessage mimeMessage) throws MessagingException {
        return mimeMessage.getSubject();
    }

    @Required
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
