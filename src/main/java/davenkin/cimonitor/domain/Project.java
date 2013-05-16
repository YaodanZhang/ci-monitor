package davenkin.cimonitor.domain;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 5/16/13
 * Time: 6:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Project {
    private String name;

    private boolean success;

    private boolean changedToFailed;

    public Project(String name) {
        this.name = name;
    }

    public Project(Project ciProject) {
        name = ciProject.getName();
        success = ciProject.isSuccess();
        changedToFailed = ciProject.isChangedToFailed();
    }

    public String getName() {
        return name;
    }

    public void setChangedToFailed(boolean changedToFailed) {
        this.changedToFailed = changedToFailed;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        changedToFailed = !success;
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return name.equals(project.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public boolean isChangedToFailed() {
        return changedToFailed;
    }
}
