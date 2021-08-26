package ru.job4j.oop.inheritance;

public class Surgeon extends Doctor {
    private String otdelenie;

    public Surgeon(String name, String surname, String education, String birthday,
                   String diagnoz, String otdelenie) {
        super(name, surname, education, birthday, diagnoz);
        this.otdelenie = otdelenie;
    }

    public void osmotr() {

    }

    public void operation() {

    }

    public void bandaging() {

    }

    public void surgicalTreatment(Pacient pacient) {

    }

}
