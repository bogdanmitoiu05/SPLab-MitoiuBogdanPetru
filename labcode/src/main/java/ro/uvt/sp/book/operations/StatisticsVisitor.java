package ro.uvt.sp.book.operations;

import ro.uvt.sp.book.Book;
import ro.uvt.sp.book.elements.*;

import java.util.HashMap;
import java.util.Map;

public class StatisticsVisitor implements BookVisitor{

    private Map<String, Integer> itemCount;
    private static final String kSection = "Section";
    private static final String kParagraph = "Paragraph";
    private static final String kPicture = "Picture";
    private static final String kTable = "Table";

    private String bookTitle;
    private boolean _hasTableOfContents;
    public StatisticsVisitor(){
        itemCount = new HashMap<>();
        reset();

    }
    public void reset(){
        itemCount.put(kSection, 0);
        itemCount.put(kParagraph, 0);
        itemCount.put(kPicture, 0);
        itemCount.put(kTable, 0);
        _hasTableOfContents = false;
        bookTitle = "";
    }
    @Override
    public void visit(Book book){
        this.bookTitle = book.getTitle();
    }
    @Override
    public void visit(Section section) {
        itemCount.put(kSection, itemCount.get(kSection)+1);
    }

    @Override
    public void visit(Picture picture) {
        itemCount.put(kPicture, itemCount.get(kPicture)+1);
    }

    @Override
    public void visit(Paragraph paragraph) {
        itemCount.put(kParagraph, itemCount.get(kParagraph)+1);
    }

    @Override
    public void visit(Table table) {
        itemCount.put(kTable, itemCount.get(kTable)+1);
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        _hasTableOfContents = true;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public boolean hasTableOfContents() {
        return _hasTableOfContents;
    }

    public void printStats(){
        IO.println(String.format("Cartea %s are:\n%d sectiuni;\n%d paragrafe;\n%d imagini;\n%d tabele",
                bookTitle,
                itemCount.get(kSection),
                itemCount.get(kParagraph),
                itemCount.get(kPicture),
                itemCount.get(kTable)));
        IO.println(String.format("Cartea%s are cuprins", hasTableOfContents() ? "": " NU"));
    }
}
