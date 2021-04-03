package Enums;

public enum Status {

    L("Leavers"),
    C("Comers");

    private Status(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
