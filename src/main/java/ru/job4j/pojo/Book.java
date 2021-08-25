package ru.job4j.pojo;

public class Book {
    private String name;
    private int numberPage;

    public Book(String name, int numberPage) {
        this.name = name;
        this.numberPage = numberPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }
}
