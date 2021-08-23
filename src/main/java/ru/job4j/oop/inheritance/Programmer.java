package ru.job4j.oop.inheritance;

public class Programmer extends Engineer {
    public Programmer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public Program programming() {
        Program program = new Program();
        return program;
    }

    public boolean compilation() {
        return true;
    }

    public boolean debagging() {
        return false;
    }

    public void codding() {

    }

    public boolean testing() {
        return true;
    }


}
