package ro.uvt.sp.book.elements;

import jakarta.persistence.*;
import ro.uvt.sp.book.Book;
import ro.uvt.sp.book.operations.BookVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class TableOfContents extends Element{

    @OneToMany(cascade = CascadeType.ALL)
    private List<TableOfContentsEntry> index;
    @OneToOne
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public void print() {
        for(TableOfContentsEntry entry : index){
            IO.println(String.format("%s - %d",entry.getText(),entry.getPageNo()));
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
