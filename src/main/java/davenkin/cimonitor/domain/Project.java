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

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!name.equals(project.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
