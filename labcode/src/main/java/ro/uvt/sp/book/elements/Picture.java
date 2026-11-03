package ro.uvt.sp.book.elements;

import ro.uvt.sp.book.operations.BookVisitor;

public abstract class Picture extends Element{

    @Override
    public void accept(BookVisitor visitor) {
        visitor.visit(this);
    }
}
