package ru.job4j.oop.inheritance;

public class Dantist extends Doctor {
    private int numberRoom;
    private String assistent;

    public Dantist(String name, String surname, String education, String birthday, String diagnoz,
                   int numberRoom, String assistent) {
        super(name, surname, education, birthday, diagnoz);
        this.assistent = assistent;
        this.numberRoom = numberRoom;
    }

    public void setNumberRoom(int number) {
        this.numberRoom = number;
    }

    public int getNumberRoom() {
        return this.numberRoom;
    }

    public void setAssistent(String assistent) {
        this.assistent = assistent;
    }

    public String getAssistent() {
        return this.assistent;
    }

    public void teethCleaning() {

    }

    public void removalTooth() {

    }

    public void toothFilling() {

    }

    public void dentalTreatment(Pacient pacient) {

    }
}
