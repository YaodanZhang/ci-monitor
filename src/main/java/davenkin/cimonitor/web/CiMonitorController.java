package davenkin.cimonitor.web;

import davenkin.cimonitor.domain.Project;
import davenkin.cimonitor.email.ProjectRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

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

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getProjects() throws IOException {
        List<Project> allCiProjects = projectRepository.getAllCiProjects();

        List<Project> returnProject = newArrayList();
        for (Project ciProject : allCiProjects) {
            returnProject.add(new Project(ciProject));
        }

        for (Project project1 : allCiProjects) {
            project1.setChangedToFailed(false);
        }

        return returnProject;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @Required
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
