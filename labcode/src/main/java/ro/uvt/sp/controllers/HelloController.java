package ro.uvt.sp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
import ro.uvt.sp.book.Book;
import ro.uvt.sp.book.elements.*;
import ro.uvt.sp.book.operations.TableOfContentsVisitor;
import ro.uvt.sp.components.ClientComponent;
import ro.uvt.sp.repos.BookRepository;

@RestController
public record HelloController(ClientComponent clientComponent, BookRepository bookRepository) {


    @PostMapping("/createBook")
    public Book createBook(){
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));

        Book myBook = new Book("Carte");
        myBook.add(cap1);
        TableOfContentsVisitor tableOfContentsVisitor = new TableOfContentsVisitor();
        myBook.accept(tableOfContentsVisitor);

        bookRepository.save(myBook);

        return myBook;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id){
        if(bookRepository.existsBookById(id)){
            return bookRepository.getBookById(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");

    }

    @PutMapping("/books/{id}")
    public void updateBookById(@PathVariable Long id, @RequestBody Book book){
        if(!bookRepository.existsBookById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
        bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable Long id){
        if(!bookRepository.existsBookById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
        bookRepository.deleteById(id);
    }

    @GetMapping("/")
    public String sayHi(){
        return "Hello from ClientComponent "+clientComponent;
    }
}
