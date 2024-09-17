package books.demo.book;

import java.lang.module.ResolutionException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> filterBooks(String title, String author, Integer year, Integer minRating) {
        if (title != null && author != null && year != null && minRating != null) {
            return bookRepository.findByTitleContainingAndAuthorContainingAndYearAndRating(title, author, year, minRating);
        } else if (title != null && author != null && year != null) {
            return bookRepository.findByTitleContainingAndAuthorContainingAndYear(title, author, year);
        } else if (title != null && author != null && minRating != null) {
            return bookRepository.findByTitleContainingAndAuthorContainingAndRating(title, author, minRating);
        } else if (title != null && year != null && minRating != null) {
            return bookRepository.findByTitleContainingAndYearAndRating(title, year, minRating);
        } else if (author != null && year != null && minRating != null) {
            return bookRepository.findByAuthorContainingAndYearAndRating(author, year, minRating);
        } else if (title != null && author != null) {
            return bookRepository.findByTitleContainingAndAuthorContaining(title, author);
        } else if (title != null && year != null) {
            return bookRepository.findByTitleContainingAndYear(title, year);
        } else if (title != null && minRating != null) {
            return bookRepository.findByTitleContainingAndRating(title, minRating);
        } else if (author != null && year != null) {
            return bookRepository.findByAuthorContainingAndYear(author, year);
        } else if (author != null && minRating != null) {
            return bookRepository.findByAuthorContainingAndRating(author, minRating);
        } else if (year != null && minRating != null) {
            return bookRepository.findByYearAndRating(year, minRating);
        } else if (title != null) {
            return bookRepository.findByTitleContaining(title);
        } else if (author != null) {
            return bookRepository.findByAuthorContaining(author);
        } else if (year != null) {
            return bookRepository.findByYear(year);
        } else if (minRating != null) {
            return bookRepository.findByRating(minRating);
        } else {
            return getAllBooks();
        }
    }
    

    public Book rateBook(Long id, int rating) {
        if (rating < 1.0 || rating > 5.0) {
            throw new ResolutionException("Rating must be between 1 and 5");
        }
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResolutionException("Book not found"));
        book.setRating(rating);
        return bookRepository.save(book);
    }

    
}

