package ro.uvt.sp.book;

import jakarta.persistence.*;
import ro.uvt.sp.book.elements.Author;
import ro.uvt.sp.book.elements.Element;
import ro.uvt.sp.book.elements.ElementContainer;
import ro.uvt.sp.book.elements.Section;
import ro.uvt.sp.book.operations.BookVisitor;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends Section
{
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL)

    private final List<Author> authorList;
    private String title;
    public Book(String title) {
        super(title);
        this.title = title;
        this.authorList = new ArrayList<>();
    }
    public Book(){
        super("");
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
    public void accept(BookVisitor bookVisitor){
        bookVisitor.visit(this);
        for(Element e : this.elementList){
            e.accept(bookVisitor);
        }
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
