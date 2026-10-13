package ro.uvt.sp.book.elements;

import ro.uvt.sp.book.operations.BookVisitor;

public class TableOfContents implements Element{
    @Override
    public void print() {

    }

    @Override
    public void accept(BookVisitor bookVisitor) {
        bookVisitor.visit(this);
    }
}
