package ru.job4j.stream.builder;

public class Student {
    private String name;
    private String surname;
    private int age;
    private String facultet;
    private int groupNumber;
    private int studentIdNumber;
    private String gender;
    private String formOfEducation;
    private boolean status;

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", facultet='" + facultet + '\''
                + ", groupNumber=" + groupNumber
                + ", studentIdNumber=" + studentIdNumber
                + ", gender='" + gender + '\''
                + ", formOfEducation='" + formOfEducation + '\''
                + ", status=" + status
                + '}';
    }

    static class Builder {
        private String name;
        private String surname;
        private int age;
        private String facultet;
        private int groupNumber;
        private int studentIdNumber;
        private String gender;
        private String formOfEducation;
        private boolean status;

        Builder builderName(String name) {
            this.name = name;
            return this;
        }

        Builder builderSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder builderAge(int age) {
            this.age = age;
            return this;
        }

        Builder builderFacultet(String facultet) {
            this.facultet = facultet;
            return this;
        }

        Builder builderGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        Builder builderStudentIdNumber(int studentIdNumber) {
            this.studentIdNumber = studentIdNumber;
            return this;
        }

        Builder builderGender(String gender) {
            this.gender = gender;
            return this;
        }

        Builder builderFormOfEducation(String formOfEducation) {
            this.formOfEducation = formOfEducation;
            return this;
        }

        Builder buildeStatus(Boolean status) {
            this.status = status;
            return this;
        }

        Student build() {
            Student student = new Student();
            student.name = name;
            student.surname = surname;
            student.age = age;
            student.facultet = facultet;
            student.groupNumber = groupNumber;
            student.studentIdNumber = studentIdNumber;
            student.gender = gender;
            student.formOfEducation = formOfEducation;
            student.status = status;
            return student;
        }
    }

    public static void main(String[] args) {
        Student student = new Builder().builderName("Vladimir")
                .builderSurname("Gorshkov")
                .builderAge(36)
                .builderFacultet("Electronics")
                .builderGroupNumber(1216)
                .builderGender("male")
                .builderFormOfEducation("full - time")
                .buildeStatus(true)
                .build();
        System.out.println(student);

    }
}

