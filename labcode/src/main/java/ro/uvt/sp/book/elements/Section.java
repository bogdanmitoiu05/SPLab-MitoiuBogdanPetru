package ro.uvt.sp.book.elements;

import java.util.Objects;

public class Section extends ElementContainer{

    private String title;

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
