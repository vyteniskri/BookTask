package books.demo.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByYear(Integer year);
    List<Book> findByRating(Integer rating);

    List<Book> findByTitleContainingAndAuthorContaining(String title, String author);
    List<Book> findByTitleContainingAndYear(String title, Integer year);
    List<Book> findByTitleContainingAndRating(String title, Integer rating);
    List<Book> findByAuthorContainingAndYear(String author, Integer year);
    List<Book> findByAuthorContainingAndRating(String author, Integer rating);
    List<Book> findByYearAndRating(Integer year, Integer rating);

    List<Book> findByTitleContainingAndAuthorContainingAndYear(String title, String author, Integer year);
    List<Book> findByTitleContainingAndAuthorContainingAndRating(String title, String author, Integer rating);
    List<Book> findByTitleContainingAndYearAndRating(String title, Integer year, Integer rating);
    List<Book> findByAuthorContainingAndYearAndRating(String author, Integer year, Integer rating);

    List<Book> findByTitleContainingAndAuthorContainingAndYearAndRating(String title, String author, Integer year, Integer rating);
}