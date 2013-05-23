package davenkin.cimonitor.repository;

import com.google.common.base.Predicate;
import com.google.gson.Gson;
import davenkin.cimonitor.domain.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
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
    private static Logger logger = LoggerFactory.getLogger(DefaultProjectRepository.class);
    private Set<Project> projects = newHashSet();
    public static final String CONFIG_FILE = System.getProperty("user.home") + System.getProperty("file.separator") + ".ci-projects.json";

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

    public void init() {
        try {
            BufferedReader configReader = new BufferedReader(new FileReader(CONFIG_FILE));
            Config config = new Gson().fromJson(configReader, Config.class);
            logger.info("Load config file from " + CONFIG_FILE);
            projects.addAll(config.getProjects());
        } catch (FileNotFoundException e) {
            logger.warn("No config file found.");
        }
    }

    public void cleanUp() throws IOException {
        FileWriter writer = new FileWriter(CONFIG_FILE);
        writer.write(new Gson().toJson(new Config(projects)));
        writer.close();
        logger.info("Save config file to " + CONFIG_FILE);
    }

}

class Config {
    private Set<Project> projects;

    Config(Set<Project> projects) {
        this.projects = projects;
    }

    Set<Project> getProjects() {
        return projects;
    }

    void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}

