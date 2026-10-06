package ro.uvt.sp.book.elements;

import ro.uvt.sp.book.Page;

import java.util.Objects;

public class Paragraph implements Element {

    private String content;
    private Page page; //TODO: move this to Element

    public AlignmentStrategy getAlignmentStrategy() {
        return alignmentStrategy;
    }

    public void setAlignmentStrategy(AlignmentStrategy alignmentStrategy) {
        this.alignmentStrategy = alignmentStrategy;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    private AlignmentStrategy alignmentStrategy;
    public Paragraph(String content, long page) {
        this.content = content;
        this.page = new Page(page);
        this.alignmentStrategy = new AlignLeading();
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
        alignmentStrategy.render(this, page);
    }
}
