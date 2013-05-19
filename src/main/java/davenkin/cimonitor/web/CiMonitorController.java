package davenkin.cimonitor.web;

import davenkin.cimonitor.domain.Project;
import davenkin.cimonitor.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    @ResponseBody
    public List<Project> getAllProjects() throws IOException {
        return getAndSortProjects();
    }

    private ArrayList<Project> getAndSortProjects() {
        ArrayList<Project> projects = new ArrayList<Project>();
        projects.addAll(projectRepository.getAllProjects());
        if (!projects.isEmpty()) {
            Collections.sort(projects, new Comparator<Project>() {
                @Override
                public int compare(Project o1, Project o2) {
                    return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
                }
            });
        }
        return projects;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "config", method = RequestMethod.GET)
    public String config() {
        return "config";
    }

   @RequestMapping(value = "music", method = RequestMethod.GET)
    public String music() {
        return "music";
    }

    @Required
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
