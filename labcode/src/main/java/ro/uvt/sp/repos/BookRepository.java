package ro.uvt.sp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.sp.book.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> id(Long id);

    boolean existsBookById(Long id);

    Book getBookById(Long id);
}
