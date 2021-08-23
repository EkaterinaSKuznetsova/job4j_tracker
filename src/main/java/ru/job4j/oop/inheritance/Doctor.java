package ru.job4j.oop.inheritance;

public class Doctor extends Profession {
    private String diagnoz;

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public void diagnozDetemine(Pacient pacient) {

    }

    public String diagnosticHeal(Pacient pacient) {
        return this.diagnoz;
    }

}
