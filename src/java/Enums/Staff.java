package Enums;

public enum Staff {
    
    P("Professor"),
    A("Associate Professor"),
    AP("Assistant Professor"),
    T("Teaching Assistant"),
    R("Research Assistant");

    private String name;

    private Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
