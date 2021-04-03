package Enums;

public enum HighDegree {

    M("Master"),
    P("PhD");

    private String name;

    private HighDegree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
