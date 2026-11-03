package ro.uvt.sp.book.elements;

import jakarta.persistence.*;
import ro.uvt.sp.book.operations.BookVisitor;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void print(){
        ;
    };
    public void accept(BookVisitor bookVisitor){
        ;
    }
}
