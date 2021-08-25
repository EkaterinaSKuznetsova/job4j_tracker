package ru.job4j.pojo;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student ivanov = new Student();
        ivanov.setFio("Иванов Александр Станиславович");
        ivanov.setNumberGroup(1216);
        ivanov.setStart(new Date());
        System.out.println(ivanov.getFio() + " номер группы № "
                + ivanov.getNumberGroup() + " дата поступления " + ivanov.getStart());
    }
}