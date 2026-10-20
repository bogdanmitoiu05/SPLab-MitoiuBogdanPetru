package ro.uvt.sp.book.operations;

import ro.uvt.sp.book.Book;
import ro.uvt.sp.book.elements.*;

public interface BookVisitor {
    void visit(Section section);
    void visit(Picture picture);
    void visit(Paragraph paragraph);
    void visit(Table table);
    void visit(TableOfContents tableOfContents);
    void visit(Book book);
}
