package ro.uvt.sp.book.elements;

import ro.uvt.sp.book.Page;

public interface AlignmentStrategy {
    void render(Paragraph paragraph, Page pageContext);
}
