package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book nemo = new Book("Двадцать тысяч лье под водой", 320);
        Book kolobok = new Book("Колобок", 10);
        Book dieta = new Book("Кето диета", 200);
        Book clean = new Book("Clean code", 640);
        Book[] books = new Book[4];
        books[0] = nemo;
        books[1] = kolobok;
        books[2] = dieta;
        books[3] = clean;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " " + books[index].getNumberPage()
                    + " страниц");
        }
        Book  temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("После перестановки 0 - го и 3 - его элементов");
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " " + books[index].getNumberPage()
                    + " страниц");
        }
        System.out.println("Книги с названием \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println(books[index].getName() + " " + books[index].getNumberPage()
                        + " страниц");
            }
        }
    }
}
