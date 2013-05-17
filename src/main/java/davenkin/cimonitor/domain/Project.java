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
    private boolean isSuccess;
    private int notificationCount;

    public Project(String name) {
        this.name = name;
    }

    public Project(Project ciProject) {
        name = ciProject.getName();
        isSuccess = ciProject.isSuccess();
    }

    public void updateStatus(boolean isSuccess) {
        this.isSuccess = isSuccess;
        notificationCount++;
    }

    public String getName() {
        return name;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getNotificationCount() {
        return notificationCount;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && name.equals(((Project) o).name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
