package ro.uvt.sp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.sp.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
