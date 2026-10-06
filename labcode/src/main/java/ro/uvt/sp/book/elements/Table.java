package ro.uvt.sp.book.elements;

import java.util.Objects;

public class Table implements Element{
    public String title;
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
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
