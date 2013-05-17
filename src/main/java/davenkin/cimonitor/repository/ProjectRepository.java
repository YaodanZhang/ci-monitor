package davenkin.cimonitor.repository;

import davenkin.cimonitor.domain.Project;

import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/17/13
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ProjectRepository {
    Project findProjectByName(String name);

    Set<Project> getAllProjects();

    void addProject(Project project);
}
