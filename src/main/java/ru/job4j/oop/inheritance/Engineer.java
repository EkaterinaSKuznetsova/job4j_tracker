package ru.job4j.oop.inheritance;

public class Engineer extends Profession {
    private String company;
    private String position;

    public Engineer(String name, String surname, String education, String birthday,
                    String company, String position) {
        super(name, surname, education, birthday);
        this.company = company;
        this.position = position;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return this.company;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void work() {

    }
}
