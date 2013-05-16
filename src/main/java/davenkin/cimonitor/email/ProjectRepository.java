package davenkin.cimonitor.email;

import com.google.common.base.Predicate;
import davenkin.cimonitor.domain.Project;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/16/13
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProjectRepository {
    private List<Project> projects = newArrayList();

    public Project findCiProjectByName(final String name) {
        return from(projects).firstMatch(new Predicate<Project>() {
            @Override
            public boolean apply(Project project) {
                return name.equals(project.getName());
            }
        }).orNull();
    }

    public List<Project> getAllCiProjects() {
        return projects;
    }

    public void addCiProject(Project project) {
        projects.add(project);
    }


}
