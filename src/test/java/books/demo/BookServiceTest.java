package books.demo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import books.demo.book.Book;
import books.demo.book.BookService;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetAllBooks() {
        List<Book> books = bookService.getAllBooks();
        assertNotNull(books);
        assertFalse(books.isEmpty());
    }
}
