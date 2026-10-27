package ro.uvt.sp.book.elements;

import jakarta.persistence.Entity;
import ro.uvt.sp.book.operations.BookVisitor;

import java.util.Objects;

@Entity
public class Table extends Element{
    public String title;

    public Table() {

    }

    @Override
    public void print() {
        IO.println(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Table(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(title, table.title);
    }

    @Override
    public void accept(BookVisitor bookVisitor) {
        bookVisitor.visit(this);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
