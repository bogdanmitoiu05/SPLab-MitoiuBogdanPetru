package ro.uvt.sp.book.elements;

import java.util.Objects;

public class Paragraph implements Element {

    private String content;

    public Paragraph(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph = (Paragraph) o;
        return Objects.equals(content, paragraph.content);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public final void print() {
        IO.println(String.format("Paragraph %s",content));
    }
}
