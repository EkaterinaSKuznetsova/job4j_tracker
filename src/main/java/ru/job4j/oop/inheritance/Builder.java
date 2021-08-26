package ru.job4j.oop.inheritance;

public class Builder extends Engineer {
    private String objectBuilder;

    public Builder(String name, String surname, String education, String birthday,
                   String company, String position, String objectBuilder) {
        super(name, surname, education, birthday, company, position);
        this.objectBuilder = objectBuilder;
    }

    public void setObjectBuilder(String objectBuilder) {
        this.objectBuilder = objectBuilder;
    }

    public String getObjectBuilder() {
        return this.objectBuilder;
    }

    public void buildRoof() {

    }

    public void buildFoundation() {

    }

    public void buildWall() {

    }

    public void build() {

    }
}
