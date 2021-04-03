package Enums;

public enum Gender {

    F("Female"),
    M("Male");

    private String name;

    private Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender(String name) {

        for (Gender gender : Gender.values()) {
            if (gender.getName() == name) {
                return gender.getName();
            }
        }
        return null;
    }

    public static Gender parse(String name) {
        Gender gender = null; // Default
        for (Gender item : Gender.values()) {
            if (item.getName() == name) {
                gender = item;
                break;
            }
        }
        return gender;
    }
}
