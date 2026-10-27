package ro.uvt.sp.book.elements;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TableOfContentsEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String text;

    public TableOfContentsEntry() {

    }

    public String getText() {
        return text;
    }

    public int getPageNo() {
        return pageNo;
    }

    int pageNo;

    public TableOfContentsEntry(String text, int pageNo) {
        this.text = text;
        this.pageNo = pageNo;
    }
}
