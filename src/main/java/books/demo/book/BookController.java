package books.demo.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/books")
public class BookController {

    
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer rating) {
        return bookService.filterBooks(title, author, year, rating);
    }

    @PostMapping("/{id}/rate")
    public ResponseEntity<Book> rateBook(@PathVariable Long id, @RequestParam int rating) {
        return ResponseEntity.ok(bookService.rateBook(id, rating));
    }

}

