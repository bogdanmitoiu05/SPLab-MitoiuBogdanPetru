package ro.uvt.sp.book.elements;

import ro.uvt.sp.book.operations.BookVisitor;

public interface Element {
    void print();
    void accept(BookVisitor bookVisitor);
}
