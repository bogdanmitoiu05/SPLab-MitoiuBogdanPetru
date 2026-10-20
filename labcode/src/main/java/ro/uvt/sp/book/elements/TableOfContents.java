package ro.uvt.sp.book.elements;

import ro.uvt.sp.book.Book;
import ro.uvt.sp.book.operations.BookVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableOfContents implements Element{

    private List<TableOfContentsEntry> index;
    private Book book;
    @Override
    public void print() {
        for(TableOfContentsEntry entry : index){
            IO.println(String.format("%s - %d",entry.text(),entry.pageNo()));
        }
    }
    public TableOfContents(){
        index = new ArrayList<>();
    }
    public void associate(Book b){
        this.book = b;
    }
    public void record(String e, int pageNo){
        index.add(new TableOfContentsEntry(e,pageNo));
    }
    @Override
    public void accept(BookVisitor bookVisitor) {
        bookVisitor.visit(this);
    }
}
