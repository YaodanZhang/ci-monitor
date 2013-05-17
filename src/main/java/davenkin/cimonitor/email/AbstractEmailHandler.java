package davenkin.cimonitor.email;

import davenkin.cimonitor.domain.Project;
import davenkin.cimonitor.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Required;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/17/13
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractEmailHandler implements EmailHandler {
    private ProjectRepository projectRepository;

    protected abstract String resolveProjectName(MimeMessage mimeMessage) throws MessagingException;
    protected abstract boolean resolveProjectStatus(MimeMessage mimeMessage) throws MessagingException;

    @Override
    public void handle(MimeMessage mimeMessage) throws MessagingException {
        String name = resolveProjectName(mimeMessage);
        Project project = getOrCreateProject(name);
        project.updateStatus(resolveProjectStatus(mimeMessage));

    }

    private Project getOrCreateProject(String name) {
        Project project = projectRepository.findProjectByName(name);

        if (project == null) {
            project = new Project(name);
            projectRepository.addProject(project);
        }
        return project;
    }

    @Required
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
