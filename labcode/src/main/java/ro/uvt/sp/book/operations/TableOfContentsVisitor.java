package ro.uvt.sp.book.operations;

import ro.uvt.sp.book.Book;
import ro.uvt.sp.book.elements.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableOfContentsVisitor implements BookVisitor{

    private int pageCounter;
    private TableOfContents tableOfContents;
    private int sectionCounter=0, paragraphCounter=0, pictureCounter=0, tableCounter=0;
    public TableOfContentsVisitor()
    {
        pageCounter = 1;
        tableOfContents = new TableOfContents();

    }
    @Override
    public void visit(Section section) {

        this.tableOfContents.record(section.getTitle(), ++pageCounter);
    }

    @Override
    public void visit(Picture picture) {
        ++pictureCounter;
        this.tableOfContents.record(String.format("Figure %d",pictureCounter), ++pageCounter);
    }

    @Override
    public void visit(Paragraph paragraph) {
        ++paragraphCounter;
        this.tableOfContents.record(String.format("Paragraph %d",paragraphCounter), ++pageCounter);
    }

    @Override
    public void visit(Table table) {
        ++tableCounter;
        this.tableOfContents.record(String.format("Table %d", tableCounter), ++pageCounter);
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        ;
    }

    @Override
    public void visit(Book book) {
        this.tableOfContents.associate(book);
        book.add(tableOfContents);
    }

    public void printToc(){
        tableOfContents.print();
    }
}
