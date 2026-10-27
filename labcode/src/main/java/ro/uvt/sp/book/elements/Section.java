package ro.uvt.sp.book.elements;

import jakarta.persistence.Entity;
import ro.uvt.sp.book.operations.BookVisitor;

import java.util.Objects;

@Entity
public class Section extends ElementContainer{

    private String title;

    public Section() {

    }

    @Override
    protected void beforePrint() {
        IO.println(title);
    }

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void accept(BookVisitor bookVisitor) {
        bookVisitor.visit(this);
        for(Element e : this.elementList){
            e.accept(bookVisitor);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(title, section.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
