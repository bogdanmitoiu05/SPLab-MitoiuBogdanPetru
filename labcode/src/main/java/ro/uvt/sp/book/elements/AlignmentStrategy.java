package ro.uvt.sp.book.elements;

import jakarta.persistence.*;
import ro.uvt.sp.book.Page;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AlignmentStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void render(Paragraph paragraph, Page pageContext){};
}
