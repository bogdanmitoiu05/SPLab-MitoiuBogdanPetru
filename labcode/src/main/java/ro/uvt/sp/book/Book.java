package ro.uvt.sp.book;

import ro.uvt.sp.book.elements.Author;
import ro.uvt.sp.book.elements.ElementContainer;

import java.util.ArrayList;
import java.util.List;

public class Book extends ElementContainer
{
    private final List<Author> authorList;
    private String title;

    public Book(String title) {
        this.title = title;
        this.authorList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addAuthor(Author author){
        authorList.add(author);
    }

    @Override
    protected void beforePrint() {
        IO.println(String.format("Book %s",title));
        IO.println();
        IO.println("Authors");
        for (var author: authorList) {
            author.print();
        }
    }
}
