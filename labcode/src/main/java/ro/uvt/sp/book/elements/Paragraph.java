package ro.uvt.sp.book.elements;

import jakarta.persistence.*;
import ro.uvt.sp.book.operations.BookVisitor;
import ro.uvt.sp.book.Page;

import java.util.Objects;

@Entity
public class Paragraph extends Element {

    private String content;
    @Transient
    private Page page; //TODO: move this to Element

    public Paragraph() {

    }

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


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alignment_strategy_id")
    private AlignmentStrategy alignmentStrategy;
    public Paragraph(String content, long page) {
        this.content = content;
        this.page = new Page(page);
        this.alignmentStrategy = new AlignLeading();
    }
    public Paragraph(String content){
        this(content, 80);
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
    public void accept(BookVisitor bookVisitor) {
        bookVisitor.visit(this);
    }

    @Override
    public final void print() {
        alignmentStrategy.render(this, page);
    }

}
