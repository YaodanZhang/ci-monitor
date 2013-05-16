package davenkin.cimonitor.web;

import davenkin.cimonitor.domain.Project;
import davenkin.cimonitor.email.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/16/13
 * Time: 6:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class CiMonitorController {
    private ProjectRepository projectRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Project> processRequest() throws IOException {
        return projectRepository.getAllCiProjects();
    }

    @Required
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
