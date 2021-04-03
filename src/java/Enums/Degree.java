package Enums;

public enum Degree {

    D("Diplom"),
    B("Bachelor"),
    M("Master");

    private String name;

    private Degree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
