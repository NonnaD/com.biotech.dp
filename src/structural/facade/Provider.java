package structural.facade;

public class Provider {

    private String name;
    private Long id;
    private boolean hasPermission;

    public Provider(Long id) {
        this.id = id;
    }

    public boolean isHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }
}
