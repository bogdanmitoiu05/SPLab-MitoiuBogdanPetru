package ro.uvt.sp.book.elements;

import ro.uvt.sp.book.Page;

public class AlignLeading implements AlignmentStrategy{
    @Override
    public void render(Paragraph paragraph, Page pageContext) {
        IO.println(String.format("Paragraph %s|", paragraph.getContent()));
    }
}
