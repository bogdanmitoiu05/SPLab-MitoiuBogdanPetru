package ro.uvt.sp.book.elements;

import jakarta.persistence.*;
import ro.uvt.sp.book.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String surname;

    @ManyToMany
    private List<Book> books;

    public Author() {
        this.books = new ArrayList<>();
    }

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
