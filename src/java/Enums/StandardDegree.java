package Enums;

public enum StandardDegree {

    B("Bachelor"),
    I("International");

    private String name;

    private StandardDegree(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
