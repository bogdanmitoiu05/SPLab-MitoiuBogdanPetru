package ro.uvt.sp.book.elements;

import java.util.Objects;

public class Author implements Element{
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    @Override
    public void print() {
        IO.println(String.format("Author: %s %s",name,surname));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(surname, author.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
