package davenkin.cimonitor.repository;

import com.google.common.base.Predicate;
import davenkin.cimonitor.domain.Project;

import java.util.Set;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Sets.newHashSet;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/16/13
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultProjectRepository implements ProjectRepository {
    private Set<Project> projects = newHashSet();

    @Override
    public Project findProjectByName(final String name) {
        return from(projects).firstMatch(new Predicate<Project>() {
            @Override
            public boolean apply(Project project) {
                return name.equals(project.getName());
            }
        }).orNull();
    }

    @Override
    public Set<Project> getAllProjects() {
        return projects;
    }

    @Override
    public void addProject(Project project) {
        projects.add(project);
    }


}
