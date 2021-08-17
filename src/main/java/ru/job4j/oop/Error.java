package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;

    }

    public void errorInfo() {
        System.out.println("Active error: " + active);
        System.out.println("Status error: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.errorInfo();
        Error bigError = new Error(true, 10, "Critical error!!!");
        bigError.errorInfo();
        Error noError = new Error(false, 0, "Ошибки нет.");
        noError.errorInfo();

    }
}
